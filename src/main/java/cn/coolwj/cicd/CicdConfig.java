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

import com.alibaba.fastjson2.JSONObject;
import com.google.common.collect.Lists;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nigel Lee
 * @date 2022/9/8
 */
public class CicdConfig {

    /**
     * 配置信息
     */
    public final static String AUTHOR;
    public final static String GITLAB_TOKEN;
    public final static String CICD_TOKEN;
    public final static String DEV_BRANCH;
    public final static String FEATURE_BRANCH;
    public final static String BUG_BRANCH;
    public final static String PRE_BRANCH = "master_pre_new";
    public final static String GRAY_BRANCH = "master_gray";
    public final static String MASTER_BRANCH = "master";
    public final static String LOCAL_GIT_DIR;

    static {
        String config;
        try {
            String fileName = System.getenv("configFile");
            if (fileName == null) {
                fileName = FileUtils.getUserDirectoryPath() + File.separator + "Projects/cloud/cicd.json";
            }
            config = FileUtils.readFileToString(new File(fileName));
        } catch (IOException e) {
            System.out.println("无法读取到配置文件，请先在本地创建配置文件信息，格式如下");
            System.out.println("{\n" +
                    "\t\"AUTHOR\":\"liweijie\",\n" +
                    "\t\"GITLAB_TOKEN\":\"GITLAB_TOKEN\",\n" +
                    "\t\"CICD_TOKEN\":\"CICD_TOKEN\",\n" +
                    "\t\"DEV_BRANCH\":\"dev-v2209-liweijie\",\n" +
                    "\t\"FEATURE_BRANCH\":\"feature-v2209\",\n" +
                    "\t\"BUG_BRANCH\":\"bugfix-v2206\",\n" +
                    "\t\"LOCAL_GIT_DIR\":\"/Users/nigel/Projects/cloud/bugfix\"\n" +
                    "}"
            );
            System.out.println("配置文件路径请在启动程序的时候设置环境变量或者在家目录中创建cicd.json");
            System.out.println("请登录CICD，在个人配置页面获取 CICD_TOKEN");
            System.out.println("请登录GitLab，在个人配置页面获取 GITLAB_TOKEN");
            System.out.println("GitLab获取地址 https://newgitlab.hecom.cn/-/profile/personal_access_tokens");
            throw new RuntimeException(e);
        }

        JSONObject json = JSONObject.parseObject(config);
        AUTHOR = json.getString("AUTHOR");
        GITLAB_TOKEN = json.getString("GITLAB_TOKEN");
        CICD_TOKEN = json.getString("CICD_TOKEN");
        DEV_BRANCH = json.getString("DEV_BRANCH");
        FEATURE_BRANCH = json.getString("FEATURE_BRANCH");
        BUG_BRANCH = json.getString("BUG_BRANCH");
        LOCAL_GIT_DIR = json.getString("LOCAL_GIT_DIR");
    }

    /**
     * 操作模式
     */
    public static final int MERGE_BRANCH = 0;
    public static final int DEPLOY_BRANCH = 1;
    public static final int CREATE_BRANCH = 2;
    public static final int UPGRADE_VERSION = 3;
    public static final int CLEAN_BRANCH = 4;


    public final static OkHttpClient CLIENT = new OkHttpClient();
    public final static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public final static ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    /**
     * 常量信息
     */
    public final static Headers GITLAB_HEADERS = new Headers.Builder().add("PRIVATE-TOKEN", GITLAB_TOKEN).build();
    public final static String GITLAB_DOMAIN = "https://newgitlab.hecom.cn";
    public final static String GITLAB_API_DOMAIN = "https://newgitlab.hecom.cn/api/v4/projects";
    public final static String MERGE_LIST = GITLAB_API_DOMAIN + "/%s/merge_requests?state=opened";
    public final static String MERGE_REQUEST = GITLAB_API_DOMAIN + "/%s/merge_requests";
    public final static String MERGE_CLOSE = GITLAB_API_DOMAIN + "/%s/merge_requests/%s";
    public final static String MERGE_DIFF = GITLAB_API_DOMAIN + "/%s/merge_requests/%s/versions";
    public final static String MERGE_CONFIRM = GITLAB_API_DOMAIN + "/%s/merge_requests/%s/merge";
    public final static String MERGE_PAGE = GITLAB_DOMAIN + "/hecom-cloud/%s/-/merge_requests/%s";
    public final static String BRANCH_NEW = GITLAB_API_DOMAIN + "/%s/repository/branches";
    public final static String BRANCH_LIST = GITLAB_API_DOMAIN + "/%s/repository/branches?id=%s&search=%s";
    public final static String BRANCH_DELETE = GITLAB_API_DOMAIN + "/%s/repository/branches/%s";
    public final static String TAG_NEW = GITLAB_API_DOMAIN + "/%s/repository/tags";

    public final static List<CicdProject> PROJECT_LIST = new ArrayList<>();

    static {
        //基础组件
        PROJECT_LIST.add(new CicdProject("common", 160, 2, Lists.newArrayList("/paas-base", "/paas-general")));
        PROJECT_LIST.add(new CicdProject("paas-metadata-sdk", 21, 5));
        PROJECT_LIST.add(new CicdProject("paas-dataaccess-sdk", 22, 2));
        PROJECT_LIST.add(new CicdProject("paas-message-sdk", 167, 1));
        PROJECT_LIST.add(new CicdProject("paas-auth-sdk", 161, 2));
        PROJECT_LIST.add(new CicdProject("paas-aggregation-sdk", 164, 8));
        PROJECT_LIST.add(new CicdProject("paas-appstd-sdk", 165, 8));
        PROJECT_LIST.add(new CicdProject("app-saas-sdk", 162, 7));
        PROJECT_LIST.add(new CicdProject("hecom-cloud", "crm", 163, 7, Lists.newArrayList("/paas")));

        //定制化
        PROJECT_LIST.add(new CicdProject("hecom-cloud-custom", 26, 7, Lists.newArrayList("/custom")));
        //cloud server
        PROJECT_LIST.add(new CicdProject("paas-cloud-server", 166, 5));

        //task server
        PROJECT_LIST.add(new CicdProject("paas-task-server", 25, 3, Lists.newArrayList("/paas-task-service")));

        //auth server
        PROJECT_LIST.add(new CicdProject("paas-auth-api", 262, 3));
        PROJECT_LIST.add(new CicdProject("paas-auth-server", 263, 3, Lists.newArrayList("/paas-auth-service")));

        //metadata server
        PROJECT_LIST.add(new CicdProject("paas-metadata-api", 41, 3));
        PROJECT_LIST.add(new CicdProject("paas-metadata-server", 31, 3, Lists.newArrayList("/paas-metadata-service")));

        //log server
        PROJECT_LIST.add(new CicdProject("paas-log-api", 32, 3));
        PROJECT_LIST.add(new CicdProject("paas-log-server", 33, 3, Lists.newArrayList("/paas-log-service")));

        PROJECT_LIST.add(new CicdProject("paas-file-convert-api", 329, 3));
    }

    public final static List<String> MODEL_VERSION_LIST = Lists.newArrayList(
            "revision",
            "paas-base.version",
            "meta-sdk.version",
            "data-sdk.version",
            "msg-sdk.version",
            "auth-sdk.version",
            "agg-sdk.version",
            "appstd-sdk.version",
            "saas-sdk.version",
            "paas-cloud.version",
            "auth-api.version"
    );

    public static String ARGO_TOKEN = null;

    public final static Headers CICD_HEADERS = new Headers.Builder().add("Authorization", "Basic " + Base64.encodeBase64String((AUTHOR + ":" + CICD_TOKEN).getBytes())).build();
    public final static String CICD_DOMAIN = "https://cicd.hecom.cn";
    public final static String CICD_API = CICD_DOMAIN + "/%s/";
    public final static String CICD_BUILD = CICD_API + "build";
    public final static String CICD_LAST_BUILD_API_JSON = CICD_API + "/lastBuild/api/json";
    public final static String CICD_API_JSON = CICD_API + "/api/json";
    public final static String CICD_WFAPI_JSON = CICD_API + "wfapi/runs?since=#%s&fullStages=true&_=%s";


    public final static String CICD_COMMON_BUILD_PARAM = "{\"parameter\": {\"name\": \"BRANCH\", \"value\": \"%s\"}}";
    public final static String CICD_COMMON_DEPLOY_PARAM = "{\"parameter\": [{\"name\": \"image_version\", \"value\": \"{{cicdJobBuildNum}}\"}, {\"name\": \"deploy_env\", \"value\": \"{{cicdDeployEnv}}\"}]}";
    public final static String CICD_JOB_BUILD = "job/%s-hecom/job/%s";
    public final static String CICD_JOB_DEPLOY = "job/%s-deploy/job/%s";

    public final static List<CicdJob> CICD_JOB_LIST = new ArrayList<>();
    public final static Map<String, List<String>> ENV_MAP = new LinkedHashMap<>();
    public final static Map<String, String> ENV_ARGO = new HashMap<>();

    static {
        ENV_MAP.put("dev", Lists.newArrayList("dev"));
        ENV_ARGO.put("dev", "https://k8s-test-argocd.cloud.hecom.cn");

        ENV_MAP.put("dev9800", Lists.newArrayList("dev9800"));
        ENV_ARGO.put("dev9800", "https://k8s-test-argocd.cloud.hecom.cn");

        ENV_MAP.put("dev9600", Lists.newArrayList("dev9600"));
        ENV_ARGO.put("dev9600", "https://k8s-test-argocd.cloud.hecom.cn");

        ENV_MAP.put("demo", Lists.newArrayList("demo"));
        ENV_ARGO.put("demo", "https://argocd1.cloud.hecom.cn");

        ENV_MAP.put("pre", Lists.newArrayList("pre", "pre1"));
        ENV_ARGO.put("pre", "https://argocd1.cloud.hecom.cn");
        ENV_ARGO.put("pre1", "https://argocd1.cloud.hecom.cn");

        ENV_MAP.put("gray", Lists.newArrayList("gray"));
        ENV_ARGO.put("gray", "https://argocd1.cloud.hecom.cn");

        CicdJob all = new CicdJob(1, "job/sdk-hecom/job/32-编择打包脚手架",
                "{\"parameter\":[" +
                        "   {\"name\": \"branch_name\",          \"value\": \"%s\"}," +
                        "   {\"name\": \"common\",               \"value\": true }," +
                        "   {\"name\": \"paas_metadata_sdk\",    \"value\": true }," +
                        "   {\"name\": \"paas_dataaccess_sdk\",  \"value\": true }," +
                        "   {\"name\": \"paas_message_sdk\",     \"value\": true }," +
                        "   {\"name\": \"paas_auth_sdk\",        \"value\": true }," +
                        "   {\"name\": \"paas_aggregation_sdk\", \"value\": true }," +
                        "   {\"name\": \"paas_appstd_sdk\",      \"value\": true }," +
                        "   {\"name\": \"app_saas_sdk\",         \"value\": true }," +
                        "   {\"name\": \"hecom_cloud\",          \"value\": true }" +
                        " ]}", "");
        all.setPrintUnderLine(true);
        CICD_JOB_LIST.add(all);

        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/01-paas-base", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/03-paas-common", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/04-paas-metadata-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/05-paas-dataaccess-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/06-paas-message-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/07-paas-auth-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/08-paas-aggregation-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/09-paas-appstd-sdk", true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/10-app-saas-sdk", true));
        CicdJob hecomCloud = new CicdJob(CICD_JOB_LIST.size() + 1, "job/sdk-hecom/job/11-hecom-cloud", true);
        hecomCloud.setPrintUnderLine(true);
        CICD_JOB_LIST.add(hecomCloud);

        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/api-hecom/job/paas-auth-api"));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/api-hecom/job/paas-metadata-api"));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "job/api-hecom/job/paas-log-api"));
        CicdJob fileConvertApi = new CicdJob(CICD_JOB_LIST.size() + 1, "job/api-hecom/job/paas-file-convert-api");
        fileConvertApi.setPrintUnderLine(true);
        CICD_JOB_LIST.add(fileConvertApi);

        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-web-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-auth-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-metadata-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-bulk-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-task-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-customize-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-callback-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-oapi-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-activiti-executor-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-log-server", true, true, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-file-convert-server", true, false, true));
        CICD_JOB_LIST.add(new CicdJob(CICD_JOB_LIST.size() + 1, "paas-tools-server", true, true, true));

    }


    public static String[] readParam() {
        Scanner s = new Scanner(System.in);

        System.out.println("输入操作模式（默认为合并分支模式）：");
        System.out.println(MERGE_BRANCH + " = 合并分支");
        System.out.println(DEPLOY_BRANCH + " = 打包部署");
        System.out.println(CREATE_BRANCH + " = 创建新分支");
        System.out.println(UPGRADE_VERSION + " = 升级版本");
        System.out.println(CLEAN_BRANCH + " = 清除分支");

        String operate = s.nextLine();
        if (StringUtils.isEmpty(operate)) {
            operate = MERGE_BRANCH + "";
        }
        System.out.println("操作模式=" + operate);
        switch (operate) {
            case (DEPLOY_BRANCH + ""): {
                return deployBranch(operate, s);
            }
            case (UPGRADE_VERSION + ""): {
                return upgradeVersion(operate, s);
            }
            case (CLEAN_BRANCH + ""): {
                return cleanBranch(operate, s);
            }
            default: {
                return mergeBranch(operate, s);
            }
        }
    }

    private static String[] cleanBranch(String operate, Scanner s) {
        System.out.println("输入Git工程ID或名称（不输入按回车则执行全部)：");
        for (CicdProject project : PROJECT_LIST) {
            System.out.println(project.getId() + "  -> " + project.getName());
        }
        String projectName = s.nextLine();
        if (StringUtils.isEmpty(projectName)) {
            System.out.println("未输入工程，本次将会执行全部项目");
        } else {
            System.out.println("本次将会执行项目" + projectName);
        }
        System.out.println();


        System.out.println("输入清除分支：");
        System.out.println("多个分支之间空格区分");
        System.out.println("若输入以dev或bugfix开头的，-结尾的分支（例：dev-v2206-），则清除以此规则开头的所有分支");
        String branch = s.nextLine();
        if (StringUtils.isEmpty(branch)) {
            throw new RuntimeException("请输入需要清除的分支名称");
        }

        System.out.println("是否打标签(不输入则默认打标签)：0=不打标签，1=打标签");
        String isTag = s.nextLine();
        if (StringUtils.isEmpty(isTag)) {
            isTag = "1";
        }
        System.out.println("本次操作：" + ("1".equals(isTag) ? "打标签" : "不打标签"));

        return new String[]{operate, projectName, branch, isTag};
    }

    private static String[] deployBranch(String operate, Scanner s) {
        System.out.println("输入打包部署的环境:");
        for (String env : ENV_MAP.keySet()) {
            System.out.println(env);
        }
        String envType = s.nextLine();
        if (StringUtils.isEmpty(envType)) {
            envType = "pre";
        }
        if (!ENV_MAP.containsKey(envType)) {
            throw new RuntimeException("不支持的部署环境" + envType);
        }
        System.out.println("本次部署的环境：" + envType);
        if (envType.equals("gray") || envType.equals("product")) {
            System.out.println("请再次输入需要部署的环境：" + envType);
            String envType2 = s.nextLine();
            if (StringUtils.isEmpty(envType2)) {
                throw new RuntimeException("请再次输入需要部署的环境");
            }
            if (!envType.equals(envType2)) {
                throw new RuntimeException("两次输入的环境不一致");
            }
        }

        System.out.println("输入打包部署的分支：");
        String branch = s.nextLine();
        if (StringUtils.isEmpty(branch)) {
            switch (envType) {
                case "pre": {
                    branch = PRE_BRANCH;
                    break;
                }
                case "gray": {
                    branch = GRAY_BRANCH;
                    break;
                }
                default: {
                    branch = FEATURE_BRANCH;
                }
            }
        }
        System.out.println("本次部署的分支：" + branch);


        System.out.println("请输入工程ID：");
        System.out.println("----------------------------------------------------");
        System.out.println("不输入直接回车: 执行全部");
        System.out.println("-1: 仅打包 sdk api");
        System.out.println("-2: 仅打包部署 server");
        System.out.println("----------------------------------------------------");
        for (CicdJob job : CICD_JOB_LIST) {
            System.out.println(job.getId() + ": " + job.getName());
            if (job.isPrintUnderLine()) {
                System.out.println("----------------------------------------------------");
            }
        }
        System.out.println("----------------------------------------------------");
        String projectName = s.nextLine();
        if (StringUtils.isEmpty(projectName)) {
            System.out.println("本次将会执行：全部项目");
        } else {
            System.out.println("本次将会执行：项目" + projectName);
        }

        return new String[]{operate, projectName, branch, envType};
    }

    private static String[] mergeBranch(String operate, Scanner s) {
        System.out.println("输入Git工程ID或名称(不输入按回车则执行全部)：");
        for (CicdProject project : PROJECT_LIST) {
            System.out.println(project.getId() + " ->  " + project.getName());
        }
        String projectName = s.nextLine();
        if (StringUtils.isEmpty(projectName)) {
            System.out.println("未输入工程，本次将会执行全部项目");
        } else {
            System.out.println("本次将会执行项目" + projectName);
        }
        System.out.println();

        System.out.println("输入来源分支和目标分支：");
        System.out.println("0 = 自定义分支");
        System.out.println("1 = dev -> feature");
        System.out.println("2 = feature -> dev");
        System.out.println("3 = master -> feature");
        System.out.println("4 = bug -> pre");
        System.out.println("5 = pre -> master");
        System.out.println("6 = master -> bug");
        System.out.println("7 = feature -> pre");
        System.out.println("8 = pre -> gray");

        String typeStr = s.nextLine();
        if (StringUtils.isEmpty(typeStr)) {
            typeStr = "0";
        }
        int type = Integer.parseInt(typeStr);

        String sourceBranch, targetBranch;
        switch (type) {
            case 1: {
                sourceBranch = DEV_BRANCH;
                targetBranch = FEATURE_BRANCH;
                break;
            }
            case 2: {
                sourceBranch = FEATURE_BRANCH;
                targetBranch = DEV_BRANCH;
                break;
            }
            case 3: {
                sourceBranch = MASTER_BRANCH;
                targetBranch = FEATURE_BRANCH;
                break;
            }
            case 4: {
                sourceBranch = BUG_BRANCH;
                targetBranch = PRE_BRANCH;
                break;
            }
            case 5: {
                sourceBranch = PRE_BRANCH;
                targetBranch = MASTER_BRANCH;
                break;
            }
            case 6: {
                sourceBranch = MASTER_BRANCH;
                targetBranch = BUG_BRANCH;
                break;
            }
            case 7: {
                sourceBranch = FEATURE_BRANCH;
                targetBranch = PRE_BRANCH;
                break;
            }
            case 8: {
                sourceBranch = PRE_BRANCH;
                targetBranch = GRAY_BRANCH;
                break;
            }
            default: {
                System.out.println("输入来源分支，直接回车使用" + DEV_BRANCH);
                sourceBranch = s.nextLine();
                if (StringUtils.isEmpty(sourceBranch)) {
                    sourceBranch = DEV_BRANCH;
                }

                System.out.println("请输入目标分支，直接回车键则使用" + FEATURE_BRANCH);
                targetBranch = s.nextLine();
                if (StringUtils.isEmpty(targetBranch)) {
                    targetBranch = FEATURE_BRANCH;
                }
                break;
            }
        }
        System.out.println("来源分支：" + sourceBranch);
        System.out.println("目标分支：" + targetBranch);

        return new String[]{operate, projectName, sourceBranch, targetBranch};
    }


    private static String[] upgradeVersion(String operate, Scanner s) {
        System.out.println("输入Git工程ID或名称（不输入则执行全部)：");
        for (CicdProject project : PROJECT_LIST) {
            System.out.println(project.getId() + " -> " + project.getName());
        }
        String projectName = s.nextLine();
        if (StringUtils.isEmpty(projectName)) {
            System.out.println("未输入工程，本次将会执行全部项目");
        } else {
            System.out.println("本次将会执行项目" + projectName);
        }
        System.out.println();

        System.out.println("输入版本类型（不输入是快照包)：");
        System.out.println("0 = 快照包");
        System.out.println("1 = 正式包");
        System.out.println("2 = 快照转正式");
        String type = s.nextLine();
        if (StringUtils.isEmpty(type)) {
            type = "0";
        }
        System.out.println("版本类型=" + type);
        System.out.println();

        String version;
        if (!"2".equals(type)) {
            System.out.println("输入版本号（不输入则最小版本加1)：");
            version = s.nextLine();
        } else {
            version = null;
        }

        return new String[]{operate, projectName, version, type};
    }


}
