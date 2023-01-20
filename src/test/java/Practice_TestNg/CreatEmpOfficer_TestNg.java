package Practice_TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.genriUtility.Base_Officer_Class;
import com.hrm.objectPage.HomePage;

import HrOfficer_Module.AddEmpHrOfficerPom;
@Listeners(com.hrm.genriUtility.ListenerImp_Officer_Class.class)
public class CreatEmpOfficer_TestNg extends Base_Officer_Class {

	@Test
	public void createEmpOfficer() throws Throwable {
		HomePage hp=new HomePage(driver);
    	hp.clickOfficerEmployee();
    	//Assert.fail();
    	AddEmpHrOfficerPom aeho= new AddEmpHrOfficerPom(driver);
    	aeho.AddHrOfficerEmployee(eLib, driver, wLib, fLib);
	}
}
