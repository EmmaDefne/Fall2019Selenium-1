package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import com.google.gson.internal.$Gson$Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class WarmUp {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
      //  ebayTest();
        amazonTest();
        // wikiTest();
    }

    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results
     */
    public static void ebayTest(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
       // System.out.println(Arrays.toString(searchSEntence));
        driver.quit();
    }

    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazonTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        //enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.RETURN); //ENTER DA KULLANABILIRSIN

        Thread.sleep(2000);//to wait 2 seconds

        String title = driver.getTitle();
        if(title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
 driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); // to get link as a String
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
}
