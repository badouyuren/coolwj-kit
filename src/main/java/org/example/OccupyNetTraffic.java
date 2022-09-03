package org.example;

import com.google.common.collect.Lists;
import okhttp3.*;

import java.io.IOException;
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


    final static int max = 3000;
    final static ExecutorService executorService = Executors.newFixedThreadPool(max);
    final static long MB = 1024 * 1024;
    final static long GB = 1024 * MB;
    final static long TB = 1024 * GB;
    final static OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES).build();
    final static AtomicLong size = new AtomicLong(0L);

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
                        Request request = new Request.Builder().url(url).get().build();
                        try (Response response = client.newCall(request).execute()) {
                            assert response.body() != null;
                            byte[] bytes = response.body().bytes();
                            long s = bytes.length;
                            System.out.println(response + " " + s / MB + "MB");
                            long ss = size.addAndGet(s);
                            if (ss < GB) {
                                System.out.println("累计已刷新" + ss / MB + "MB");
                            } else if (ss < TB) {
                                System.out.println("累计已刷新" + ss / GB + "GB");
                            } else {
                                System.out.println("累计已刷新" + ss / TB + "TB");
                            }
                            bytes = null;
                        } catch (IOException ignored) {
                        }
                    });
                }
            }

            Thread.sleep(1000);
        }
    }
}



}
