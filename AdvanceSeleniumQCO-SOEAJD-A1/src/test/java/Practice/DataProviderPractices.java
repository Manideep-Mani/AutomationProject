package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractices {
	@Test(dataProvider = "getData")
	public void addProductToCart(String Product,String Model,int Price)
	{
		System.out.println(Product+" , "+Model+" , "+Price+".");
	}
	@Test(dataProvider = "getinfo")
	public void addProductTo(String Product,String Model)
	{
		System.out.println(Product+" , "+Model+".");
	}
@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[4][3];
	data[0][0]="Samsung";
	data[0][1]="S22";
	data[0][2]=75000;
	
	data[1][0]="Oppo";
	data[1][1]="Reno7";
	data[1][2]=35000;
	
	data[2][0]="Oneplus";
	data[2][1]="9RT";
	data[2][2]=48000;
	
	data[3][0]="Vivo";
	data[3][1]="Y21"; 
	data[3][2]=28000;
	
	return data;
}
@DataProvider
public Object[][] getinfo()
{
    Object[][] data=new Object[2][2];
    data[0][0]="Samsung";
    data[0][1]="A60";
    data[1][0]="Oppo";
    data[1][1]="A52";
    return data;
}
}