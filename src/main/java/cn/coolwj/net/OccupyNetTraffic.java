package cn.coolwj.net;

import com.google.common.collect.Lists;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

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

public class OccupyNetTraffic {


    final static int max = 10;
    final static ExecutorService executorService = Executors.newFixedThreadPool(max);
    final static long MB = 1024 * 1024;
    final static long GB = 1024 * MB;
    final static long TB = 1024 * GB;
    final static OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES).build();
    final static AtomicLong size = new AtomicLong(0L);
    final static AtomicLong time = new AtomicLong(0L);

    public static void main(String[] args) throws InterruptedException {

        while (true) {

            List<String> urls = Lists.newArrayList(
                    "https://down.sandai.net/thunder11/XunLeiWebSetup11.3.14.1952gw.exe",
                    "https://down.sandai.net/mac/player_3.1.0.65222.dmg",
                    "https://down.sandai.net/mac/thunder_5.0.2.65551.dmg",
                    "https://xmp.down.sandai.net/xmp/XMPSetup6.2.3.590xmpdl.exe"
            );

            for (int i = 0; i < max; i++) {
                for (String url : urls) {
                    executorService.execute(() -> {
                        long start = System.currentTimeMillis();
                        Request request = new Request.Builder().url(url).get().build();
                        try (Response response = client.newCall(request).execute()) {
                            assert response.body() != null;
                            byte[] bytes = response.body().bytes();
                            long s = bytes.length;
                            long end = System.currentTimeMillis();
                            long cost = end - start;
                            StringBuilder info = new StringBuilder(new Date().toString());
                            info.append(" ")
                                    .append(response)
                                    .append(" ").append(s / MB).append("MB，")
                                    .append(" 本次耗时：").append(formatMs(cost));
                            long totalSize = size.addAndGet(s);
                            info.append(" 累计已刷新").append(formatSize(totalSize));

                            long totalTime = time.addAndGet(cost);
                            info.append(" 累计耗时：").append(formatMs(totalTime));
                            long speed = totalSize / totalTime * 1000;
                            info.append(" 速度：").append(formatSize(speed)).append("/s");


                            System.out.println(info);
                            bytes = null;
                        } catch (IOException ignored) {
                        }
                    });
                }
            }

            Thread.sleep(1000);
        }
    }

    public static String formatSize(long ss) {
        StringBuilder info = new StringBuilder();
        if (ss < GB) {
            info.append(ss / MB).append("MB");
        } else if (ss < TB) {
            info.append(ss / GB).append("GB");
        } else {
            info.append(ss / TB).append("TB");
        }
        return info.toString();
    }

    public static String formatMs(long ms) {
        return formatMs(ms, false);
    }

    public static String formatMs(long ms, boolean isFull) {

        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = ms / dd;
        long hour = (ms - day * dd) / hh;
        long minute = (ms - day * dd - hour * hh) / mi;
        long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        if (isFull) {

            String strDay = day < 10 ? "0" + day : "" + day;
            String strHour = hour < 10 ? "0" + hour : "" + hour;
            String strMinute = minute < 10 ? "0" + minute : "" + minute;
            String strSecond = second < 10 ? "0" + second : "" + second;
            String strMilliSecond = milliSecond < 10 ? "0" + milliSecond : "" + milliSecond;
            strMilliSecond = milliSecond < 100 ? "0" + strMilliSecond : "" + strMilliSecond;

            return strDay + "天" + strHour + "时" + strMinute + "分" + strSecond + "秒" + strMilliSecond + "毫秒";
        } else {

            StringBuilder result = new StringBuilder();
            if (day != 0) {
                result.append(day).append("天");
            }
            if (hour != 0) {
                result.append(hour).append("时");
            }
            if (minute != 0) {
                result.append(minute).append("分");
            }
            if (second != 0) {
                result.append(second).append("秒");
            }
            if (milliSecond != 0) {
                result.append(milliSecond).append("毫秒");
            }
            return result.toString();
        }
    }

}
