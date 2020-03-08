package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");

        BrowserUtils.wait(2);


        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        BrowserUtils.wait(2);

       // String filePath = System.getProperty("user.dir")+"/pom.xml";
        String filePath2= "/Users/mlg/Pictures/Scan 1.jpeg";  //use option key
                upload.sendKeys(filePath2);
        upload.sendKeys(filePath2);
        driver.findElement(By.id("file-submit")).click();//click to upload
        BrowserUtils.wait(5);
        System.out.println(filePath2);
        driver.quit();
    }
}

