package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
    WebDriver driver;
    public WebElement welcomeButton;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void initWelcomebutton(){
        welcomeButton = driver.findElement(By.cssSelector("body > app-root > app-welcome > div > div > h2"));
    }

}
