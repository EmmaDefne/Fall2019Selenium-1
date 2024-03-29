package officeHours;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UnderstandingExcelConnection {

    @Test
    public void readingExcelFile() throws IOException {
        //which file are we calling upon. location of file
         String filepath= "Countries.xlsx";

         //we must load our excel file as java file(bytecode)
        FileInputStream byteCodeOfExcelFile=new FileInputStream(filepath);
        //load our workbook as a file
        Workbook workbook=  WorkbookFactory.create(byteCodeOfExcelFile);

        //the sheet that we are working on
        Sheet workSheet=workbook.getSheet("Countries");

//Read the cell data of cell 1A AND CELL 1B
        //to load the cell we need the row and column reference -->
        // as index numbers row 1= index 0 and column A= index 0
        // as index numbers row 1= index 0 and column b= index 1


        Cell cell;
        cell=workSheet.getRow(0).getCell(0);
        System.out.println("cell = " + cell.toString());//print the first cell


        Cell cell2=workSheet.getRow(0).getCell(1);
        System.out.println("cell2 = " + cell2);
    }
}
