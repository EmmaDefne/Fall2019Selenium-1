package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {


    public static void main(String[] args) throws InterruptedException {
        // to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

       WebDriver driver=new ChromeDriver();
        //in selenium everything starts from web driver interface
             driver.get("http://google.com");
        Thread.sleep (3000);//for demo, wait 3 seconds

        String title =driver.getTitle(); //returns <<title>Google</title>
        String expectedTitle= "yahoo";

        System.out.println("title is " + title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.close();


    }
}
