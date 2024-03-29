package com.automation.tests.day25_excel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadDataFromExcel {


    @Test
    public void readExcelFileTest() throws IOException {
// we need to get a file as an object
        File file=new File("VytrackTestUsers.xlsx");
        //object that represents excel file

        Workbook workbook= WorkbookFactory.create(file);  // it is coming from apache.io

            //get QA1-short
        Sheet workSheet= workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow= workSheet.getRow(0);
        //get 1st cell
        Cell firstCell=firstRow.getCell(0);
        //get string value
        String value=firstCell.getStringCellValue();
        String secondCellValue= firstRow.getCell(1).getStringCellValue();

        System.out.println("value = " + value);
        System.out.println("secondCellValue = " + secondCellValue);

           int lastCell= firstRow.getLastCellNum();

           for (int i=0; i<lastCell; i++){
               System.out.print(firstRow.getCell(i) + " |  ");
           }
         //last row is 16th --->>> index is 15
          int numberOfRows=workSheet.getLastRowNum() ;
        System.out.println("numberOfRows = " + numberOfRows);


        //returnns how many rows at all
        int numberOfRows2=workSheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows2 = " + numberOfRows2);

        System.out.println("#######################");


        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell <workSheet.getRow(row).getLastCellNum() ; cell++) {
                String cellValue=workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue+ "  |  ");

            }
            System.out.println();
        }


    }
    @Test
    public void excelUtilityTest(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-all";
        ExcelUtil excelUtil=new ExcelUtil(path, spreadSheet);

         //  excelUtil.getDataList().forEach(System.out::println);

           for (Map<String, String>record : excelUtil.getDataList()){
               System.out.println(record);
           }
    }

    @Test
    public void getColumnNamesTest(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-all";
        ExcelUtil excelUtil=new ExcelUtil(path, spreadSheet);

        System.out.println(excelUtil.getColumnsNames());

    }





}
