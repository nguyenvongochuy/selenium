package com.letskode.datadriven_ddt.demoaccessexcel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.concurrent.Callable;

public class ExcelRead {


    public static void main(String[] argv) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;
        XSSFCell cell;

        String path = "/home/huy/IdeaProjects/selenium/Selenium/src/main/java/com/letskode/datadriven_ddt/loginddt/data/excelTest.xlsx";
        String sheetName = "sheet1";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            workBook = new XSSFWorkbook(fileInputStream);
            sheet = workBook.getSheet(sheetName);

            cell = sheet.getRow(0).getCell(0);
            System.out.println("Cell value: " + cell.getStringCellValue());

        } catch(Exception e){
                e.printStackTrace();
            }


        }

    }
