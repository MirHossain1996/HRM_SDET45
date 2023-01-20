package Practice_TestNg;

import org.testng.annotations.Test;

import com.hrm.genriUtility.Base_Assistant_Class;
import com.hrm.objectPage.AddEmpHrAssistant;

public class CreateEmpAssistant_TestNg extends Base_Assistant_Class {

	@Test
	public void createEmp_Assistant() throws Throwable {
		AddEmpHrAssistant aea=new AddEmpHrAssistant(driver);
		aea.AddHrAssistantEmployee(eLib, driver, wLib, fLib);
	}
}
