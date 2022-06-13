package org.sonam.util;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
    private static ExcelUtility excel;

    @DataProvider(name = "Credentials")
    public Object[][] getExcelData(String filePath, String sheet){
        excel = new ExcelUtility(filePath, sheet);

        int rowCount = excel.getRowCount();
        int columnCount = excel.getColumnCount();

        Object[][] data = new String[rowCount-1][columnCount];
        for(int i=1; i<rowCount; i++){
            for(int j=0; j<columnCount; j++){
                String cellData = excel.getCellValue(i,j);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    public static String getCellValue(String usernameCellLocation){
        String[] cellLocationValue = usernameCellLocation.split(",");
        int cellRowLocation = Integer.valueOf(cellLocationValue[0]);
        int cellColumnLocation = Integer.valueOf(cellLocationValue[1]);

        return excel.getCellValue(cellRowLocation,cellColumnLocation);
    }
}
