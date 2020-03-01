package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {


    public static void main(String[] args) throws InterruptedException {
        // to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //in selenium everything starts from web driver interface
        driver.get("http://google.com");
        // driver.manage().window().maximize();// to maximize browser
        Thread.sleep(3000);//for demo, wait 3 seconds

        String title = driver.getTitle(); //returns <<title>Google</title>

        //to get URL
        System.out.println("URL : " + driver.getCurrentUrl());
        String expectedTitle = "Google";

        System.out.println("title is " + title);
        if (expectedTitle.equals(title)) {
            System.out.println("TITLE TEST PASSED");
        } else {
            System.out.println("TITLE TEST FAILED");
        }

        driver.navigate().to("http://facebook.com");
        if (driver.getTitle().toLowerCase().contains("facebook")) {
            System.out.println(" CONTAIN TEST PASSED");

        } else {
            System.out.println("CONTAIN TEST FAILED");
        }

        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");
        driver.navigate().forward();
        System.out.println("title: " + driver.getTitle());
        //driver.getTitle() --- returns page title of the page that is currently opened
        driver.navigate().refresh();
        driver.close();


    }

    //burada stringler esit mi diye bakti?!
    public static void verifyEquals(String arg1, String arg2) {

        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");


        }
    }
}

