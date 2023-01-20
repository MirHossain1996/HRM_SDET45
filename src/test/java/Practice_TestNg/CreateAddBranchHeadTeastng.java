package Practice_TestNg;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Head_Class;
import com.hrm.objectPage.AddBranchHrHead;
import com.hrm.objectPage.HomePage;

public class CreateAddBranchHeadTeastng extends Base_Head_Class {

	@Test 
	public void createBranch() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.clickBranch();
		AddBranchHrHead abhh=new AddBranchHrHead(driver);
		abhh.AddBranch(wLib, eLib, driver);
	}
}
 