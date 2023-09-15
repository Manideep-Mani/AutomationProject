package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
@Test
public void create()
{
	Assert.fail();
     System.out.println("Create");	
}
@Test(dependsOnMethods ="create" )
public void modify()
{
     System.out.println("Modify");	
}
@Test(dependsOnMethods ={"create","modify"})
public void delete()
{
     System.out.println("Delete");	
}
}
