package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("81").setup();
        driver=new ChromeDriver();

    }
@Test
    public void scrollTest() {
    driver.get("http://practice.cybertekschool.com/infinite_scroll");
    BrowserUtils.wait(3);

    //you need to cast if reference type is a web driver
    // JavascriptExecutor js=(JavascriptExecutor) driver;
    //scroll down 250 pixels
    // x, y
    for (int i = 0; i < 10; i++) {
        driver.executeScript("window.scrollBy(0,250)");
        BrowserUtils.wait(3);
    }
    BrowserUtils.wait(3);

}
         @Test
            public void scrollToElementTest(){

        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
             BrowserUtils.wait(3);

             WebElement link=driver.findElement(By.linkText("Cybertek School"));

             //scrollIntoView - javascript method
             //arguments[0] -means 1st web element after comma
             driver.executeScript("arguments[0].scrollIntoView(true)", link);

    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();

    }
}
