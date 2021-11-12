import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class First {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://trello.com/login");
        driver.findElement(By.id("user")).sendKeys("fortests228@gmail.com");
        driver.findElement(By.id("login")).click();
        TimeUnit.SECONDS.sleep(2);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.id("password")).sendKeys("fortests22909");
        driver.findElement(By.cssSelector("#login-submit > span > span")).click();

    }

}
