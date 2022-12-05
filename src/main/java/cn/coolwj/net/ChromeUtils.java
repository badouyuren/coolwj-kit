package cn.coolwj.net;
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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author Nigel Lee
 * @date 2022/11/26
 */
public class ChromeUtils {

    private final static ExecutorService executorService = Executors.newCachedThreadPool();


    public static void main(String[] args) throws IOException, InterruptedException {
        final AtomicLong count = new AtomicLong(0L);
        String url = "https://h.xinhuaxmt.com/vh512/share/11217552";
        System.setProperty("webdriver.chrome.driver", "/Users/nigel/Projects/nigel/coolwj-kit/src/main/data/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=80,900");
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> duang(url, chromeOptions, count));
            Thread.sleep(i * 1000);
        }
    }


    private static void duang(String url, ChromeOptions chromeOptions, AtomicLong count) {
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            while (true) {
                driver.get(url);
                new WebDriverWait(driver, Duration.ofSeconds(23)).until(ExpectedConditions.titleContains("上证研究"));
                WebElement webElement = driver.findElement(By.id("app"));

               // webElement.get
              //  System.out.println(webElement.getText());

                try {
                    Thread.sleep(1* 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("已刷新 " + count.incrementAndGet());
            }

        } finally {
            driver.quit();
        }

    }
}
