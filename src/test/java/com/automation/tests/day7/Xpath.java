package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

    public static String userNameLocator= "//label[text()='Username']/following-sibling::input";

    public static String passwordLocator="//label[text()='Password']/following-sibling::input";

    public static String  loginButton="//button[contains(text(),'Login')] ";
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("cybertek");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("12345");
        driver.findElement(By.xpath(loginButton)).click();

        BrowserUtils.wait(3);
        driver.quit();

    }
}
