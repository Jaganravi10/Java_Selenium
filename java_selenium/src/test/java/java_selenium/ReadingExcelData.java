package java_selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadingExcelData {

		@Test
		@DataProvider(name="IOC statement")
		public Object[][] excelData() throws IOException {
			
		File excelFile = new File(System.getProperty("user.dir")+"\\IOC STATEMENT.xlsx");	
		FileInputStream excelInput = new FileInputStream(excelFile);	
		XSSFWorkbook excelWorkBook = new XSSFWorkbook(excelInput);
		
		
		XSSFSheet excelSheet = excelWorkBook.getSheet("FinancialTransactionStatement10");
		int rowCount = excelSheet.getLastRowNum();
		int columnCount = excelSheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rowCount][columnCount];
			
		for(int r=0;r<rowCount;r++) {
			
			XSSFRow row = excelSheet.getRow(r+1);
			
			for(int c=0;c<columnCount;c++) {
				
				XSSFCell cell = row.getCell(c);
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[r][c] = Integer.toString((int)cell.getNumericCellValue());
					break;
				}
			}
		}
		
		return excelData();
		} 

}
