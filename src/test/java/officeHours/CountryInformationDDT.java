package officeHours;

import com.automation.utilities.Driver;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountryInformationDDT {

    WebDriver driver;
    Workbook workbook;
    Sheet workSheet;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;



    @BeforeTest

    public void setup() throws IOException {
        driver= Driver.getDriver();

        fileInputStream=new FileInputStream("Countries.xlsx");
        workbook= WorkbookFactory.create(fileInputStream);
        workSheet=workbook.getSheet("Countries ");
    }

    @Test
    public void test(){



    }
}
