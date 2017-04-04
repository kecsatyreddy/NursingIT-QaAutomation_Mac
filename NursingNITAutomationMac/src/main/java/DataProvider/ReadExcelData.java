/**
 * 
 */
package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author SMuppidi
 *
 */
public class ReadExcelData {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ReadExcelData()
	{
		try {
			File src = new File("./TestData/TestData1.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			System.out.println("Excel is loaded");
		} catch (FileNotFoundException e) {
			System.out.println("File not located");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Exception while loading excel sheet");
			System.out.println(e.getMessage());
		}
	}
	public String getStringData(String sheetName, int rowIndex, int columnIndex) {
		//sheet1 = wb.getSheet(sheetName);
		String data = wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		return data;
	}
	public int getNumericalData(String sheetName, int rowIndex, int columnIndex) {
		//sheet1 = (int)wb.getSheet(sheetName);
		int data = (int)wb.getSheet(sheetName).getRow(rowIndex).getCell(columnIndex).getNumericCellValue();
		return data;
	}
	
	/*public String getData(String sheetName, int row, int column) {
		sheet1 = wb.getSheetAt(sheetName);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}*/
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
	public int getColCount(int sheetIndex, int row) {
		int col = wb.getSheetAt(sheetIndex).getRow(row).getLastCellNum();
		return col;
	}
	public void setExcelData(String sheetName, int rowIndex, int columnIndex, String result)
	{
	wb.getSheet(sheetName).getRow(rowIndex).createCell(columnIndex).setCellValue(result);
	}

}