package com.automation.tests.day2;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BarnesAndNoble {
    public static void main(String[] args) {



    WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("https://www.barnesandnoble.com/");
        WebElement search= driver.findElement(By.id("searchBarBN"));
        search.sendKeys("history", Keys.ENTER);
        BrowserUtils.wait(2000);
       // print number of results
    WebElement searchResult=driver.findElement(By.tagName("h1"));
        System.out.println("searchResult = " + searchResult.getText());



        // WebElement moda=driver.findElement(By.linkText("Moda"));
       //  moda.click();
        // Thread.sleep(4000);


}
}
