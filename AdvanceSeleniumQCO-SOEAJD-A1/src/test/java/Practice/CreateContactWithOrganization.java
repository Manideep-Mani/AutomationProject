package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyfileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganization {
	public static void main(String[] args) throws Throwable {

		// Create Objects of all Utility Classes
		JavaUtility jUtil = new JavaUtility();
		PropertyfileUtility pUtil = new PropertyfileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		 WebDriver driver = null;

		// Step 1: Read All the Data required 
		
		/* read Data from Property file */
		String BROWSER = pUtil.readDatafromPropertyfile("browser");
		String URL = pUtil.readDatafromPropertyfile("url");
		String USERNAME = pUtil.readDatafromPropertyfile("un");
		String PASSWORD = pUtil.readDatafromPropertyfile("pwd");

		/* read Data from ExcelFile */
		String ORGNAME = eUtil.readDatafromExcel("Sheet2", 4, 2) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDatafromExcel("Sheet2", 4, 3);

		// Step 2: Launch the browser - //Run Time Polymorphism - driver
		if (BROWSER.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageload(driver);
		driver.get(URL);

		// Step 2: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 3: Navigate to Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickonOrgnizationLink();

		// Step 4: Click On create Organization Look Up Image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookupImage();
		
				
				
		// Step 5: Create Organization with mandatory Information
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		// Step 8: Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();

		if (orgHeader.contains(ORGNAME)) {
			System.out.println("Organization created");
			System.out.println(orgHeader);
		} else {
			System.out.println("FAIL");
		}
		hp.clickonContactsLink();
		ContactsPage cpp = new ContactsPage(driver);
		cpp.clickOnCreateContactlookup();
		
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME, ORGNAME, driver);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASSS");
			System.out.println(contactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 13: Logout of app
		hp.logoutofApp(driver);
		
		//Step 14: Close the browser
		driver.quit();
		
	}

}
