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
import com.google.common.collect.Lists;
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
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Nigel Lee
 * @date 2022/9/14
 */
public class FetchK8sLog {

    private final static String outputDir = "/Users/nigel/Desktop/";
    private final static OkHttpClient CLIENT = new OkHttpClient();
    private final static String url = "https://sls.console.aliyun.com/console/logstoreindex/getLogs.json";

    private final static String devTestEnv = "k8s-log-c368c7c9f726947528016e89a7c27fd41";
    private final static String grayPreEnv = "k8s-log-ce5efe25b95054df19c699d30a0a9cabc";
    private final static String productK8sEnv = "k8s-log-c819060fdf91541b5a5aea87d8086cfe0";
    private final static String logK8sStoreName = "app-logsotre";

    private final static String productEcsEnv = "prod-crminfo-log";
    private final static String logEcsStoreName = "prod-crminfo-log";

    private final static String cookie = """

            t=14bb8ce9b0b3c4e4a787fdbf268b58a2; aliyun_site=CN; aliyun_choice=CN; currentRegionId=cn-shenzhen; aliyun_lang=zh; pageSize=100; reverse=false; _samesite_flag_=true; cookie2=1068ad0744396760d6abe8ba131f3da2; _tb_token_=f50e9ebaeb316; login_aliyunid_csrf=_csrf_tk_1089463119770125; login_aliyunid="liweijie @ 1451945644432939"; login_aliyunid_ticket=jwrR9QpvN9icQ0VRdDIr4MS6CSto67aJMTPT1WKSK3Mfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755fVmYnUBCAR8QPNbNr_5DOgGqri7a60Fu56CirX_*9VBpfkTFdJTd51o_8IIPmhRNfhraq0i4cS7rmJK*H1vT5ERPp2356A*R; isg=BOXl0gjg6sbHOw-mlVa2tHLG9KcfIpm0GMOasefK8pwr_gdwrXY2htyfjGqIRrFs; l=eBSawPORL2ofIw8YBOfaPurza779YIR4iuPzaNbMiOCPOE1H5r5VW6oVzqLMCnGNn6l2-35PnfpwBoL81PUHQxv9-eTSsWLjXdLh.            

            """.trim();

    private final static String logEnv = productEcsEnv;
    private final static String logStore = logEcsStoreName;

    private final static String queryStr = """
            200540930681 and actionStatus__ss
            """.trim();
    private final static Long from = LocalDateTime.of(2022, 9, 12, 0, 0, 0).toEpochSecond(ZoneOffset.ofHours(8));
    private final static Long to = LocalDateTime.of(2022, 10, 22, 23, 0, 0).toEpochSecond(ZoneOffset.ofHours(8));

    public static void main(String[] args) throws IOException {

        JSONArray list = new JSONArray();
        int page = 1;
        JSONArray jsonArray;
        do {
            JSONObject jsonObject = getResponseJson(page);
            jsonArray = jsonObject.getJSONObject("data").getJSONArray("logs");
            list.addAll(jsonArray);
            System.out.println("已获取第" + page + "页的" + jsonArray.size() + "条日志，累计已获取" + list.size() + "条日志");
            page++;
            if (page > 100) {
                return;
            }
            sleep(1);
        } while (jsonArray.size() > 0);

        List<String> contentList = list.stream()
                .map(item -> ((JSONObject) item).getString("content"))
                .sorted(Comparator.comparing(item -> item.substring(0, 24)))
                .peek(System.out::println)
                .toList();
        File file = FileUtil.file(outputDir + queryStr + "-" + from + "_" + to + ".log");
        FileUtil.writeLines(contentList, file, "utf-8");

//        List<String> rawContent = Lists.newArrayList();
//        for (String content : contentList) {
//            String[] split = content.split("] - ");
//            rawContent.add(split[1]);
//        }
//        FileUtil.appendString("\r\r", file, "utf-8");
//        List<String> statics = Lists.newArrayList();
//        rawContent.stream().collect(Collectors.toMap(Function.identity(), item -> 1, Integer::sum)).forEach((k, v) -> {
//            if (v > 2) {
//                String str = k + " ======== " + v;
//                statics.add(str);
//            }
//        });
//        FileUtil.appendLines(statics, file, "utf-8");
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

    private static void sleep(int second) {
        System.out.print("⌛️等待");
        for (int i = 0; i <= second; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.print("🐶");
        }
        System.out.println();
    }

}
