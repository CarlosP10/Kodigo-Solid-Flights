package com.kodigo.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {

    /**
     * Receives a 2 dimensional array containing the flight or flights information.
     * The user can select the save path via a JFileChooser.
     * The file is saved as an .xlxs file with the current date and Time.
     * If no path is selected, then the file will be saved on the default user folder.
     * @param flights List of Flights in the System
     * @throws IOException Exception
     */
    public void writeToExcel (Object[][] flights) throws IOException {
        //Workbook object creation

        if (flights.length == 0) {
            System.out.println("No Flights Available to Export");
            return;
        }


        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            //Sheet object creation
            XSSFSheet sheet = workbook.createSheet("Flight Report");

            XSSFRow xssfRow;

            //Header titles for rows
            String[] headersTitle = new String[] {"Flight Number", "Airline", "Aircraft Type", "Origin", "Destination", "Departure", "Arrival", "Cancelled Reason", "Incidents"};

            //Header row insertion into sheet
            xssfRow = sheet.createRow(0);
            XSSFCell xssfCell;
            for (int column = 0; column < headersTitle.length; column ++) {
                xssfCell = xssfRow.createCell(column);
                xssfCell.setCellValue(headersTitle[column]);
            }
            
            //Flight Records insertion into sheet via foreach loop
            //Row count set to 1 to skip header row
            int rowCount = 1;
            for(Object[] flight:flights)
            {
                XSSFRow row=sheet.createRow(rowCount++);
                int columnCount=0;
                for(Object value:flight)
                {
                    XSSFCell cell=row.createCell(columnCount++);

                    if(value instanceof String) {
                        cell.setCellValue((String)value);
                    }
                    if(value instanceof Date) {
                        cell.setCellValue((Date) value);
                    }
                }
            }
            writeToOutStream(workbook);
        }
    }

    private String getFinalPath () {
        FileExplorer explorer = new FileExplorer(false);
        String pathToSaveFile = explorer.getPath();

        String dateFormat = "dd-MM-yyy HH_mm_ss";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Date date = new Date();

        if (pathToSaveFile == null) {
            System.out.println("No path selected, file will be saved at User's main folder");
            return System.getProperty("user.home") + "\\Flights" + formatter.format(date) + ".xlsx";
        }
        return pathToSaveFile + "\\Flights"  + formatter.format(date) + ".xlsx";
    }

    private void writeToOutStream (XSSFWorkbook workbook) throws IOException {
        FileOutputStream outStream = new FileOutputStream(getFinalPath());

        workbook.write(outStream);

        outStream.close();

        System.out.println("Flights file written successfully...");
    }
}
