package Practice_Package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.genriUtility.ExcelUtility;

public class DataFetchExcelDataProvider {

	@Test(dataProvider="dataFromExcel")
	public void travel(String from ,String to)
	{
		System.out.println(from+"--------->"+to);
	}
	
	@DataProvider
	public Object[][] dataFromExcel() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.getReadMultipleData("dataProvider");
		return value;
	}
	
}
