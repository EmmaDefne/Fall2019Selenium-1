package com.automation.tests.day10_vytrack;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

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

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest() {
        report = new ExtentReports();
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }

        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
public void tearDownTest(){
        report.flush(); //to release a report
}


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
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshotPath);//attach screenshot
            test.fail(iTestResult.getName());//attach test name that failed
            test.fail(iTestResult.getThrowable());//attach console output
        }
        Driver.closeDriver();
    }
}
