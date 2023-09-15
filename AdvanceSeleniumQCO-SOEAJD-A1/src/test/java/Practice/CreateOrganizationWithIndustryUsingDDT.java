package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationWithIndustryUsingDDT {
public static void main(String[] args) throws IOException, Throwable {
	WebDriver driver=null;
	Random r=new Random();
	int random = r.nextInt();
	
	FileInputStream fisp=new FileInputStream("E:\\Selenium 16-06-2023\\AdvanceSeleniumQCO-SOEAJD-A1\\src\\test\\resources\\commondata.properties");
	Properties p=new Properties();
	p.load(fisp);
	String BROWSER = p.getProperty("browser");
	String URL = p.getProperty("url");
	String UN = p.getProperty("un");
	String PWD = p.getProperty("pwd");
	
	FileInputStream fise=new FileInputStream("E:\\Automation Project 27-07-23 QSP\\TestData.xlsx");
	Workbook book = WorkbookFactory.create(fise);
	Sheet sh = book.getSheet("Sheet1");
	String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
	String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
	if(BROWSER.equalsIgnoreCase("Chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("Edge"))
	{
		driver=new EdgeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("Selected Browser Not Exists");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(URL);


	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.className("detailedViewTextBox")).sendKeys(ORGNAME);
	driver.findElement(By.name("industry")).click();
	driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String content = driver.findElement(By.className("dvHeaderText")).getText();
	if(content.contains("Sony"))
	{
		System.out.println(content);
		System.out.println("PASS");
	}
	else
	{
		System.out.println("Fail");
	}
	WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(mouseHover).perform();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Logout successfull");
	
	
	
	driver.quit();
	WebElement mouseHoElement = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions actions = new Actions(driver);
	act.moveToElement(mouseHover).perform();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Logout successfull");
	
	
	
	driver.quit();
	
}
}
