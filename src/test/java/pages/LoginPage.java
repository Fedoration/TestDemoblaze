package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By USER_FIELD = By.id("loginusername");
    private static final By PASSWORD_FIELD = By.id("loginpassword");
    private static final By LOGIN_HEAD_BUTTON = By.id("login2");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Log in']");
    private static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage open() {
        driver.get("https://www.demoblaze.com/#");
        driver.findElement(LOGIN_HEAD_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return this;
    }

    public ClientPage login(String user, String password) {
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ClientPage(driver);
    }

    public LoginPage loginForNegativeData(String user, String password) {
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public String getErrorMessage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        alert.accept();
        return alertText;
    }


}
