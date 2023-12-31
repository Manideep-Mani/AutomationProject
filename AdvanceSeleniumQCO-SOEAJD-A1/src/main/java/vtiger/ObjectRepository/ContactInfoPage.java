package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement contactHeaderText;

public ContactInfoPage(WebDriver driver)
{
    PageFactory.initElements(driver,this);
}

public WebElement getContactHeaderText() {
	return contactHeaderText;
}

public String getContactHeader()
{
	return contactHeaderText.getText();	
}
}
