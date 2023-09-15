package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerTC2 {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	driver.findElement(By.name("firstname")).sendKeys("Vinay2",Keys.TAB,Keys.TAB,"KK");
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String main = driver.getWindowHandle();
	Set<String> allID = driver.getWindowHandles();
	for(String id:allID)
	{
		if(!id.equals(main))
		{
			driver.switchTo().window(id);
		}
	}
	driver.findElement(By.name("search_text")).sendKeys("Qspiders");
	driver.findElement(By.xpath("//input[@type='button']")).click();
	driver.findElement(By.xpath("//a[text()='Qspiders']")).click();
	driver.switchTo().window(main);
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	 String validate = driver.findElement(By.className("dvHeaderText")).getText();
	if(validate.contains("Vinay"))
	{
	System.out.println("PASS");
	System.out.println(validate);
	}
	else
	{
		System.out.println("FAIL");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
