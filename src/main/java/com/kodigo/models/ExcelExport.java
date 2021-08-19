package com.kodigo.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelExport {

    /**
     * Receives a 2 dimensional array containing the flight or flights information.
     * The user can select the save path via a JFileChooser.
     * The file is saved as an .xlxs file with the current date and Time.
     * If no path is selected, then the file will be saved on C:\
     * @param flights Flight information. "Flight Number", "Airline", "Aircraft Type", "Origin", "Destination", "Departure", "Arrival", "Cancelled Reason", "Incidents"
     * @throws IOException Exception
     */
    public void writeToExcel (Object[][] flights) throws IOException {
        //Workbook object creation

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            //Sheet object creation
            XSSFSheet sheet = workbook.createSheet("Flight Report");

            //Header titles for rows
            String[] headersTitle = new String[] {"Flight Number", "Airline", "Aircraft Type", "Origin", "Destination", "Departure", "Arrival", "Cancelled Reason", "Incidents"};

            //Header row insertion into sheet
            XSSFRow header = sheet.createRow(0);
            XSSFCell c;
            for (int i = 0; i < headersTitle.length; i ++) {
                c = header.createCell(i);
                c.setCellValue(headersTitle[i]);
            }

            //Flight Records insertion into sheet via foreach loop
            //Row count set to 1 to skip header row
            int rowCount=1;
            for(Object[] emp:flights)
            {
                XSSFRow row=sheet.createRow(rowCount++);
                int columnCount=0;
                for(Object value:emp)
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

            ///
            //Get Path for save file
            ///

            FileExplorer explorer = new FileExplorer();
            //JFileExplorer message
            String message = "Please select the folder to save the file";
            //Date and Time Format
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyy HH_mm_ss");
            Date date = new Date();

            //Get path from File Explorer
            //If path is null, File is saved to C:\
            String filePath= explorer.getPath(message,1,null);
            if (filePath == null) {
                filePath = System.getProperty("user.home") + "\\Flights" + formatter.format(date) + ".xlsx";
                System.out.println("No path selected, file will be saved at User's main folder");
            } else {
                filePath = filePath + "\\Flights"  + formatter.format(date) + ".xlsx";
            }

            //Stream to Path
            FileOutputStream outStream = new FileOutputStream(filePath);
            //Workbook set to outStream
            workbook.write(outStream);

            outStream.close();

            System.out.println("Flights file written successfully...");
        }
    }
}
