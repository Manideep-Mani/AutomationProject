package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Manideep
 * This class consists of reusable methods related to Excel file
 *
 */
public class ExcelFileUtility {
	/**
	 * This method is used to read the data from excel file and return the value
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
public String readDatafromExcel(String sheetName,int row,int cell) throws Throwable
{
FileInputStream fis = new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
Workbook book = WorkbookFactory.create(fis);
String data = book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
book.close();
return data;

}
/**
 * This method will write data into Excel sheet
 * @param sheetName
 * @param row
 * @param cell
 * @param value
 * @throws Throwable
 */
public void writeDataintoExcel(String sheetName,int row,int cell,String value) throws Throwable
{
	FileInputStream fis = new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	book.createSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);

    FileOutputStream fos = new FileOutputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
    book.write(fos);
    book.close();
}


public Object[][] readMultipleDataFromExcel(String sheetName) throws Throwable
{
	FileInputStream fis = new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
		  data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();	
		
		}
		
	}
	return data;
	
}









}










