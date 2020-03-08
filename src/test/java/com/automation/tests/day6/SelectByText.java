package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {


        WebDriver driver= DriverFactory.createDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement simpleDropDown= driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown=new Select(simpleDropDown);
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropDown.selectByVisibleText("Option 1");

        Select selectYear=new Select(driver.findElement(By.id("year")));
        Select selectMonth=new Select(driver.findElement(By.id("month")));
        Select selectDay=new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1983");
        selectMonth.selectByVisibleText("November");
        selectDay.selectByVisibleText("4");
        BrowserUtils.wait(2);

        //select all months one by one

        List<WebElement> months=selectMonth.getOptions();
        for (WebElement month : months) {
            //get the month name and select based on that
            selectMonth.selectByVisibleText(month.getText());
            System.out.println(month.getText());
            BrowserUtils.wait(2);
        }








        BrowserUtils.wait(3);
         driver.quit();





    }
}
