package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class RadioButton {


    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().version("81").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        //butun radiobuttonlari almak icin list yaptik
        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));
        for (WebElement radioButton : radioButtons){

            String id=radioButton.getAttribute("id");

            //return true if button alreadyy clicked
            boolean isSelected=radioButton.isSelected();
            System.out.println(id+ " is selected" + isSelected);

            //to check if button can be clicked
            if (radioButton.isEnabled()){
                radioButton.click();
                System.out.println("clicked on: " + radioButton.getAttribute("id")); //every radio button has id
                BrowserUtils.wait(1);
            }else {
                System.out.println("button is disabled");
            }
            System.out.println("   ");
        }


        driver.quit();
    }
}

