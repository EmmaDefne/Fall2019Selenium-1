package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");


        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click(); //click on first checkbox
        BrowserUtils.wait(2);
        //checkBoxes.get(1).click(); //click on the second checkbox

        //go over collection of checkboxes
        for (int i = 0; i <checkBoxes.size() ; i++) {
            //if visible                         //eligible to click and             //not clicked yet
        if (!checkBoxes.get(i).isDisplayed() && checkBoxes.get(i).isEnabled()&& (!checkBoxes.get(i).isSelected())){
            checkBoxes.get(i).click(); //click on the second button
            System.out.println((i+1+ "  checkbox clicked"));

        }
        else {
            System.out.println((i+1+ "  checkbox wasn't clicked"));
        }
        }
        BrowserUtils.wait(2);

        driver.quit();
    }


}
