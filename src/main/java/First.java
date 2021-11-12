import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First extends TestBase {

    WebDriver driver;
    AccountData accountData;
    Board board;

    @BeforeTest
    public void setting() {
        this.accountData = new AccountData("fortests228@gmail.com", "fortests22909");
        this.driver = driver();
        this.board = new Board("Bar");
    }

    @Test
    public void loginTest() throws InterruptedException {
        getPageByURL(driver);
        oneFieldSendKeysAndClick(driver, "user", accountData.getLogin(), By.id("login"));
        timeoutForNewPageLoad(3);
        setWindowHandels(driver);
        oneFieldSendKeysAndClick(driver, "password", accountData.getPassword(), By.cssSelector("#login-submit > span > span"));
    }

    @Test
    public void createBoardTest() throws InterruptedException {
        loginTest();
        timeoutForNewPageLoad(5);
        setWindowHandels(driver);
        // create board button
        clickByClass(driver, "_2Twwgx1RZOAQRy _2JuXFf7_Rpv7fk _3TTqkG5muwOzqZ ZOUktZwsING7-0 _3LWeD13GUCngAu _1Tu9wiuW4Te8Rx");
        // one more button to click
        clickByClass(driver, "_3Qtx4lodxp9J0E");
        // set name and click
        oneFieldSendKeysAndClick(driver,
                "body > div.atlaskit-portal-container > div > section > div > form > div:nth-child(1) > label",
                board.getName(),
                By.cssSelector("body > div.atlaskit-portal-container > div > section > div > form > button")
                );
    }

}
