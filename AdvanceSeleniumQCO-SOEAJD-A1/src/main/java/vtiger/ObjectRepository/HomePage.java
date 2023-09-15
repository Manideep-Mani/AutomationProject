package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
@FindBy(xpath = "//a[text()='Organizations']")
private WebElement organizationLnk;
@FindBy(xpath = "//a[text()='Contacts']")
private WebElement cntactsLnk;
@FindBy(xpath = "//a[text()='Products']")
private WebElement productsLnk;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminstratorLnk;
@FindBy(xpath = "//a[text()='Sign Out']")
private WebElement signoutLnk;

public HomePage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getCntactsLnk() {
	return cntactsLnk;
}

public WebElement getProductsLnk() {
	return productsLnk;
}

public WebElement getAdminstratorLnk() {
	return adminstratorLnk;
}

public WebElement getSignoutLnk() {
	return signoutLnk;
}
//Business Library
public void logoutofApp(WebDriver driver)
{
	mouseHoverAction(driver, adminstratorLnk);
	signoutLnk.click();
}
public void clickonOrgnizationLink()
{
	organizationLnk.click();
}
public void clickonContactsLink()
{
	cntactsLnk.click();
}
public void clickonProductsLink()
{
	productsLnk.click();
}
}
