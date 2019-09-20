package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomeFragment{
    WebDriver driver;

    public By home = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(1) > a");
    public By owners = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(2) > a");
    public By veterinarians = By.cssSelector(("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(3) > a"));
    public By petTypes = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4) > a");
    public By specialties = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li:nth-child(5) > a");
    public By addNewOwners = By.cssSelector("body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a");
    public By clickOnAddOwnerFinal = By.cssSelector(("body > app-root > app-owner-list > div > div > div > div > button"));

    public WelcomeFragment(WebDriver driver) {
        this.driver = driver;
    }
    public String getHomeText(){
       return driver.findElement(home).getText();
    }
    public String getOwnersText(){
        return driver.findElement(owners).getText();
    }
    public String getVeterninariansText(){
        return driver.findElement(veterinarians).getText();
    }
    public String getPetTypesText(){
        return driver.findElement(petTypes).getText();
    }
    public String getSpeciltiesText(){
        return driver.findElement(specialties).getText();
    }
    public String getOwnersButton(){
        return driver.findElement(addNewOwners).getText();
    }
    public String getOwnersAddButton(){
        return driver.findElement(clickOnAddOwnerFinal).getText();
    }


    public void clickOnHome() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(home).click();
    }
    public void clickOnOwners() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(owners).click();
    }
    public void clickOnPetTypes() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(petTypes).click();
    }
    public void clickOnPetSpecialties() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(specialties).click();
    }
    public void clickOnAddOwners() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(addNewOwners).click();
    }
    public void clickOnAddOwnersButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(clickOnAddOwnerFinal).click();
    }

}
