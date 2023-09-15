package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test
public void test()
{
System.out.println("Hi Started");	
Assert.assertEquals("Hi", "Hi");
System.out.println("Hello Im Here");
}
@Test
public void test2()
{
SoftAssert sf=new SoftAssert();
System.out.println("Step1");

System.out.println("Step2");
sf.assertTrue(false);
System.out.println("Step3");
sf.assertEquals(1, 2);
System.out.println("Step4");
Assert.assertEquals(true, false);
System.out.println("Step5");
sf.assertAll();


}







}
