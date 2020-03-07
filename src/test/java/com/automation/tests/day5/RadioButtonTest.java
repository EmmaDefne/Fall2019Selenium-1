package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {


    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowserUtils.wait(2);
        WebElement blackButton=driver.findElement(By.id("black"));
        //IF VISIBLE AND ELIGIBLE TO CLICK
        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();

        }else {
            System.out.println("FAILED TO CLICK ON");
        }
        BrowserUtils.wait(2);

          //how do we verify that button clicked
        if (blackButton.isSelected()){
            System.out.println("PASSED TEST");
        }else {
            System.out.println("TEST FAILED");
        }


        driver.quit();



    }
}
