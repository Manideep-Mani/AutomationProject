package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement createOrganizationLookup;
@FindBy(name = "search_text")
private WebElement searchTextbox;
@FindBy(id = "bas_searchfield")
private WebElement organizationNo;
@FindBy(name = "submit")
private WebElement searchButton;

public OrganizationsPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public WebElement getCreateOrganizationLookup() {
	return createOrganizationLookup;
}

public WebElement getSearchTextbox() {
	return searchTextbox;
}

public WebElement getOrganizationNo() {
	return organizationNo;
}

public WebElement getSearchButton() {
	return searchButton;
}
	
	public void clickOnCreateOrgLookupImage()
	{
		createOrganizationLookup.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
