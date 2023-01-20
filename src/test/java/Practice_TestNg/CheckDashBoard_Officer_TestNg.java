package Practice_TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Officer_Class;
import com.hrm.objectPage.CheckDashBoard_Officer_Pom;
import com.hrm.objectPage.HomePage;

import HrOfficer_Module.AddEmpHrOfficerPom;


@Listeners(com.hrm.genriUtility.ListenerImp_Officer_Class.class)
public class CheckDashBoard_Officer_TestNg extends Base_Officer_Class{
	
	@Test(priority=-1)
	public void checkdashboard_officer() {
		CheckDashBoard_Officer_Pom chop=new CheckDashBoard_Officer_Pom(driver);
		chop.checkDashBoard_emp_officer();
		Assert.fail();
	}
	
	@Test(priority=0)
	public void checkdashboard_Bf_create_officer() {
		CheckDashBoard_Officer_Pom chop=new CheckDashBoard_Officer_Pom(driver);
		chop.checkDashBoard_emp_Bf_officer();
	}
	@Test(priority=1)
	public void create_Emp_Officer() throws Throwable {
		HomePage hp=new HomePage(driver);
    	hp.clickOfficerEmployee();
    	
    	AddEmpHrOfficerPom aeho= new AddEmpHrOfficerPom(driver);
    	aeho.AddHrOfficerEmployee(eLib, driver, wLib, fLib);
	}
	
	
	@Test(priority=2)
	public void checkdashboard_Af_create_officer() {
		CheckDashBoard_Officer_Pom chop=new CheckDashBoard_Officer_Pom(driver);
		chop.checkDashBoard_emp_Af_officer();
	}
}
