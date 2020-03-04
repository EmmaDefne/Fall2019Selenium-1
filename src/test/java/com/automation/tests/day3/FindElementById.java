package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);
        //driver.findElement(By.name("password")).sendKeys("1233455"); shortway
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);

        //let's click on logout button. it looks like a button, but it is actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partiaLinkText instead of linktext
        //linktest -equals()
        //partialLinkTest -contains ()

        WebElement logout=driver.findElement(By.linkText("Logout")); //don't put space logout
        logout.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
