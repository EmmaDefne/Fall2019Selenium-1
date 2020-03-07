package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calisma {
    public static void main(String[] args) throws InterruptedException {


     WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();

        driver.get("https://www.hepsiburada.com/");
        Thread.sleep(5000);
        WebElement search= driver.findElement(By.id("productSearch"));
        search.sendKeys("ayakkabi", Keys.ENTER);
         Thread.sleep(2000);
         WebElement moda=driver.findElement(By.linkText("Moda"));
         moda.click();
         Thread.sleep(4000);


}
}