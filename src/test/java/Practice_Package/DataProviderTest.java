package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider="data")
	public void travel(String source,String destination,int fare) {
		System.out.println("from....."+source+".......to :"+destination+" ==="+fare);
	}
	
	@DataProvider
	public Object[][] data() {

		Object[][] objarr = new Object[2][3];
		objarr[0][0]="Kolkata";
		objarr[0][1]="Bengaluru";
		objarr[0][2]=5000;

		objarr[1][0]="patna";
		objarr[1][1]="Mangaluru";
		objarr[1][2]=39000;
		return objarr;
	}
}