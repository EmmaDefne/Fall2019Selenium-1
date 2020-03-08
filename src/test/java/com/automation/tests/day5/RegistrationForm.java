package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");

        BrowserUtils.wait(2);

        driver.findElement(By.name("firstname")).sendKeys("emel");
        driver.findElement(By.name("lastname")).sendKeys("gumus");
        driver.findElement(By.name("username")).sendKeys("mlg");
        driver.findElement(By.name("email")).sendKeys("emel@gmail.com");
        driver.findElement(By.name("password")).sendKeys("fghjgfewjfgewjk");
        driver.findElement(By.name("phone")).sendKeys("571-343-2342");

        List<WebElement> genders= driver.findElements(By.name("gender"));
        genders.get(2).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2009");
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(2);

        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(2);

        driver.quit();






    }
}


