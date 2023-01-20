package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.AddEmpHrHead;
import com.hrm.objectPage.HomePage;

public class SampleEmp_HeadTestNg_05 extends Base_Head_Class{
	@Test(groups="smoke")
	public void CreatEmpHead() throws Throwable, Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickHeadEmployee();
		AddEmpHrHead aehh=new AddEmpHrHead(driver);
		aehh.clickAddEmpHead();
		aehh.AddHrHeadEmployee( eLib, jLib, driver, wLib, fLib, "EmployeeDetails");
	}
}
