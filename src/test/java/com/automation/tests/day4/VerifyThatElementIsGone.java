package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    /**
     * INTERVIEW QUESTION
     * HOW TO CHECK IF ELEMENT DOESN'T EXISTS ANYMORE IN THE DOM (DOCUMENT OBJECT MODEL)
     */


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);
       List<WebElement> list=driver.findElements(By.id("disappearing_button"));
        if (list.size() ==0){
      System.out.println("TEST PASSED");
      }else {
      System.out.println("TEST FAILED");
}


    }
}
