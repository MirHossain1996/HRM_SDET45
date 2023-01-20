package Practice_TestNg;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.HomePage;

import HrHead_Module.AddAdminHrHeadPom;

public class CreateAdminHeadTestng extends Base_Head_Class{
	@Test
	public void createAdmin() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickAdmin();
		AddAdminHrHeadPom aahhp=new AddAdminHrHeadPom(driver);
		aahhp.addAdminHrHead(eLib, driver, wLib, fLib);
		//wLib.acceptAlert(driver);
	}

}
