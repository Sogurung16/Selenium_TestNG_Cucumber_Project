package org.sonam.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtility {
    private static XSSFSheet sheet;
    private static XSSFWorkbook workbook;

    public ExcelUtility(String filePath, String xssfSheet){
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(xssfSheet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getCellValue(int row, int coloumn){
        return sheet.getRow(row).getCell(coloumn).getStringCellValue();
    }

    public int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount(){
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }
}
