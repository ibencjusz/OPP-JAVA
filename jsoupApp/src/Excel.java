
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;

public class Excel
{

    private static String[] columns = {"Marka", "Cena", "Rok", "Dystans", "Pojemnosc", "Rodzaj", "Link do aukcji"};


    public static void append(Car[] carsTab){

    }


    public static void createExcel(Car[] carsTab) throws Exception{
        Workbook workbook = new HSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Test");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);
        //Row contentRow = sheet.createRow(1);

        /*
        for(int i=1;i<columns.length;i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(columns[i-1]);
        }
        */

        /*
        for (int i = 0; i < carsTab.length; i++) {
            System.out.println(carsTab[i].getName());
            //System.out.println(carsTab[i].getShortDescription());
            System.out.println(carsTab[i].getPrice());
            System.out.println(carsTab[i].getYear());
            System.out.println(carsTab[i].getDistance());
            System.out.println(carsTab[i].getCapacity());
            System.out.println(carsTab[i].getEngine());
            System.out.println((carsTab[i].getLink()));
            System.out.println("=======================================================");
        }
        */

        for(int i=0; i<columns.length;i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        //UZUPELNIA WIERSZE
        for(int i=0; i<carsTab.length;i++){
            Row contentRow = sheet.createRow(i+1);
            Cell cell = contentRow.createCell(0);
            Cell cell1 = contentRow.createCell(1);
            Cell cell2 = contentRow.createCell(2);
            Cell cell3 = contentRow.createCell(3);
            Cell cell4 = contentRow.createCell(4);
            Cell cell5 = contentRow.createCell(5);
            Cell cell6 = contentRow.createCell(6);

            cell.setCellValue(carsTab[i].getName());
            cell1.setCellValue(carsTab[i].getPrice());
            cell2.setCellValue(carsTab[i].getYear());
            cell3.setCellValue(carsTab[i].getDistance());
            cell4.setCellValue(carsTab[i].getCapacity());
            cell5.setCellValue(carsTab[i].getEngine());
            cell6.setCellValue(carsTab[i].getLink());
        }


        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }


        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xls");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }


}
