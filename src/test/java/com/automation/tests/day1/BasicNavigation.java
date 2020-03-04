package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://facebook.com");
        Thread.sleep(2000);
        driver.navigate().to("http://twitter.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(2000);
        Thread.sleep(2000);
        String title=driver.getTitle();
        System.out.println(title);

        driver.quit();
    }
}
