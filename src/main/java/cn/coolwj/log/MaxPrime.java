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

import com.google.common.base.Splitter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Nigel Lee
 * @date 2022/9/17
 */
public class MaxPrime {

    public static void main(String[] args) {

        String aa = "你好/我/是";
        System.out.println(aa);

        List<String> aaa =  Splitter.on("/").splitToList(aa);

        String[] bb=  StringUtils.split(aa,"/");

        System.out.println();



        //String mac = readPrime();
        //System.out.println(makePrime());
    }

    public static String makePrime() {
        return new BigDecimal(2).pow(82589933).subtract(BigDecimal.ONE).toString();
    }

    public static String readPrime() {
        try {
            return FileUtils.readFileToString(new File(FileUtils.getUserDirectoryPath() + "/Projects/nigel/coolwj-kit/src/main/data/MaxPrime.txt"), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
