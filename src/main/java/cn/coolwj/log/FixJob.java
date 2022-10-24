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


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Nigel Lee
 * @date 2022/10/24
 */

/**
 * 定时触发 任务迁移
 */
public class FixJob {

    String ss = """
            水瓶座 Aquarius
            水瓶座1910 aquarius1910
            线上冒烟专用企业 aquarius_v2008_2
            自动化 Web_Auto_Test
            2201测试v21_2 2201_v21_2
            2201测试v21_冒烟专用 2201_v21
            新模板冒烟企业30_copy newtest30_copy""";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        // 灰度tools地址，往哪迁写哪个环境
        String url = "https://cloud-tools.cloud.hecom.cn/v1/universe//paas/env/tools/data/fixJob";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appName", "timeTrigger");
        jsonObject.put("JobName", "TimeTriggerJob");

        ArrayList<String> entCodeList = Lists.newArrayList("aquarius","aquarius1910",    "aquarius_v2008_2",    "Web_Auto_Test",    "2201_v21_2",  "2201_v21",    "smokeTSET_test3","newtest30_copy");

        for (String entCode : entCodeList) {
            jsonObject.put("entCode", entCode);
            System.out.println(jsonObject);
            extracted(client, jsonObject.toJSONString(), url);
        }

    }

    private static void extracted(OkHttpClient client, String bodyStr, String url) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("accessToken", "Wt--mWJ6t.")
                .addHeader("entCode", "Hecom")
                .addHeader("uid", "0")
                .addHeader("clientTag", "web")
                .addHeader("Content-Type", "application/json")
                .addHeader("empCode", "0")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
