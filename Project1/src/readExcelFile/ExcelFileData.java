package readExcelFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileData {
	static FileInputStream fis;
	static XSSFSheet sheet;
	public static XSSFSheet readExcelData(String Sheet) {
		try {
			fis= new FileInputStream("C:\\Users\\purva\\OneDrive\\Documents\\Project1TestData.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet=workbook.getSheet(Sheet);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			
		
	return sheet;
	}

}
