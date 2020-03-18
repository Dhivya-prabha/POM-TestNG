package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static Object[][] readFile(String filename) throws IOException 
	{
		XSSFWorkbook rbook = new XSSFWorkbook("./data/" + filename + ".xlsx");
		XSSFSheet sheet = rbook.getSheetAt(0);
		int rcount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rcount + ", " + colCount);
		Object[][] data = new Object[rcount][colCount];
		for (int i = 1; i <= rcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
				data[i - 1][j] = value;
			}
		}
		rbook.close();
		System.out.println(data[0][0]);
		return data;

	}

	/*
	 * XSSFWorkbook rbook = new XSSFWorkbook("./data/tabelData.xlsx"); XSSFSheet
	 * sheet = rbook.getSheetAt(0); int rcount = sheet.getLastRowNum(); int colCount
	 * = sheet.getRow(0).getLastCellNum(); System.out.println(rcount+", "
	 * +colCount); Object[][] data = new Object[rcount][colCount]; for (int i = 1; i
	 * < rcount; i++) { XSSFRow row = sheet.getRow(i); for (int j = 0; j <
	 * row.getLastCellNum(); j++) { XSSFCell cell = row.getCell(j); String value =
	 * cell.getStringCellValue(); data[i-1][j] = value;
	 * 
	 * // System.out.print(data[i][j]); } // System.out.println();
	 * 
	 * } rbook.close(); // System.out.println(data[0][0]); return data; }
	 */
}
