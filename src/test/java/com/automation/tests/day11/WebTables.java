package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
public class WebTables {
    private WebDriver driver;
    @Test
    public void getColumnNames(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames=driver.findElements(By.xpath("//table[1]//th"));
        for(WebElement columnName: columnNames){
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);
    }




    @Test
    public void verifyRowCount() {
        ////tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);
    }

   @Test
   public void getSpecificColumn(){

        List<WebElement> links=driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
       System.out.println(BrowserUtils.getTextFromWebElements(links));
   }







    @BeforeMethod
    public  void  setup(){
        WebDriverManager.chromedriver().version("81").setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it ti true to make it work
        chromeOptions.setHeadless(true); //to run browser withoput GUI. Makes browser invisible
        driver= new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

