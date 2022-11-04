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

        ArrayList<String> entCodeList = Lists.newArrayList(
                "template_project20_demo4","Copy_test13","testXS_copy3X002","smokeTSET_test3","2201-v21","2201_v21_2","91130104MA0CLUCR1N","91320102686735828H","91340100791853973A","9151000063313683XM","A818","AHJYJS","AHSF999","ahsxjs","aquarius1910copy","BDJS","bdwh3031","bj123","bjbaohua","BJHYJS","BJHZJZ","bjhzxd","bjkysd","BJLHY","bjrnkj","bjxbhy","BJYS8888","BJZJMT","bjzzwy","brj888","CC888","CHONGQINGYEANKEJI","CHYJS888","CKGS888","cljs","CMDN","CQBENXIJIANZHU","cqgrs2021","cqky2022","cqltsj","cqlxyl","cqqs2021","cqscz2022","cqyxyl","cqyyjz","ct888888","CTJD","custsucess_project21","CX888","cxcm7477","CYKJ8888","DGTXJS","dongchuan888","DR000","DS2021","DSYL123","DZJY888","fmq123456","GD888888","gdyfl888","gdys002","gdzy88","gh66666","GL_001","GS888888","GSJS_2019","HBHGS","HBLW","HDJG","HDSHYJZ666","Hecom","hh888","hhzz","hkgj202110","hnhxsbd","HNLXJS","HNYJHB","hnyn8888","HNZP","HNZT","hsxz888","HTHD001","HTJD999","hy1234","HY2022","HYZS5858","hzkn8888","HZY_888","Ironhorse","jcjsjt","JCLW88","JDST","JG_888","JHJZ","jj123456","JNJD888","JQ_888","jsdhgj2","JSHT","JSJC","JSLR666","JSLT","JSSZ666666","jsxf","JSXHJS","jsxshjs","JXJN","JYJZZS8888","KDJG666","LBSY8888","LG_88888","LH888888","LHJZ123","LJZS_2008","LSGJ666","ltdc007","LX888888","lzkg8888","lz_001","mdjs888","MSHXZY","mytxjs","nbhdjs","ntfyjs","pinzhihs","PJKC2022","PMJZ123","PZHGLLQ2021","qcjs168","QLJS888","QLJZLW","QSY123","qx8888","qxjz888888","QYZS202107","RJ888","RTSY6688","SANSHI888","SCBYD","SCFY","SCJT888888","SCSGSJS2020888","SCYS","SCZX001","SDASZN666","sddxjt","sdhdsy","SDHLJZ","sdjbjz","SDJHJZ","SDJS","SHcengsheng","SHGJ666","SHLSJZ888","SHqhdk","SHQSJS","SHTQ","SHZXZZ888","SJ2013","SRSY888","ST888888","sxhysbd666","SZ668866","szbl6660","szcad","SZDY888","szjhw","SZQAD","szqyjs","szrcjs","szsmjzjs","szwls","TCRT998","Titan888","TJJHB","tlhj123","TRZJ888","tydl666","tzjzzs","WH888","WHHL","wjzs","WTJS001","WY5668","XCJS888","XFJT888888","xgm2020","XH018","xjjs_1","XN888888","XWJS","ydafyl","yhdqsjzgc","yhjc666","YRJS666","YSJZ888","YT666","YTL188","YTMW","yx12345678","yx888888","yxyl001","YYJS6233","YZJS","ZA888","ZB666666","ZCJD888888","ZDCY3100","zdjs8888","ZGJS2021","ZHSZ_8888","zjhc5858","ZJJG2021","ZJJS","zjjz888","zjnrjs","zjyk1689","ZJzg888","zkdl168","zrjajt","ZRJD666","ztjzgs","zxny666","ZY888888","zycx","ZYJT","ZYJZ123","ZYZC"
        );

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
