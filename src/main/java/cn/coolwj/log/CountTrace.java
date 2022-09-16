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

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nigel Lee
 * @date 2022/9/16
 */
public class CountTrace {
    private final static String outputDir = "/Users/nigel/Desktop/";

    public static void main(String[] args) throws IOException {
        List<String> contentList = FileUtils.readLines(new File(outputDir + "2.csv"), Charset.defaultCharset());

        Map<String, Integer> traceIdMap = new HashMap<>();
        for (String content : contentList) {
            if (!content.contains(",")) {
                continue;
            }
            String[] array = content.split(",");
            if (array.length < 2) {
                continue;
            }

            String traceId = content.split(",")[1];
            Integer count = traceIdMap.computeIfAbsent(traceId, k -> 0);
            traceIdMap.put(traceId, ++count);
        }

        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(traceIdMap.entrySet());
        mapList.sort(Comparator.comparing(Map.Entry<String, Integer>::getValue));
        for (Map.Entry<String, Integer> entry : mapList) {
            System.out.println(entry.getKey() + " ->  " + entry.getValue());
        }
    }
}
