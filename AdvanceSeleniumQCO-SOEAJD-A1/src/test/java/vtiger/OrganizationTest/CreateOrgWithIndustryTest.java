package vtiger.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;
@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrgWithIndustryTest extends BaseClass {
	@Test(alwaysRun = true) //(groups = "Regration")
	public void createOrgWithIndustryTest() throws Throwable {
		//WebDriver driver=null;
		ExcelFileUtility eu=new ExcelFileUtility();
		JavaUtility ju= new JavaUtility();
		PropertyfileUtility pu=new PropertyfileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		String BROWSER = pu.readDatafromPropertyfile("browser");
		String URL = pu.readDatafromPropertyfile("url");
		String USERNAME = pu.readDatafromPropertyfile("un");
		String PASSWORD = pu.readDatafromPropertyfile("pwd");
		String ORGNAME= eu.readDatafromExcel("Sheet1",1, 2)+ju.getRandomNumber();
		String INDUSTRYTYPE =eu.readDatafromExcel("Sheet1",4,3);
		/*if(BROWSER.equalsIgnoreCase("Chrome"))
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
		} */
	  //  wu.maximizeWindow(driver);
	    //wu.waitForPageload(driver);    
	    //driver.get(URL);
	    
	   // LoginPage ln=new LoginPage(driver);
	    
	   // ln.loginToApp(USERNAME, PASSWORD);
	    //ln.getUserNameEdt().sendKeys(USERNAME);
	    //ln.getPasswordEdt().sendKeys(PASSWORD);
	    //ln.getLoginBtn().click();
	    
	    
	    
	    //driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
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
		//hp.logoutofApp(driver);
		//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		//driver.findElement(By.className("detailedViewTextBox")).sendKeys(ORGNAME);
		//driver.findElement(By.name("industry")).click();
		//driver.findElement(By.xpath("//option[@value='Chemicals']")).click();
		
		//WebElement mouseHoElement =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wu.mouseHoverAction(driver, mouseHoElement);
		//driver.findElement(By.linkText("Sign Out")).click();
		//System.out.println("Logout successfull");
		//driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
