package com.automation.pages;

import com.automation.pages.LoginPage;
import com.automation.tests.day10_vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends TestBase {
    /**
     * Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        BrowserUtils.wait(3);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        BrowserUtils.wait(3);


    }


    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
    }


}


