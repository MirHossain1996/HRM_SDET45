package Practice_Package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoOfAnnotation {
	@BeforeClass
	public void configBc() {
		System.out.println("...launching the browser....");
	}
	
	@BeforeMethod
	public void configBf() {
		System.out.println("....login the Application as hr haed.");
	}
	@Test(priority=1)
	public void ConfigTCrp() {
		System.out.println("...Add the corporate name as a hr head...");
	}
	@AfterMethod
	public void configAmHead() {
		System.out.println("...logout from hr head page... ");
	}
	
	@Test
	public void configEmp() {
		System.out.println("....add employee as hr assistant...");
	}
	
	@AfterClass
	public void configCls() {
		System.out.println("close the browser....");
	}
	
}
