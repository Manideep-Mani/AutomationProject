package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
@FindBy(name = "accountname")
private WebElement organizationName;
@FindBy(name = "industry")
private WebElement selectIndustry;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;
@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
private WebElement cancelButton;

public CreateNewOrganizationPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public WebElement getOrganizationName() {
	return organizationName;
}

public WebElement getSelectIndustry() {
	return selectIndustry;
}

public WebElement getSaveButton() {
	return saveButton;
}

public WebElement getCancelButton() {
	return cancelButton;
}

public void createNewOrganization(String ORGNAME)
{
	organizationName.sendKeys(ORGNAME);
	saveButton.click();
}

public void createNewOrganization(String ORGNAME, String INDUSTRY)
{
	organizationName.sendKeys(ORGNAME);
	dropdownHandle(selectIndustry, INDUSTRY);
	saveButton.click();
}

}
