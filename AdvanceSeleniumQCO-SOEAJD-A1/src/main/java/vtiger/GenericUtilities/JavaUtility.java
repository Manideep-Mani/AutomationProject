package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of reusable methods related to java
 * @author Manideep
 *
 */
public class JavaUtility {
	/**
	 * This method is used to generate random number for every execution
	 * @return
	 */
public int getRandomNumber() {
	Random r= new Random();
	return r.nextInt(1000);
	
}
/**
 * 
 */
public String getDate() {
	Date d = new Date();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
	String date = formatter.format(d);
	return date;
}
}
