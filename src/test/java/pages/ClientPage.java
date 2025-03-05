package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class ClientPage {
    WebDriver driver;

    public ClientPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By USER_NAME = By.id("nameofuser");

    public boolean isPageOpened() {
        return driver.findElement(USER_NAME).isDisplayed();
    }
}
