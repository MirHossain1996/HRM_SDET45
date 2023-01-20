package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.HomePage;

import HrHead_Module.AddCorporteHrHeadPom;

public class SampleCorpTestNg_06 extends Base_Head_Class {
	@Test(groups="smoke")
	public void createCorporate() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.ClickCorporate();
		AddCorporteHrHeadPom achh=new AddCorporteHrHeadPom(driver);
		achh.AddCorporate(wLib, driver, eLib);
	}
}
