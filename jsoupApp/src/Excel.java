
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class Excel
{

    private static String[] columns = {"Marka", "Model" ,"Cena", "Rok", "Dystans", "Pojemnosc", "Rodzaj", "Link do aukcji"};




    public static void createExcel(ArrayList<Car> arrayList) throws Exception{
        Workbook workbook = new HSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Lista");

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

        for(int i=0; i<columns.length;i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        //UZUPELNIA WIERSZE
        for(int i=0; i<arrayList.size();i++){
            Row contentRow = sheet.createRow(i+1);
            Cell cell = contentRow.createCell(0);
            Cell cell0 = contentRow.createCell(1);
            Cell cell1 = contentRow.createCell(2);
            Cell cell2 = contentRow.createCell(3);
            Cell cell3 = contentRow.createCell(4);
            Cell cell4 = contentRow.createCell(5);
            Cell cell5 = contentRow.createCell(6);
            Cell cell6 = contentRow.createCell(7);

            cell.setCellValue(arrayList.get(i).getName());
            cell0.setCellValue(arrayList.get(i).getModel());
            cell1.setCellValue(arrayList.get(i).getPrice());
            cell2.setCellValue(arrayList.get(i).getYear());
            cell3.setCellValue(arrayList.get(i).getDistance());
            cell4.setCellValue(arrayList.get(i).getCapacity());
            cell5.setCellValue(arrayList.get(i).getEngine());
            cell6.setCellValue(arrayList.get(i).getLink());
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
