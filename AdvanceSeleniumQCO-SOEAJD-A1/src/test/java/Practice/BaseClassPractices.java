package Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassPractices {
    @BeforeSuite
      public void bs()
    {
        System.out.println("BEFORE SUIT");	
    }
    @BeforeTest
     public void bt()
    {
        System.out.println("BEFORE TEST");	
    }
	@BeforeClass
	 public void bc()
	{
		System.out.println("BEFORE CLASS");
	}
	@BeforeMethod
	public void bm()
	{
		System.out.println("BEFORE METHOD");
	}
	@Test
	public void t()
	{
		System.out.println("TEST");
	}
	@AfterMethod
	public void af()
	{
		System.out.println("AFTER METHOD");
	}
	@AfterClass
	public void ac()
	{
		System.out.println("AFTER CLASS");
	}
	@AfterTest
	public void at()
	{
		System.out.println("AFTER TEST");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("AFTER SUIT");
	}
}
