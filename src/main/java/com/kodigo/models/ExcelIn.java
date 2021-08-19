package com.kodigo.models;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelIn {

    /**
     *  Opens an .xlsx file and returns the content of it in a String array. If no file is selected, an empty array will be returned
     * @return String[][] Excel file contents
     */
    public String[][] getExcelData () {
        String[][] excelData = {};

        try {
            //Get Path of File
            FileExplorer explorer = new FileExplorer();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (.xlsx) ",".xlsx", "xlsx");
            String message = "Pick The Excel File you Wish to Insert";
            String path = explorer.getPath( message,0, filter);

            //If no path is selected, return empty array
            if (path == null){
                return excelData;
            }

            // Create a file input stream to read Excel workbook and worksheet
            try (   FileInputStream inputStream = new FileInputStream(path);
                    XSSFWorkbook workbook = new XSSFWorkbook(inputStream))
            {
                XSSFSheet sheet = workbook.getSheetAt(0);

                // Get the number of rows and columns
                int numRows = sheet.getLastRowNum()+1;
                int numCols = sheet.getRow(0).getLastCellNum();

                //Create 2 dimensional array with number of rows and columns
                //Final array to be returned
                excelData = new String[numRows][numCols];

                //Create a XSSFRow for each row, then cycle through the columns
                //Create a XSSFCell for each column and grab the value in the (i,j) cell
                for (int i = 0; i < numRows; i++) {
                    XSSFRow row = sheet.getRow(i);
                    for (int j = 0; j < numCols; j++) {
                        XSSFCell cell = row.getCell(j);
                        //Switch used to store Dates properly
                        CellType type = cell.getCellType();

                        switch (type) {
                            case STRING:
                                excelData[i][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                excelData[i][j] = cell.getDateCellValue().toString();
                                break;
                            default:
                                excelData[i][j] = cell.getRawValue();
                                break;
                        }
                    }
                }
            }


        } catch (IOException e) {
            System.out.println("ERROR FILE HANDLING " + e);
        }
        return excelData;
    }

}
