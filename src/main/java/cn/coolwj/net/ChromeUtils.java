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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @author Nigel Lee
 * @date 2022/11/26
 */
public class ChromeUtils {

    private final static ExecutorService executorService = Executors.newCachedThreadPool();


    public static void main(String[] args) throws IOException {
        final AtomicLong count = new AtomicLong(0L);
        String url = "https://h.xinhuaxmt.com/vh512/share/11217552";
        System.setProperty("webdriver.chrome.driver", "/Users/nigel/Projects/nigel/coolwj-kit/src/main/data/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=80,900");
        for (int i = 0; i < 26; i++) {
            Thread t = new Thread(() -> {
                duang(url, chromeOptions, count);
            });
            executorService.execute(t);
        }
    }


    private static void duang(String url, ChromeOptions chromeOptions, AtomicLong count) {
        WebDriver driver = new ChromeDriver(chromeOptions);
        try {
            while (true) {
                driver.get(url);
                // WebElement txt = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.tagName("span")));
                //JavascriptExecutor jse = (JavascriptExecutor)driver;
                //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                try {
                    Thread.sleep(3 * 1000);
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
