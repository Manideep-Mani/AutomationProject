package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
private WebElement editOrganization;
@FindBy(xpath = "//input[@title='Duplicate [Alt+U]']")
private WebElement duplicateOragnization;
@FindBy(xpath = "//input[@title='Delete [Alt+D]']")
private WebElement deleteOrganization;
@FindBy(xpath = "//a[text()='More Information']")
private WebElement moreInfo;
@FindBy(xpath = "//div[@class='small']/table/tbody/tr/td/span")
private WebElement headerVerification;

public OrganizationInfoPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}

public WebElement getEditOrganization() {
	return editOrganization;
}

public WebElement getDuplicateOragnization() {
	return duplicateOragnization;
}

public WebElement getDeleteOrganization() {
	return deleteOrganization;
}

public WebElement getMoreInfo() {
	return moreInfo;
}

public WebElement getHeaderVerification() {
	return headerVerification;
}

public String getOrgHeader()
{
return 	headerVerification.getText();
}
}
