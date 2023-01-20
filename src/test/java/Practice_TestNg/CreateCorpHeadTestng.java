package Practice_TestNg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.HomePage;

import HrHead_Module.AddCorporteHrHeadPom;




public class CreateCorpHeadTestng extends Base_Head_Class{

	@Test
	public void createCorporate() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.ClickCorporate();
		AddCorporteHrHeadPom achh=new AddCorporteHrHeadPom(driver);
		achh.AddCorporate(wLib, driver, eLib);
	}
}
