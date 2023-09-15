package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class contains of Generic Methods Related to Property file
 * @author Manideep
 *
 */
public class PropertyfileUtility {
	/**
	 * This Method will read data from Property file and return the value
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
public String readDatafromPropertyfile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream("E:\\Selenium 16-06-2023\\AdvanceSeleniumQCO-SOEAJD-A1\\src\\test\\resources\\commondata.properties");
    Properties p=new Properties();
    p.load(fis);
    String value = p.getProperty(key);
    return value;
    

}
}
