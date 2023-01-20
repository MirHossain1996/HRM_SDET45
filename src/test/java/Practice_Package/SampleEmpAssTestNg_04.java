package Practice_Package;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Assistant_Class;

import com.hrm.objectPage.AddEmpHrAssistant;
import com.hrm.objectPage.HomePage;

import HrAssistant_Module.DeleteHrAssistantPom;

public class SampleEmpAssTestNg_04 extends Base_Assistant_Class {

	@Test(groups= {"smoke","regression"})
	public void createEmpAssistant() throws Throwable {
		HomePage hp=new HomePage(driver);
    	hp.clickAssistantEmployee();
    	AddEmpHrAssistant aeh=new AddEmpHrAssistant(driver);
		aeh.AddHrAssistantEmployee(eLib, driver, wLib, fLib);;
		
	}
} 