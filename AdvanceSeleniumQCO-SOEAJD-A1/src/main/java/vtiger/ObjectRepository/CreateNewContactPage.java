package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
@FindBy(name = "lastname")
private WebElement lastNameEdt;
@FindBy(name = "button")
private WebElement saveBut;
@FindBy(xpath = "//input[@value='Cancel  ']")
private WebElement cancelBut;
@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
private WebElement OrgNameLookup;
@FindBy(id="search_txt")
private WebElement OrgNameText;
@FindBy(name="search")
private WebElement OrgNameSearch;

public CreateNewContactPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getSaveBut() {
	return saveBut;
}

public WebElement getCancelBut() {
	return cancelBut;
}

public WebElement getOrgNameLookup() {
	return OrgNameLookup;
}

public WebElement getOrgNameText() {
	return OrgNameText;
}

public WebElement getOrgNameSearch() {
	return OrgNameSearch;
}

public void createNewContact(String LASTNAME)
{
	lastNameEdt.sendKeys(LASTNAME);
	saveBut.click();		
}
public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver)
{
	lastNameEdt.sendKeys(LASTNAME);
	OrgNameLookup.click();
	switchToWindow(driver, "Accounts");
	OrgNameText.sendKeys(ORGNAME);
	OrgNameSearch.click();
	driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //dynamic xpath
	//a[text()='ch399'] - regular xpath for reference
	//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
	//driver.findElement(By.linkText(ORGNAME));
	
	switchToWindow(driver, "Contacts");
	saveBut.click();
	
}







}
