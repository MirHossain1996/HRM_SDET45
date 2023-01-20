package Practice_TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Assistant_Class;
import com.hrm.objectPage.HomePage;

import HrAssistant_Module.DeleteHrAssistantPom;
@Listeners(com.hrm.genriUtility.ListenerImp_Assistant_Class.class)
public class Delete_Emp_AssistantTestNg extends Base_Assistant_Class {
	
	@Test(retryAnalyzer = com.hrm.genriUtility.RetryImp_Class.class)
	public void deleteEmpAssistant() throws Throwable {
		HomePage hp=new HomePage(driver);
    	hp.clickAssistantEmployee();
    	Assert.fail();
		DeleteHrAssistantPom dha=new DeleteHrAssistantPom(driver);
		dha.deleteEmpHrAssit(eLib.getDataFromExcel("EmployeeDetails", 1, 1));
		String data = wLib.getTextAlert(driver);
    	System.out.println("delete   this employeee by Hr Assistant  ::"+data);
    	wLib.acceptAlert(driver);
	}
}
