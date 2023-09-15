package vtiger.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithIndustry {
	ExcelFileUtility eutil=new ExcelFileUtility();
	WebDriver driver=null;
	JavaUtility ju= new JavaUtility();
	PropertyfileUtility pu=new PropertyfileUtility();
	WebDriverUtility wu=new WebDriverUtility();
@Test(alwaysRun = true) //(dataProvider = "getData")
public void createMultipleOrg(String Org,String Industry) throws Throwable
{
	
	String BROWSER = pu.readDatafromPropertyfile("browser");
	String URL = pu.readDatafromPropertyfile("url");
	String USERNAME = pu.readDatafromPropertyfile("un");
	String PASSWORD = pu.readDatafromPropertyfile("pwd");
	String ORGNAME=Org+ju.getRandomNumber();
	String INDUSTRYTYPE=Industry;
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
    wu.maximizeWindow(driver);
    wu.waitForPageload(driver);    
    driver.get(URL);
    
    LoginPage ln=new LoginPage(driver);
    
    ln.loginToApp(USERNAME, PASSWORD);
    
    
    
    
  
	HomePage hp=new HomePage(driver);
	hp.clickonOrgnizationLink();
	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookupImage();
	
	CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
	cnp.createNewOrganization(ORGNAME, INDUSTRYTYPE);
	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	String Header=oip.getHeaderVerification().getText();
	
	if(Header.contains(ORGNAME))
	{
		System.out.println("Pass");
		System.out.println(Header);
	}
	else
	{
		System.out.println("Fail");
	}
	Thread.sleep(2000);
	hp.logoutofApp(driver);
	
	//driver.quit();
}
@DataProvider
public Object[][] getData() throws Throwable
{
	Object[][] data=eutil.readMultipleDataFromExcel("Sheet3");
	return data;
}

}
