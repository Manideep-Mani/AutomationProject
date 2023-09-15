package Practice;

import vtiger.GenericUtilities.PropertyfileUtility;

public class GenericUtilityPracticesPropertyfile {
public static void main(String[] args) throws Throwable {
	PropertyfileUtility pf=new PropertyfileUtility();
	String data = pf.readDatafromPropertyfile("pwd");
	System.out.println(data);
	
	String data1 = pf.readDatafromPropertyfile("url");
	System.out.println(data1);
	
	String data2 = pf.readDatafromPropertyfile("browser");
	System.out.println(data2);
	
}
}
