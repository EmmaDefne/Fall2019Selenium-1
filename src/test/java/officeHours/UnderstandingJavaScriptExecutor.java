package officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UnderstandingJavaScriptExecutor {


@Test (description = "send text to search box on etsy")
    public void test1(){


    WebDriver driver=DriverFactory.createDriver("chrome");
    driver.get("https://www.etsy.com/");

    JavascriptExecutor js=(JavascriptExecutor) driver;

    js.executeScript("document.getElementById('global-enhancements-search-query').value='books'");



}
@Test (description = "get the page title")
    public void Test2(){
    WebDriver driver=DriverFactory.createDriver("chrome");
    driver.get("https://www.etsy.com/");

    JavascriptExecutor js=(JavascriptExecutor) driver;

   String pageTitle= js.executeScript("return document.title").toString(); //returnu title i  versin diye yazdik
    //return keyword before the script is for selenium to know that it needs to bring back information
    System.out.println(pageTitle);




}

}
