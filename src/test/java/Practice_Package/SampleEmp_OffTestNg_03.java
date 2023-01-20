package Practice_Package;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.genriUtility.Base_Officer_Class;
import com.hrm.objectPage.HomePage;

import HrOfficer_Module.AddEmpHrOfficerPom;

public class SampleEmp_OffTestNg_03 extends Base_Officer_Class {

	@Test(groups= {"smoke","regression"})
	public void createEmpOfficer() throws Throwable {
		HomePage hp=new HomePage(driver);
    	hp.clickOfficerEmployee();
    	
    	AddEmpHrOfficerPom aeho= new AddEmpHrOfficerPom(driver);
    	aeho.AddHrOfficerEmployee(eLib, driver, wLib, fLib);
	}
}
