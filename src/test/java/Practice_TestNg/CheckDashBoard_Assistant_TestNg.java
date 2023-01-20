package Practice_TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Assistant_Class;
import com.hrm.genriUtility.Base_Officer_Class;
import com.hrm.objectPage.AddEmpHrAssistant;
import com.hrm.objectPage.CheakDashBoard_Assistant_Pom;


@Listeners(com.hrm.genriUtility.ListenerImp_Assistant_Class.class)
public class CheckDashBoard_Assistant_TestNg extends Base_Assistant_Class{
	
	@Test(priority=-1)
	public void checkDashboard_Assistant() {
		CheakDashBoard_Assistant_Pom cda=new CheakDashBoard_Assistant_Pom(driver);
		cda.checkDashBoard_emp_Assistant();
		Assert.fail();
	}
	
	@Test(priority=0)
	public void checkDashBoard_Bf_Create_emp_Assistant() {
		CheakDashBoard_Assistant_Pom cda=new CheakDashBoard_Assistant_Pom(driver);
		cda.checkDashBoard_emp_Bf_Assistant();
	}
	
	@Test(priority=1)
	public void create_emp_Assistant() throws Throwable {
		AddEmpHrAssistant aea=new AddEmpHrAssistant(driver);
		aea.AddHrAssistantEmployee(eLib, driver, wLib, fLib);
	}
	
	@Test(priority=2)
	public void checkDashBoard_Af_Create_emp_Assistant() {
		CheakDashBoard_Assistant_Pom cda=new CheakDashBoard_Assistant_Pom(driver);
		cda.checkDashBoard_emp_Af_Assistant();
	}
}