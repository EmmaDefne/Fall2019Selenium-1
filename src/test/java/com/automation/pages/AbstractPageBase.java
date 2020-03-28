package com.automation.pages;

//this class will be extended by page classes
// ant common webelements/ locators can be stored here
//since navigation menu doesn't belong to particular page
//we cannot really create a dedicated page class to store
//elements from that menu


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);

    }

    /**
     * Method for Vytrack navigation. provide tab name and module name to navigate
     *
     * @param tabName,    like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles, Vehicles Odometer and Vehicle Costs
     */

    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));


        Actions actions = new Actions(driver);
        BrowserUtils.wait(3);
        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();

    }

}



