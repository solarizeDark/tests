import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        return new ChromeDriver();
    }
    public static void oneFieldSendKeysAndClick(WebDriver driver, String id, String keys, By clickId) {
        driver.findElement(By.id(id)).sendKeys(keys);
        driver.findElement(clickId).click();
    }

    public static void click(WebDriver driver, String selector) {
        driver.findElement(By.cssSelector(selector));
    }

    public static void clickById(WebDriver driver, String id) {
        driver.findElement(By.id(id)).click();
    }

    public static void clickByClass(WebDriver driver, String clazz) {
        driver.findElement(By.className(clazz)).click();
    }

    public static void getPageByURL(WebDriver driver) {
        driver.get("https://trello.com/login");
    }

    public static void timeoutForNewPageLoad(Integer seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public static void setWindowHandels(WebDriver driver) {
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

}
