package com.automation.tests.day10_vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public abstract class AbstractTestBase {
    //testBase abstract class that is used as a basement for all test classes
    //class is abstract because has to be extended
    //We provide setup and clean up part for all our test
    //whenever we inherit this testBase class we have minimum essential/required setup and clean up for every test of our project
    //what else we can add => actions,  actions class object is generic
    //does not contain test itself !!
    //in this class, we initialize WebDriverWait
    //                             Actions class objects
    //                             open the browser
    //We can also add @Before/After test, class, suit methods if needed
    //Should be store under => tests package <=  or some kind of base package; BUT NOT UNDER THE UTILITIES PACKAGE!
    //TestBase class => we do not call any single method from this class or we do not instantiate it!
    //It's a blueprint for all test classes
    //protected = same package + sub class
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        //We instantiate webDriver (=new className) in Driver class under utilities package.
        //getDriver();  method will return us driver object that comes from driver class./driver class is singleton
        //call the static getDriver() method through the classNAme
        //By doing this; we will know that we are always calling the same driver
        Driver.getDriver().manage().window().maximize();
        //we can not use implicit and explicit test in same test, will conflict each other
        //implicit wait does not get along with explicit wait.if you use them in same test,
        //it might cause unexpectedly long delays
        //if we would use implicit wait ; it would go into @BeforeMethod
        //explicit wait use inside @test itself, since we have to provide web element
        //unless your @BeforeMethod use some kind of web elements
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
