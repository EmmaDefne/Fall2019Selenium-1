package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);
        //before looking for that element, we need to jump to that frame
        driver.switchTo().frame("mce_0_ifr");
        //now this content will be visible
        WebElement textInput=driver.findElement(By.id("tinymce"));

        System.out.println(textInput.getText());

        textInput.clear();
        textInput.sendKeys("write something ");
        BrowserUtils.wait(4);





        //exit from the frame
        driver.switchTo().defaultContent();


        WebElement heading=driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        BrowserUtils.wait(2);
        driver.quit();
    }
}
