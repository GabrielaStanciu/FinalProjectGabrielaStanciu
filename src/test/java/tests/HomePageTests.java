package tests;

import Pages.Home;
import Pages.Owners;
import Pages.PetTypes;
import Pages.WelcomeFragment;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTests {
    WebDriver driver;
    private String baseurl = "http://bhdtest.endava.com/petclinic/";
    WelcomeFragment welcomeFragment;
    PetTypes petTypes;
    Owners owners;


    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/config/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        welcomeFragment = new WelcomeFragment(driver);
        petTypes = new PetTypes(driver);
    }

    @Test
    public void checkElements(){
        welcomeFragment = new WelcomeFragment(driver);
        Assert.assertEquals(welcomeFragment.getHomeText(),"HOME");
        Assert.assertEquals(welcomeFragment.getOwnersText(),"OWNERS");
        Assert.assertEquals(welcomeFragment.getVeterninariansText(), "VETERINARIANS");
        Assert.assertEquals(welcomeFragment.getPetTypesText(), "PET TYPES");
        Assert.assertEquals(welcomeFragment.getSpeciltiesText(), "SPECIALTIES");
   }

    @Test
    public void checkHomePage(){
        Home home= new Home(driver);
        home.initWelcomebutton();
        Assert.assertEquals("Welcome", home.welcomeButton.getText());
    }

    @Test
    public void addPetType() throws InterruptedException {
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.clickOnPetTypes();
        petTypes.getPettype();
        petTypes.petsInList();
        Assert.assertTrue(petTypes.petsInList());
    }
    @Test
    public void addPetsWithRandom() throws InterruptedException {
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.clickOnPetTypes();
        petTypes.getPettypeWithRandom();
        Assert.assertTrue(petTypes.checkPetsInListWithGivenList());
    }


    @Test
    public void deletePetswithList() throws InterruptedException {
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.clickOnPetTypes();
        petTypes.getPettypeWithRandom();
        petTypes.deletePetsWithList();
        Assert.assertTrue(petTypes.checkPetsWithList());
    }

    @Test
    public void deletePetss() throws InterruptedException {
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.clickOnPetTypes();
         petTypes.getPettype();
        petTypes.deletePetsWithList();
        Assert.assertTrue(petTypes.checkPetsList());
    }

    @Test
    public void addOwners() throws InterruptedException {
        Owners owners = new Owners(driver);
        welcomeFragment = new WelcomeFragment(driver);
        welcomeFragment.clickOnOwners();
        welcomeFragment.clickOnAddOwners();
        owners.putFirstName();
        owners.putLastName();
        owners.putAddress();
        owners.putCity();
        owners.putTelephone();
        owners.clickOnAddOwnerButtonFinal();

    }




}
