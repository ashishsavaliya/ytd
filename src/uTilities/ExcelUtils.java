package uTilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	String fileName = "./TestData/SiteData.xlsx";

	public String ReadExcel(String sheetName, int rowNum, int CellNum) {
		String value = null;

		try {

			DataFormatter dft = new DataFormatter();
			FileInputStream fis = new FileInputStream(fileName);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.getCell(CellNum);
			value = dft.formatCellValue(cell);

		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}
	
	public String WriteExcel(String sheetName, int rowNum, int CellNum, String message) {
		String value = null;

		try {

			DataFormatter dft = new DataFormatter();
			FileInputStream fis = new FileInputStream(fileName);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(rowNum);
			XSSFCell cell = row.createCell(CellNum);
			value = dft.formatCellValue(cell);
			cell.setCellValue(message);
			FileOutputStream fileOut = new FileOutputStream(fileName);
		    workbook.write(fileOut);
		    fileOut.flush();
		    fileOut.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return value;

	}

}
