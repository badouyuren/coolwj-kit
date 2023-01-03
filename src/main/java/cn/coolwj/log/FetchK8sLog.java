package cn.coolwj.log;
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

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author Nigel Lee
 * @date 2022/9/14
 */
public class FetchK8sLog {

    private final static String outputDir = "/Users/nigel/Desktop/";
    private final static OkHttpClient CLIENT = new OkHttpClient();
    private final static String url = "https://sls.console.aliyun.com/console/logstoreindex/getLogs.json";

    private final static String devTestEnv = "k8s-log-c368c7c9f726947528016e89a7c27fd41";
    private final static String demoPreEnv = "k8s-log-ce5efe25b95054df19c699d30a0a9cabc";
    private final static String grayProductK8sEnv = "k8s-log-c819060fdf91541b5a5aea87d8086cfe0";
    private final static String k8sStoreName = "app-logsotre";

    private final static String productEcsEnv = "prod-crminfo-log";
    private final static String ecsStoreName = "prod-crminfo-log";

    //private final static String logEnv = productEcsEnv;
    //private final static String logStore = ecsStoreName;

    private final static String logEnv = demoPreEnv;
    private final static String logStore = k8sStoreName;

    private final static String cookie = """

t=14bb8ce9b0b3c4e4a787fdbf268b58a2; aliyun_site=CN; aliyun_choice=CN; currentRegionId=cn-hangzhou; aliyun_lang=zh; login_aliyunid_csrf=_csrf_tk_1508372388932019; login_aliyunid="liweijie @ 1451945644432939"; login_aliyunid_ticket=jwrR9QpvN9icQ0VRdDIr4EUiavQCXVEedIFVfntkE1Qfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755fVmYnUBCAR8QPNbNr_5DOgGqri7a60Fu56CirX_*9VBpfkTFdJTd528Z8oNMai_o0P21wbcA197rmJK*H1vT5ERPp2356A*R; isg=BENDtHvLJBn2-elAp3woKuAM0gHtuNf6B9tibnUg3aIZNGFW_4yrSKClqsx6lC_y; l=fBSawPORL2ofI9E-BOfZEurza779KIRVguPzaNbMi9fP9gCH5-ZfW670wfLMCnGNEsfw-3rMJOyDBqY8qPUHQxv9-eTSsWLjndLnwpzHU





""".trim();

    private final static String queryStr = """
e4bd37a8758b6bf7                                  
            """.trim();


    private final static Long from = LocalDateTime.of(2023, 1, 1, 0, 0, 0).toEpochSecond(ZoneOffset.ofHours(8));
    private final static Long to = LocalDateTime.of(2023, 1, 4, 23, 15, 0).toEpochSecond(ZoneOffset.ofHours(8));


    public static void main(String[] args) throws IOException {


        JSONArray list = new JSONArray();
        int page = 1;
        JSONArray jsonArray;
        do {
            JSONObject jsonObject = getResponseJson(page);
            if (jsonObject.getJSONObject("data") == null) {
                throw new RuntimeException("需要 重新获取登录信息 https://sls.console.aliyun.com/lognext/project/" + logEnv + "/logsearch/" + logStore);
            }
            jsonArray = jsonObject.getJSONObject("data").getJSONArray("logs");
            list.addAll(jsonArray);
            System.out.println("已获取第" + page + "页的" + jsonArray.size() + "条日志，累计已获取" + list.size() + "条日志");
            page++;
        } while (jsonArray.size() > 0);

        List<String> contentList = list.stream()
                .map(item -> ((JSONObject) item).getString("content"))
                .sorted(Comparator.comparing(item -> item.substring(0, 24)))
                .peek(System.out::println)
                .toList();
        File file = FileUtil.file(outputDir + queryStr + " - " + from + "_" + to + ".log");
        FileUtil.writeLines(contentList, file, "utf-8");


    }


    private static JSONObject getResponseJson(Integer page) throws IOException {
        FormBody formBody = new FormBody.Builder()
                .add("ProjectName", logEnv)
                .add("LogStoreName", logStore)
                .add("query", FetchK8sLog.queryStr)
                .add("from", FetchK8sLog.from.toString())
                .add("to", FetchK8sLog.to.toString())
                .add("Page", page.toString())
                .add("Size", "100")
                .build();
        Request request = new Request.Builder().url(url).headers(HEADERS).post(formBody).build();
        try (Response response = CLIENT.newCall(request).execute()) {
            String string = Objects.requireNonNull(response.body()).string();
            return JSONObject.parseObject(string);
        }
    }


    public final static Headers HEADERS = new Headers.Builder()
            .add("authority", "sls.console.aliyun.com")
            .add("accept", "application/json")
            .add("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7")
            .add("content-type", "application/x-www-form-urlencoded")
            .add("origin", "https://sls.console.aliyun.com")
            .add("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"102\", \"Google Chrome\";v=\"102\"")
            .add("sec-ch-ua-mobile", "?0")
            .add("sec-ch-ua-platform", "\"macOS\"")
            .add("sec-fetch-dest", "empty")
            .add("sec-fetch-mode", "cors")
            .add("sec-fetch-site", "same-origin")
            .add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36")
            .add("cookie", cookie)
            .build();
}
