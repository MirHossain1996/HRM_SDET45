package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.AddBranchHrHead;
import com.hrm.objectPage.AddEmpHrHead;
import com.hrm.objectPage.HomePage;

public class SampleBranchTestNg_01 extends Base_Head_Class {

	@Test(groups="regression")
	public void createBranch() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickBranch();
		AddBranchHrHead abhh=new AddBranchHrHead(driver);
		abhh.AddBranch(wLib, eLib, driver);
	}
	
}