package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetTypes {
    WebDriver driver;
    WebDriverWait wait;

    public WebElement clickOnPetTypesButton;
    public By addButton = By.cssSelector("div > button:nth-child(2)");
    public By nameField = By.cssSelector("#name");
    public By saveButton = By.cssSelector("#pettype > div.form-group.has-feedback > div > button");
    public By deleteButton = By.cssSelector("tbody tr>td:nth-child(2) button:nth-child(2)");
    public By specificPetType = By.cssSelector("#pettypes tbody td:first-child input");


    public PetTypes(WebDriver driver) {
        this.driver = driver;
    }

    public void getPettype() throws InterruptedException {

        Thread.sleep(4000);
        driver.findElement(addButton).click();
        driver.findElement(nameField).sendKeys("pasareG");
        driver.findElement(saveButton).click();
    }

    public String givenListWithPets() {
        Random random = new Random();
        List<String> givenList = Arrays.asList("flamingoG", "zebraG", "mistretG", "fazanG");
        return givenList.get(random.nextInt(givenList.size()));

    }

    String animal = givenListWithPets();


    public void getPettypeWithRandom() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div > button:nth-child(2)")));

        driver.findElement(addButton).click();
        //wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(animal);
        driver.findElement(saveButton).click();
    }


    public boolean petsInList() {
        driver.navigate().refresh();
        List<WebElement> petsList = driver.findElements(specificPetType);
        boolean a = false;
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains("flamingoG")) {
                a = true;
            }
        }
        return a;
    }

    public boolean checkPetsInListWithGivenList() {
        driver.navigate().refresh();

        List<WebElement> petsList = driver.findElements(specificPetType);
        boolean a = false;
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains(animal)) {
                a = true;
                break;
            }
        }
        return a;
    }

    public void deletePets() {
        driver.navigate().refresh();
        int index = 0;
        List<WebElement> deleteButtonList = driver.findElements(deleteButton);

        for (int i = 0; i < driver.findElements(specificPetType).size(); i++) {
            if (driver.findElements(specificPetType).get(i).getAttribute("value").equals("pasareG")) {
                index = i;
                System.out.println("index = " + index);
                break;
            }
        }
        for (int j = 0; j < deleteButtonList.size(); j++) {
            if (j == index) {
                System.out.println("j=" + j);
                System.out.println(deleteButtonList.get(j).getText());
                deleteButtonList.get(j).click();
                break;
            }
        }
    }

    public void deletePetsWithList() {
        driver.navigate().refresh();
        int index = 0;
        List<WebElement> deleteButtonList = driver.findElements(deleteButton);

        for (int i = 0; i < driver.findElements(specificPetType).size(); i++) {
            if (driver.findElements(specificPetType).get(i).getAttribute("value").equals(animal)) {
                index = i;
                break;
            }
        }
        for (int j = 0; j < deleteButtonList.size(); j++) {
            if (j == index) {
                deleteButtonList.get(j).click();
                break;
            }
        }
    }

    public boolean checkPetsList() {
        driver.navigate().refresh();
        List<WebElement> petsList = driver.findElements(specificPetType);
        boolean flag = false;
        for (int i = 0; i < petsList.size(); i++) {
            if (!petsList.get(i).getAttribute("value").contains("flamingoG")) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean checkPetsWithList() {
        List<WebElement> petsList = driver.findElements(specificPetType);
        boolean flag = false;
        for (int i = 0; i < petsList.size(); i++) {
            if (petsList.get(i).getAttribute("value").contains(animal)) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
