import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatePetTypes {
    WebDriver driver;

    public CreatePetTypes(WebDriver driver) {
        this.driver = driver;
    }
    By petTypesButton = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4)");
    By clickAddPetTypes = By.cssSelector("body > app-root > app-pettype-list > div > div > div > button:nth-child(2)");


    public void setPetTypesButton(){
        driver.findElement(petTypesButton).click();
    }
    public void setClickAddPetTypes(){
        driver.findElement(clickAddPetTypes).click();
    }
}
