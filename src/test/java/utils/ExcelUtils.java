package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

   static XSSFWorkbook workbook;
   static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName){
        try {
             workbook = new XSSFWorkbook(excelPath);
             sheet = workbook.getSheet(sheetName);
        }
        catch (Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void getCellData(int rownNum, int colNum){
          DataFormatter formatter = new DataFormatter();
          Object value =formatter.formatCellValue(sheet.getRow(rownNum).getCell(colNum));
          System.out.println(value);
    }

    public static void getRowCount(){
            int rowCount= sheet.getPhysicalNumberOfRows();
            System.out.println("No. of rows"+rowCount);
        }
    }


