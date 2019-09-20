package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Owners {
    WebDriver driver;
    Faker faker = new Faker();
    public WebElement clickOnOwners;
    public WebElement clickOnAddNewOwners;
    public WebElement clickOnAddOwner;
    public By rowsInOwnersList = By.cssSelector(".table-responsive tbody tr td");


    public Owners(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By addressField = By.id("address");
    private By cityField = By.id("city");
    private By telephoneField = By.id("telephone");
    private By clickOnAddOwnerFinal = By.cssSelector("body > app-root > app-owner-add > div > div > form > div:nth-child(7) > div > button:nth-child(2)");

    public By getFirstNameField() {
        return firstNameField;
    }


    public By getLastNameField() {
        return lastNameField;
    }

    public By getAdressField() {
        return addressField;
    }

    public By getCityField() {
        return cityField;
    }

    public By getTelephonefield() {
        return telephoneField;
    }
    public By getAddOwner() {
        return clickOnAddOwnerFinal;
    }

    public String getFirstName(){
        String firstName = faker.name().firstName();
        return firstName;
    }
    String var1 = getFirstName();

    public String getLastName() {
        String lastName = faker.name().lastName();
        return lastName;
    }
    String var2 = getLastName();

    public String getAddress() {
        String address = faker.address().streetAddress();
        return address;
    }
    String var3 = getAddress();

    public String getCity() {
        String city = faker.address().city();
        return city;
    }
    String var4 = getCity();

    public String getTelephone() {
        String telephone = faker.number().digits(10);
        return telephone;
    }
    String var5 = getTelephone();

    public void putFirstName(){
        driver.findElement(firstNameField).sendKeys(var1);
    }
    public void putLastName(){
        driver.findElement(lastNameField).sendKeys(var2);
    }
    public void putAddress(){
        driver.findElement(addressField).sendKeys(var3);
    }
    public void putCity(){
        driver.findElement(cityField).sendKeys(var4);
    }
    public void putTelephone(){
        driver.findElement(telephoneField).sendKeys(var5);
    }
    public void clickOnAddOwnerButtonFinal(){
        driver.findElement(By.cssSelector("body > app-root > app-owner-add > div > div > form > div:nth-child(7) > div > button:nth-child(2)")).click();
    }

    public boolean checkOwnersList(String firstName, String lastName){
        driver.navigate().refresh();
        List<WebElement> listOwners = driver.findElements(rowsInOwnersList);
        for(int i=0; i<listOwners.size(); i++){
            if(listOwners.get(i).getText().contains(firstName+ " " +lastName)){
                break;
            }
        }return true;

    }
}
