package vtiger.GenericUtilities;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consists of reusable methods related WebDriver
 * @author Manideep
 *
 */
public class WebDriverUtility {
	/**
	 * This method is used to maximize the window
	 */
public void maximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
}
/**
 * This method is used to minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
}
/**
 * This method is used to fullScreen the window
 * @param driver
 */
public void fullScreenWindow(WebDriver driver) {
	driver.manage().window().fullscreen();
}
/**
 * This method will wait for 10sec for all WebElements to lad
 * @param driver
 */
public void waitForPageload(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait for 10sec for particular element to visible
 * @param driver
 * @param element
 */
public void waitForVisiblity(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method will wait for 10sec for particular element to click
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method is used to handle the DropDown by index
 * @param element
 * @param index
 */
public void dropdownHandle(WebElement element,int index) {
	Select s = new Select(element);
	s.selectByIndex(index);
}
/**
 * This method is used to handle the DropDown by Value
 * @param element
 * @param value
 */
public void dropdownHandle(WebElement element,String value) {
	Select s = new Select(element);
	s.selectByValue(value);
}
/**
 * This method is used to handle the DropDown by VisibleText
 * @param element
 * @param text
 */
public void dropdownHandle(String text,WebElement element) {
	Select s = new Select(element);
	s.selectByVisibleText(text);
}
/**
 * This method is used to handle the mouse and moving to particular element
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method is used to handle the mouse and RightClick the particular element
 * @param driver
 * @param element
 */
public void rightclickAction(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method is used to handle the mouse and DoubleClick the particular element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This method will perform double click anywhere on the web page
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}
/**
 * This method is used to handle the mouse and Drag and Drop
 * @param driver
 * @param element1
 * @param element2
 */
public void dragandDropAction(WebDriver driver,WebElement source,WebElement target) {
	Actions act=new Actions(driver);
	act.dragAndDrop(source,target).perform();
}
/**
 * This method is used to move the cursor and click in web page
 * @param driver
 * @param x
 * @param y
 */
public void movetheCursorandClick(WebDriver driver,int x,int y) {
	Actions act=new Actions(driver);
	act.moveByOffset(x, y).perform();
}
/**
 * This method is used to handle frame by index
 * @param driver
 * @param index
 */
public void frameHandling(WebDriver driver,int index) {
	driver.switchTo().frame(index);
}
/**
 * This method is used to handle frame by WebElement
 * @param driver
 * @param element
 */
public void frameHandling(WebDriver driver,String element) {
	driver.switchTo().frame(element);
}
/**
 * This method is used to handle frame by String
 * @param text
 * @param driver
 */
public void frameHandling(String text,WebDriver driver) {
	driver.switchTo().frame(text);
}
/**
 * This method will switch to default page
 * @param driver
 */
public void frameHandling(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * This method will switch to immediate parent frame
 * @param driver
 */
public void switchtoParentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}
/**
 * This method is used to handle the AlertPopup Accept
 * @param driver
 */
public void alertPopupAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This method is used to handle the AlertPopup Dismiss
 * @param driver
 */
public void alertPopupDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * This method is used to handle the AlertPopup GetText
 * @param driver
 */
public String alertPopupGettext(WebDriver driver) {
	return driver.switchTo().alert().getText();
}
/**
 * This method is used to handle the AlertPopup SendKeys
 * @param driver
 * @param value
 */
public void alertPopupSendkeys(WebDriver driver,String value) {
	driver.switchTo().alert().sendKeys(value);
}
/**
 * This method is used to scroll in web page
 * @param driver
 */
public void scrollHandling(WebDriver driver) {
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeAsyncScript("window.ScrollBy(0,500);"," ");
}
/**
 * This method is used to scroll in web page to particular element
 * @param driver
 * @param element
 */
public void scrollHandling(WebDriver driver,WebElement element) {
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeAsyncScript("argument[0].scrollIntoView();",element);
}
/**
 * This method will help to switch the control from one window to another
 * @param driver
 * @param partialWindowTitle
 */
public void switchToWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> allWinId = driver.getWindowHandles();
	for(String id:allWinId)
	{
		String actTitle = driver.switchTo().window(id).getTitle();
		if(actTitle.contains(partialWindowTitle))
		{
			break;
		}
	}
}
/**
 * This method will take screenshot and store in particular folder
 * @param driver
 * @param screenshotName
 * @return
 * @throws Throwable
 */
public String captureScreenShot(WebDriver driver,String screenshotName) throws Throwable {
	TakesScreenshot sh=(TakesScreenshot) driver;
	File src=sh.getScreenshotAs(OutputType.FILE);
	File dst = new File("E:\\Selenium 16-06-2023\\AdvanceSeleniumQCO-SOEAJD-A1\\ScreenShots\\"+screenshotName+".png");
	Files.copy(src, dst);
	return dst.getAbsolutePath();
}







}










































