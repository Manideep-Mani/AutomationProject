package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("ENTER");
	Row rw = sh.createRow(4);
	 Cell c = rw.createCell(4);
	c.setCellValue("Advance Selenium");
	FileOutputStream fos=new FileOutputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	book.write(fos);
	System.out.println("PASS");
	book.close();
	
	
	
	
	
	
	
}
}
