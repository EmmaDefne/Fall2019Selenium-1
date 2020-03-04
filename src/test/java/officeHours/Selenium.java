package officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
    public static void main(String[] args) {

/*
id - unique (it is not always available) -we always want to use it
class-className
tag

will only work with the link
link text
partial linktext


locator that is using html (syntax)
css
xpath


--------
<input id="global-enhancements-search-query"
 data-id="search-query" data-global-enhancements-search-input=""
  type="text" name="search_query"
  class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
   placeholder="Search for items or shops" value="" autocomplete="off" autocorrect="off" autocapitalize="off">

   key -----"value" - attributes

   input ---> TAG

   id="global-enhancements-search-query" -one of the attributes
   we can use id to locate the element

  name="search_query" -attribute - we can use name to locate the element

  class="wt-input wt-input-btn-group__input global-enhancements-search-input-btn-group__input wt-pr-xs-7"
  -we can use class to locate element


  when we want to find element it is always must be unique



 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://etsy.com" );
        WebElement searchBar=driver.findElement(By.id("global-enhancements-search-query"));


    }
}
