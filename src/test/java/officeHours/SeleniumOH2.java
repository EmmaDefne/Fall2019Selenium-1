package officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {

    public static void main(String[] args) {
        /*
        1. Go to http://automationpractice.com
        2. Search for 'tshirt' in a
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

    }
}
