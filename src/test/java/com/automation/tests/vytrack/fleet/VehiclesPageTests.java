package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/entity/Extend_Entity_Carreservation";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By locator=By.xpath("//span[@class=‘title title-level-1’ and contains (text(), 'Fleet')]") ;
    //burada sadece title title-level-1 yazsaydik butun title lari veriyordu, o yuzden specifik yapmaliyiz


    @Test
     public void verifyPageSubTitle(){
    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password);
    BrowserUtils.wait(3);
    driver.findElement(By.className("title title-level-2\n")).click();



}







    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("81").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}

