package com.selencodes.datadriven_ddt.loginddt.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {
    private static XSSFWorkbook workBook;
    private static XSSFSheet sheet;

    public static void setExcelFile(String pathFile, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(pathFile);

            workBook = new XSSFWorkbook(fileInputStream);
            sheet = workBook.getSheet(sheetName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[][] getTestData(String tableName) {
        String[][] testData = null;

        try {
            XSSFCell[] boundaryCells = findCells(tableName);
            if (boundaryCells.length > 1) {
                XSSFCell startCell = boundaryCells[0];
                XSSFCell endCell = boundaryCells[1];

                int startRow = startCell.getRowIndex() + 1;
                int endRow = endCell.getRowIndex() - 1;
                int startCol = startCell.getColumnIndex() + 1;
                int endCol = endCell.getColumnIndex() - 1;

                testData = new String[endRow - startRow + 1][endCol - startCol + 1];

                int i=0;
                int j=0;
                for (int r=startRow ; r <= endRow; r++) {
                    for (int c = startCol; c <= endCol; c++) {
                        testData[i][j++] = sheet.getRow(r).getCell(c).getStringCellValue();
                    }
                    i++;
                    j=0;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return testData;
    }

    private static XSSFCell[] findCells(String tableName) {

        String pos = "begin__";
        XSSFCell[] cells = new XSSFCell[2];
        int count =  0;

        for (Row row : sheet)
            for (Cell cell : row) {
                if (cell.getStringCellValue().contains(tableName)) {
                    //if (tableName.equalsIgnoreCase(pos)) {
                        cells[count] = (XSSFCell) cell;
                        count++;
                        pos = "end__";
                    //} else {
                    //    cells[1] = (XSSFCell) cell;
                    }

            }
        return cells;
    }

}
