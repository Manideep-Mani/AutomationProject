package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.internal.reflect.Parameter;

import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
       public ExcelFileUtility eUtil = new ExcelFileUtility();
       public JavaUtility jUtil = new JavaUtility();
       public PropertyfileUtility pUtil = new PropertyfileUtility();
       public WebDriverUtility wUtil = new WebDriverUtility();
       public WebDriver driver=null;
       public static WebDriver sdriver;

   @BeforeSuite(alwaysRun = true)
   public void bsConfig()
   {
	   System.out.println("==========Database Connection Successful==========");
   }
   //@Parameters("browser")
   @BeforeClass(alwaysRun = true)
   public void bcConfig() throws Throwable
   {
	  String BROWSER = pUtil.readDatafromPropertyfile("browser");
	   String URL = pUtil.readDatafromPropertyfile("url");
	   
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
	   wUtil.maximizeWindow(driver);
	    wUtil.waitForPageload(driver);    
	    driver.get(URL);
	    sdriver=driver;
	   System.out.println("==========Browser Launched==========");
   }
   @BeforeMethod(alwaysRun = true)
   public void bmConfig() throws Throwable
   {
	  String USERNAME = pUtil.readDatafromPropertyfile("un");
	  String PASSWORD = pUtil.readDatafromPropertyfile("pwd");
	  LoginPage ln=new LoginPage(driver);
	    
	    ln.loginToApp(USERNAME, PASSWORD);
	    
	    System.out.println("==========Login Successful==========");
   }
   @AfterMethod(alwaysRun = true)
   public void amConfig()
   {
	   HomePage hp=new HomePage(driver);
	   //hp.getAdminstratorLnk();
	   //hp.getSignoutLnk().click();
	  hp.logoutofApp(driver);
	   System.out.println("==========Logout Successful==========");
   }
   
   @AfterClass(alwaysRun = true)
   public void acConfig()
   {
	   driver.quit();
	   System.out.println("==========Browser Closed==========");
   }
   
   @AfterSuite(alwaysRun = true)
   public void asConfig()
   {
	   System.out.println("==========Database Connection Closed==========");
   }
   
}
