package cn.coolwj.cicd;
/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the god animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.maven.artifact.ArtifactUtils;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Nigel Lee
 * @date 2022/8/3
 */
public class CicdExecutor extends CicdConfig {

    public static void main(String[] args) throws Exception {
        execute();
    }

    /**
     * 执行程序
     *
     * @throws Exception
     */
    public static void execute() throws Exception {
        String[] params = readParam();
        System.out.println("本次任务执行的参数：" + JSONObject.toJSONString(params));
        System.out.println("🐶开始执行任务");

        int operate = Integer.parseInt(params[0]);
        String projectName = params[1];
        if (operate == DEPLOY_BRANCH) {
            String cicdGitBranch = params[2];
            String envType = params[3];
            String token = buildArgoToken(envType);
            Headers argoHeaders = new Headers.Builder().add("cookie", "argocd.token=" + token).build();
            List<Future<String>> futures = new ArrayList<>();
            for (CicdJob job : CICD_JOB_LIST) {
                if (StringUtils.isEmpty(projectName) && job.isMutexWithZeroProject()) {
                    continue;
                }
                if (StringUtils.isNotEmpty(projectName)) {
                    if (projectName.equals("-1")) {
                        if (job.isServer()) {
                            continue;
                        }
                    } else if (projectName.equals("-2")) {
                        if (!job.isServer()) {
                            continue;
                        }
                    } else {
                        if (!projectName.equals(job.getId().toString())) {
                            continue;
                        }
                    }
                }
                try {
                    Stopwatch start = Stopwatch.createStarted();
                    System.out.println("开始部署执行工程" + job.getName());
                    deploy(job, cicdGitBranch, envType, argoHeaders, futures);
                    System.out.println("结束部署执行工程" + job.getName() + ",耗时：" + start + "\n");
                } catch (Exception ignored) {
                }
            }
            for (Future<String> future : futures) {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

        } else {
            for (CicdProject project : PROJECT_LIST) {
                if (notRun(projectName, project.getId(), project.getName())) {
                    continue;
                }
                System.out.println("开始处理项目" + project.getName());
                switch (operate) {

                    case CREATE_BRANCH: {
                        String sourceBranch = params[2], targetBranch = params[3];
                        newBranch(project, sourceBranch, targetBranch);
                        System.out.println();
                        break;
                    }

                    case UPGRADE_VERSION: {
                        String version = params[2];
                        String type = params[3];
                        gitVersion(project, version, type);
                        break;
                    }

                    case CLEAN_BRANCH: {
                        String branch = params[2];
                        List<String> branches = Splitter.on(" ").trimResults().splitToList(branch);
                        List<String> branchList = new ArrayList<>();
                        for (String br : branches) {
                            if ((br.startsWith("dev-") || br.startsWith("bugfix-")) && br.endsWith("-")) {
                                JSONArray list = queryBranchList(project, br);
                                for (Object obj : list) {
                                    String name = ((JSONObject) obj).getString("name");
                                    branchList.add(name);
                                }
                            } else {
                                branchList.add(br);
                            }
                        }
                        for (String tb : branchList) {
                            boolean isTag = "1".equals(params[3]);
                            if (isTag) {
                                newTag(project, tb);
                            }
                            cleanBranch(project, tb);
                        }
                        System.out.println();
                        break;
                    }

                    default: {
                        String sourceBranch = params[2], targetBranch = params[3];
                        //查询请求，如有，就关闭了
                        queryMergeListWithClose(project);
                        //创建MR
                        String iid = createMerge(project, sourceBranch, targetBranch);
                        sleep(project.getSleep());
                        //确认MR
                        confirmMerge(project, iid);
                    }
                }

                System.out.println("结束处理项目" + project.getName());
                System.out.println();
            }
        }

        System.exit(-1);
    }

    private static void deploy(CicdJob job, String cicdGitBranch, String envType, Headers argoHeaders, List<Future<String>> futures) throws Exception {
        String cicdJobBuildNum = build(job, cicdGitBranch, envType);
        if (job.isDeploy()) {
            List<String> envList = ENV_MAP.get(envType);
            boolean isDeployEnv = envType.startsWith("gray") || envType.startsWith("pre");
            for (String env : envList) {
                if (isDeployEnv) {
                    String url = String.format(CICD_BUILD, String.format(CICD_JOB_DEPLOY, envType, job.getName()));
                    String json = CICD_COMMON_DEPLOY_PARAM.replace("{{cicdJobBuildNum}}", cicdJobBuildNum).replace("{{cicdDeployEnv}}", env);
                    runJob(url, json);
                }
                Callable<String> task = () -> {
                    try {
                        return checkArgo(job.getName(), env, argoHeaders);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                };
                futures.add(EXECUTOR_SERVICE.submit(task));
            }
        }
    }


    private static String checkArgo(String job, String envType, Headers argoHeaders) throws Exception {
        Stopwatch start = Stopwatch.createStarted();
        String url = String.format(ENV_ARGO.get(envType) + "/api/v1/applications/hecomcloud-%s-%s/resource-tree", envType, job);
        boolean allSuccess;
        do {
            sleep(30);

            System.out.println("请求地址：" + url);
            Request request = new Request.Builder().url(url).headers(argoHeaders).get().build();
            Response response = CLIENT.newCall(request).execute();
            String resultStr = Objects.requireNonNull(response.body()).string();
            System.out.println("响应结果：" + resultStr);
            JSONObject result = JSONObject.parseObject(resultStr);

            List<Boolean> resultList = new ArrayList<>();
            JSONArray nodes = result.getJSONArray("nodes");
            for (int i = 0; i < nodes.size(); i++) {
                JSONObject node = nodes.getJSONObject(i);
                String kind = node.getString("kind");
                if ("Pod".equals(kind)) {
                    String name = node.getString("name");
                    String health = node.getJSONObject("health").getString("status");
                    System.out.println(name + " -> " + health);
                    resultList.add("Healthy".equals(health));
                }
            }
            System.out.println(job + " argo 已耗时:" + (start));

            allSuccess = allTrue(resultList);
        } while (!allSuccess);

        return job + " argo部署完成，累计耗时:" + (start);
    }


    private static String buildArgoToken(String envType) throws Exception {
        if (ARGO_TOKEN == null) {
            System.out.println("开始获取Agro授权信息");
            String url = ENV_ARGO.get(envType) + "/api/v1/session";
            System.out.println("请求地址：" + url);
            JSONObject param = new JSONObject();
            param.put("username", "alice");
            param.put("password", "alice2022");
            RequestBody body = RequestBody.create(JSON, param.toJSONString());
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = CLIENT.newCall(request).execute();
            String resultStr = Objects.requireNonNull(response.body()).string();
            System.out.println("响应结果：" + resultStr);
            JSONObject result = JSONObject.parseObject(resultStr);
            ARGO_TOKEN = result.getString("token");
            System.out.println("已经获取Agro授权信息：" + ARGO_TOKEN);
        }
        return ARGO_TOKEN;
    }

    private static String build(CicdJob job, String cicdGitBranch, String envType) throws Exception {
        String jobName = job.isShortName() ? String.format(CICD_JOB_BUILD, envType, job.getName()) : job.getName();
        String url = String.format(CICD_BUILD, jobName);
        String json = String.format(job.getParam(), job.getBranchStart() + cicdGitBranch);
        runJob(url, json);
        return checkJob(jobName);
    }

    private static void runJob(String url, String json) throws Exception {
        System.out.println("请求地址：" + url);
        System.out.println("请求参数：" + json);
        FormBody formBody = new FormBody.Builder().add("json", json).build();
        Request request = new Request.Builder().url(url).headers(CICD_HEADERS).post(formBody).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println("响应结果：" + resultStr);
    }


    private static String checkJob(String cicdJobName) {
        while (true) {
            try {

                sleep(10);

                String url = String.format(CICD_API_JSON, cicdJobName);
                Request request = new Request.Builder().url(url).headers(CICD_HEADERS).build();
                Response response = CLIENT.newCall(request).execute();
                String resultStr = Objects.requireNonNull(response.body()).string();
                System.out.println(resultStr);
                JSONObject jsonData = JSONObject.parseObject(resultStr);

                JSONObject lastBuild = jsonData.getJSONObject("lastBuild");
                String lastBuildNum = lastBuild.getString("number");
                JSONObject lastSuccessfulBuild = jsonData.getJSONObject("lastSuccessfulBuild");
                String lastSuccessfulBuildNum = lastSuccessfulBuild.getString("number");

                if (lastBuildNum.equals(lastSuccessfulBuildNum)) {
                    System.out.println(cicdJobName + "任务已执行结束, buildNum -> " + lastBuildNum + " successNum -> " + lastSuccessfulBuildNum);
                    return lastSuccessfulBuildNum;
                }

                if (cicdJobName.equals("job/sdk-hecom/job/32-编择打包脚手架")) {
                    url = String.format(CICD_WFAPI_JSON, cicdJobName, lastBuildNum, System.currentTimeMillis());
                    System.out.println(url);
                    request = new Request.Builder().url(url).headers(CICD_HEADERS).build();
                    response = CLIENT.newCall(request).execute();
                    resultStr = Objects.requireNonNull(response.body()).string();
                    //System.out.println(resultStr);
                    JSONArray array = JSONArray.parseArray(resultStr);
                    JSONObject task = array.getJSONObject(0);
                    JSONArray stages = task.getJSONArray("stages");
                    for (Object obj : stages) {
                        JSONObject json = (JSONObject) obj;
                        System.out.println(json.getString("name") + " -> " + json.getString("status") + " 已耗时：" + (double) json.getLong("durationMillis") / 1000 + "s");
                    }
                }

                url = String.format(CICD_LAST_BUILD_API_JSON, cicdJobName);
                request = new Request.Builder().url(url).headers(CICD_HEADERS).build();
                response = CLIENT.newCall(request).execute();
                resultStr = Objects.requireNonNull(response.body()).string();
                jsonData = JSONObject.parseObject(resultStr);

                long now = System.currentTimeMillis();
                long start = jsonData.getLong("timestamp");
                long cost = now - start;
                long estimated = jsonData.getLong("estimatedDuration");
                System.out.println(cicdJobName
                        + " buildNum -> " + lastBuildNum
                        + " successNum -> " + lastSuccessfulBuildNum
                        + " now: " + now
                        + " start:" + start
                        + " cost:" + cost
                        + " estimated:" + estimated
                        + " complete: " + (cost * 100 / estimated) + "%"
                );
            } catch (Exception ignored) {

            }
        }
    }

    /**
     * 修改版本号
     *
     * @param version
     * @param project
     * @throws IOException
     * @throws XmlPullParserException
     */
    private static void gitVersion(CicdProject project, String version, String type) throws IOException, XmlPullParserException {
        for (String dir : project.getPomDirList()) {
            String pomDir = LOCAL_GIT_DIR + "/" + project.getName() + dir;
            String pomPath = pomDir + "/pom.xml";
            System.out.println("解析文件" + pomPath);
            File pomFile = new File(pomPath);
            if (!pomFile.exists()) {
                pomDir = LOCAL_GIT_DIR + "/" + project.getAlisa() + dir;
                pomPath = pomDir + "/pom.xml";
                System.out.println("解析文件" + pomPath);
                pomFile = new File(pomPath);
                if (!pomFile.exists()) {
                    throw new RuntimeException("无法找到文件" + pomFile);
                }
            }

            //备份文件
            FileUtils.copyFile(pomFile, new File(pomPath + ".bak"));
            List<String> pomLines = FileUtils.readLines(pomFile);
            FileInputStream fis = new FileInputStream(pomFile);
            MavenXpp3Reader reader = new MavenXpp3Reader();
            Model model = reader.read(fis);

            //替换版本号
            buildMainVersion(model, version, type, pomLines);
            buildProperties(model, version, type, pomLines);

            //写入文件
            FileUtils.writeLines(pomFile, pomLines);
        }
    }

    private static void buildMainVersion(Model model, String version, String type, List<String> pomLines) {
        String oldVersion = model.getVersion();
        if (StringUtils.isEmpty(oldVersion) || oldVersion.equals("${revision}")) {
            return;
        }
        String target = String.format("<version>%s</version>", oldVersion);
        String newVersion = rebuildVersion(version, type, oldVersion);
        String replacement = String.format("<version>%s</version>", newVersion);
        replaceVersion(pomLines, target, replacement);
    }


    private static void buildProperties(Model model, String version, String type, List<String> pomLines) {
        Properties properties = model.getProperties();
        for (String key : MODEL_VERSION_LIST) {
            String oldVersion = properties.getProperty(key);
            if (StringUtils.isEmpty(oldVersion)) {
                continue;
            }
            if (model.getArtifactId().equals("paas-cloud-server") && key.equals("revision")) {
                continue;
            }

            String target = String.format("<%s>%s</%s>", key, oldVersion, key);
            String newVersion = rebuildVersion(version, type, oldVersion);
            String replacement = String.format("<%s>%s</%s>", key, newVersion, key);
            replaceVersion(pomLines, target, replacement);
        }
    }


    private static void replaceVersion(List<String> pomLines, String target, String replacement) {
        for (int i = 0; i < pomLines.size(); i++) {
            String line = pomLines.get(i);
            if (StringUtils.isEmpty(line)) {
                continue;
            }
            if (line.trim().equals(target)) {
                String newLine = line.replace(target, replacement);
                pomLines.set(i, newLine);
                System.out.println("目标文本 -> " + line.trim());
                System.out.println("替换文本 -> " + newLine.trim());
                break;
            }
        }
    }


    private static String rebuildVersion(String newVersion, String type, String oldVersion) {
        if (StringUtils.isEmpty(newVersion)) {
            DefaultArtifactVersion defaultArtifactVersion = new DefaultArtifactVersion(oldVersion);
            int majorVersion = defaultArtifactVersion.getMajorVersion();
            int minorVersion = defaultArtifactVersion.getMinorVersion();
            int incrementalVersion = defaultArtifactVersion.getIncrementalVersion();
            newVersion = majorVersion + "." + minorVersion + "." + (incrementalVersion + 1);
        }

        switch (type) {
            case "1": {
                //正式包
                return newVersion;
            }
            case "2": {
                //快照转正式
                DefaultArtifactVersion defaultArtifactVersion = new DefaultArtifactVersion(oldVersion);
                int majorVersion = defaultArtifactVersion.getMajorVersion();
                int minorVersion = defaultArtifactVersion.getMinorVersion();
                int incrementalVersion = defaultArtifactVersion.getIncrementalVersion();
                return majorVersion + "." + minorVersion + "." + incrementalVersion;
            }
            default: {
                //快照
                return ArtifactUtils.toSnapshotVersion(newVersion);
            }
        }
    }

    /**
     * 查询分支
     *
     * @param project
     * @param branch
     * @return
     * @throws IOException
     */
    private static JSONArray queryBranchList(CicdProject project, String branch) throws IOException {
        String url = String.format(BRANCH_LIST, project.getId(), project.getId(), branch);
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).get().build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "分支列表" + branch + " " + resultStr);
        return JSONArray.parseArray(resultStr);
    }


    /**
     * 打标签
     *
     * @param project
     * @param branch
     * @throws IOException
     */
    private static void newTag(CicdProject project, String branch) throws IOException {
        String tagName = "archive/" + branch;
        JSONObject param = new JSONObject();
        param.put("id", project.getId());
        param.put("tag_name", tagName);
        param.put("ref", branch);
        param.put("message", "tag by " + AUTHOR + " on " +"");

        String url = String.format(TAG_NEW, project.getId());
        System.out.println("请求地址：" + url);
        RequestBody body = RequestBody.create(JSON, param.toJSONString());
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).post(body).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "创建标签" + tagName + "响应结果：" + resultStr);
    }

    /**
     * 清除分支
     *
     * @param project
     * @param branch
     * @throws IOException
     */
    private static void cleanBranch(CicdProject project, String branch) throws IOException {
        JSONObject param = new JSONObject();
        param.put("id", project.getId());
        param.put("branch", branch);
        String url = String.format(BRANCH_DELETE, project.getId(), branch);
        RequestBody body = RequestBody.create(JSON, param.toJSONString());
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).delete(body).build();
        Response response = CLIENT.newCall(request).execute();
        System.out.println(project.getName() + "删除分支" + branch + " " + JSONObject.toJSONString(response));
    }


    public static void queryMergeListWithClose(CicdProject project) throws IOException, URISyntaxException {
        JSONArray array = queryMergeList(project);
        if (CollectionUtils.isNotEmpty(array)) {
            for (Object object : array) {
                JSONObject json = (JSONObject) object;
                String iid = json.getString("iid");
                System.out.println(project.getName() + "存在待合并的请求:" + iid + ",");
                closeMerge(project, iid);
                String page = String.format(MERGE_PAGE, project.getName(), iid);
                openPage(page);
            }
        }
    }

    public static JSONArray queryMergeList(CicdProject project) throws IOException {
        String url = String.format(MERGE_LIST, project.getId());
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).get().build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "查询MR列表响应结果：" + resultStr);
        return JSONArray.parseArray(resultStr);
    }

    private static String createMerge(CicdProject project, String sourceBranch, String targetBranch) throws IOException {
        JSONObject param = new JSONObject();
        param.put("id", project.getId());
        param.put("source_branch", sourceBranch);
        param.put("target_branch", targetBranch);
        param.put("title", String.format("merge %s to %s by %s", sourceBranch, targetBranch, AUTHOR));

        //发起MR
        String url = String.format(MERGE_REQUEST, project.getId());
        RequestBody body = RequestBody.create(JSON, param.toJSONString());
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).post(body).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "发起MR响应结果：" + resultStr);
        JSONObject result = JSONObject.parseObject(resultStr);
        String iid = result.getString("iid");
        if (StringUtils.isEmpty(iid)) {
            JSONArray msgList = result.getJSONArray("message");
            String msg = msgList.getString(0);
            String start = "Another open merge request already exists for this source branch: !";
            if (msg.startsWith(start)) {
                iid = msg.replace(start, "");
            }
        }

        return iid;
    }


    private static void confirmMerge(CicdProject project, String iid) throws IOException, URISyntaxException {
        JSONArray array = queryMergeList(project);
        if (CollectionUtils.isNotEmpty(array)) {
            for (Object object : array) {
                JSONObject json = (JSONObject) object;
                Boolean conflicts = json.getBoolean("has_conflicts");
                if (conflicts != null && conflicts) {
                    boolean hasDiff = hasDiff(project, iid);
                    if (hasDiff) {
                        System.out.println(project.getName() + "无法合并：代码有冲突");
                        String page = String.format(MERGE_PAGE, project.getName(), iid);
                        openPage(page);
                    } else {
                        System.out.println(project.getName() + "无法合并：代码无改变");
                        closeMerge(project, iid);
                    }
                    return;
                }
            }
        }

        RequestBody body = RequestBody.create(JSON, "");
        String url = String.format(MERGE_CONFIRM, project.getId(), iid);
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).put(body).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "确认MR响应结果：" + resultStr);
        JSONObject result = JSONObject.parseObject(resultStr);
        String state = result.getString("state");
        if ("merged".equals(state)) {
            System.out.println(project.getName() + "合并代码成功！！！");
        } else {
            String msg = result.getString("message");
            System.out.println(project.getName() + "合并代码失败：" + msg);
            String page = String.format(MERGE_PAGE, project.getName(), iid);
            openPage(page);
            if ("405 Method Not Allowed".equals(msg)) {
                closeMerge(project, iid);
            }
        }
    }


    private static boolean hasDiff(CicdProject project, String iid) throws IOException {
        String url = String.format(MERGE_DIFF, project.getId(), iid);
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).get().build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "查询MR Diff List 响应结果：" + resultStr);
        JSONArray array = JSONArray.parseArray(resultStr);
        if (CollectionUtils.isEmpty(array)) {
            return true;
        }

        JSONObject result = array.getJSONObject(0);
        String diffId = result.getString("id");
        url = url + "/" + diffId;

        request = new Request.Builder().url(url).headers(GITLAB_HEADERS).get().build();
        response = CLIENT.newCall(request).execute();
        resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "查询MR Diff Detail 响应结果：" + resultStr);
        result = JSONObject.parseObject(resultStr);
        array = result.getJSONArray("commits");
        return CollectionUtils.isNotEmpty(array);
    }


    private static void closeMerge(CicdProject project, String iid) throws IOException {
        JSONObject param = new JSONObject();
        param.put("id", project.getId());
        param.put("merge_request_iid", iid);
        param.put("state_event", "close");
        String url = String.format(MERGE_CLOSE, project.getId(), iid);
        RequestBody body = RequestBody.create(JSON, param.toJSONString());
        Request request = new Request.Builder().url(url).headers(GITLAB_HEADERS).put(body).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "关闭MR" + iid + "响应结果：" + resultStr);
        JSONObject result = JSONObject.parseObject(resultStr);
        String state = result.getString("state");
        if ("closed".equals(state)) {
            System.out.println(project.getName() + "的MR" + iid + "已关闭");
        }
    }

    private static void newBranch(CicdProject project, String sourceBranch, String targetBranch) throws IOException, URISyntaxException {
        JSONObject param = new JSONObject();
        param.put("id", project.getId());
        param.put("ref", sourceBranch);
        param.put("branch", targetBranch);
        RequestBody body = RequestBody.create(JSON, param.toJSONString());
        Request request = new Request.Builder().url(String.format(BRANCH_NEW, project.getId())).headers(GITLAB_HEADERS).post(body).build();
        Response response = CLIENT.newCall(request).execute();
        String resultStr = Objects.requireNonNull(response.body()).string();
        System.out.println(project.getName() + "创建分支响应结果：" + resultStr);
        JSONObject result = JSONObject.parseObject(resultStr);
        String web_url = result.getString("web_url");
        if (StringUtils.isEmpty(web_url)) {
            System.out.println(result.getString("message"));
        } else {
            System.out.println("分支已创建" + targetBranch);
            openPage(web_url);
        }
    }

    private static void openPage(String page) throws URISyntaxException, IOException {
        System.out.println("程序将主动打开浏览器访问页面 -> " + page);
        Desktop desktop = Desktop.getDesktop();
        if (Desktop.isDesktopSupported() && desktop.isSupported(Desktop.Action.BROWSE)) {
            URI uri = new URI(page);
            desktop.browse(uri);
        }
    }


    private static boolean notRun(String projectName, Integer pid, String pname) {
        return !StringUtils.isEmpty(projectName) && (!projectName.equals(pid.toString()) && !projectName.equals(pname));
    }

    private static void sleep(int second) {
        System.out.print("⌛️等待");
        for (int i = 0; i <= second; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            //System.out.print((second - i) + "s ");
            System.out.print("🐶");
        }
        System.out.println();
    }

    private static boolean allTrue(List<Boolean> resultList) {
        for (Boolean b : resultList) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
