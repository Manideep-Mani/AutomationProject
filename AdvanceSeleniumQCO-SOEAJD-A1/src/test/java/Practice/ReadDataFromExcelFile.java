package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
public static void main(String[] args) throws Throwable {
	FileInputStream fs = new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	Workbook book = WorkbookFactory.create(fs);
	Sheet sh=book.getSheet("Sheet1");
	Row r=sh.getRow(0);
	Cell c = r.getCell(0);
	String data = c.getStringCellValue();
	System.out.println(data);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
