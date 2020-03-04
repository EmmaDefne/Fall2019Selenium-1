package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {


       // WebDriverManager.chromedriver().setup();
       // WebDriver driver=new ChromeDriver();


        //short version
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        Thread.sleep(4000);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Miss Gumustop");
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys("emel@hotmail.com");

        WebElement signUp=driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        driver.quit();
    }
}
