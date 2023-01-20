package Practice_TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.AddBranchHrHead;
import com.hrm.objectPage.AddEmpHrHead;
import com.hrm.objectPage.CheckDashBoardHeadPom;
import com.hrm.objectPage.HomePage;

import HrHead_Module.AddAdminHrHeadPom;
import HrHead_Module.AddCorporteHrHeadPom;


@Listeners(com.hrm.genriUtility.ListenerImp_Head_Class.class)
public class CheckDasboard_Head_TestNg extends Base_Head_Class{
	
	@Test(priority=-1)
	public void check_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashBoardHead();
		Assert.fail();
		//Assert.assertEquals(false, true);
	}
	
	@Test(priority=0)
	public void check_Head_crp_Bf_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_crp_Bf_create();
		Assert.fail();
	}
	@Test(priority=1)
	public void createCorporate() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.ClickCorporate();
		AddCorporteHrHeadPom achh=new AddCorporteHrHeadPom(driver);
		achh.AddCorporate(wLib, driver, eLib);
	}
	@Test(priority=2)
	public void check_Head_crp_Af_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_crp_Af_create();
	}
	
	@Test(priority=3)
	public void check_Head_branch_Bf_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Branch_Af_create();
	}
	@Test(priority=4)
	public void createBranch() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickBranch();
		AddBranchHrHead abhh=new AddBranchHrHead(driver);
		abhh.AddBranch(wLib, eLib, driver);
	}
	@Test(priority=5)
	public void check_Head_Branch_Af_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Branch_Af_create();
	}
	
	@Test(priority=6)
	public void check_Head_Admin_Bf_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Admin_Bf_create();
	}
	@Test(priority=7)
	public void createAdmin() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickAdmin();
		AddAdminHrHeadPom aahhp=new AddAdminHrHeadPom(driver);
		aahhp.addAdminHrHead(eLib, driver, wLib, fLib);
	}
	@Test(priority=8)
	public void check_Head_Admin_Af_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Admin_Af_create();
	}
	
	@Test(priority=9)
	public void check_Head_Emp_Bf_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Emp_Bf_create();
	}
	@Test(priority=10)
	public void createEmp_Head() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickHeadEmployee();
		AddEmpHrHead aehh=new AddEmpHrHead(driver);
		aehh.clickAddEmpHead();
		aehh.AddHrHeadEmployee( eLib, jLib, driver, wLib, fLib, "EmployeeDetails");
	}
	@Test(priority=11)
	public void check_Head_Emp_Af_dashboard() {
		CheckDashBoardHeadPom cdh=new CheckDashBoardHeadPom(driver);
		cdh.checkDashborad_Emp_Af_create();
	}
}
