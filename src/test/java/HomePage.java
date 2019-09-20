import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By welcomeButton = By.cssSelector(".container.xd-container h2");

    public String welcomeHome(){
        return driver.findElement(welcomeButton).getText();
    }

}
