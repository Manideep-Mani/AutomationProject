package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertieFetch {
public static void main(String[] args) throws Throwable {
	FileInputStream fi=new FileInputStream("E:\\Selenium 16-06-2023\\AdvanceSeleniumQCO-SOEAJD-A1\\src\\test\\resources\\commondata.properties");
	Properties p= new Properties();
	p.load(fi);
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("URL"));
	driver.findElement(By.name("user_name")).sendKeys(p.getProperty("UN"),Keys.TAB,p.getProperty("PWD"),Keys.ENTER);
	
}
}
