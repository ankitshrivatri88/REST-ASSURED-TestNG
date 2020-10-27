package utils;

public class excelUtilTest {
    public static void main(String[] args){

        String excelPath = "./data/DataDriven.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils excel= new ExcelUtils(excelPath,sheetName);
        excel.getRowCount();
        excel.getCellData(1,0);
        excel.getCellData(1,1);
        excel.getCellData(1,2);

    }
}
