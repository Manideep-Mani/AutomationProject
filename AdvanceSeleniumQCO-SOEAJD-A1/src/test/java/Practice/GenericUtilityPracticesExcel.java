package Practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;

public class GenericUtilityPracticesExcel {
	public static void main(String[] args) throws Throwable {
		ExcelFileUtility efu=new ExcelFileUtility();
		String data = efu.readDatafromExcel("Sheet1",1,1);
		System.out.println(data);
		
		
		//efu.writeDataintoExcel("Main",1,1,"Practices");
		System.out.println("Pass");
		
		JavaUtility j=new JavaUtility();
		
		System.out.println(j.getRandomNumber());
		System.out.println(j.getDate());
		
		
	}
}
