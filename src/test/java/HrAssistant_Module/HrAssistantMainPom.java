package HrAssistant_Module;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;
import com.hrm.objectPage.AddEmpHrAssistant;
import com.hrm.objectPage.HomePage;
import com.hrm.objectPage.LoginPage;
import com.hrm.objectPage.LogoutPage;

public class HrAssistantMainPom {

	public static void main(String[] args) throws Throwable {

		WebDriver driver=new ChromeDriver();
        ExcelUtility rLib=new ExcelUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        JavaUtility jLib=new JavaUtility();
        FileUtility fileUt=new FileUtility();
        HashMap<String, String> fields=new HashMap<String, String>();
        wLib.implictWait(driver);
        wLib.maximamWindow(driver);
        driver.get("http://rmgtestingserver/domain/HRM_System/");
        {
        	//AddEmployee as a Hr Assistant Then logout................
//        	LoginPage lp=new LoginPage(driver);
//        	lp.HrAsisstantLogin(wLib, driver);
//        	
//        	HomePage hp=new HomePage(driver);
//        	hp.clickAssistantEmployee();
//        	
//        	AddEmpHrAssistant aAp=new AddEmpHrAssistant(driver);
//        	aAp.AddHrAssistantEmployee(rLib, driver, wLib,fileUt);
//        	
//        	LogoutPage lo=new LogoutPage(driver);
//        	lo.hrOfficer_Assistant_Logout();
//        	
//        	wLib.acceptAlert(driver);
        }
        {
        //editemployee hr assistant........................
        	LoginPage lp=new LoginPage(driver);
        	lp.HrAsisstantLogin(wLib, driver);
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickAssistantEmployee();
        	
        	EditEmpHrAssistantPom eea=new EditEmpHrAssistantPom(driver);
        	eea.editEmployeeHrAssit(fileUt, driver, rLib.getDataFromExcel("EmployeeDetails", 2, 2));
        	
        	String data = wLib.getTextAlert(driver);
        	System.out.println("delete employeee by Hr Assistant  ::"+data);
        	wLib.acceptAlert(driver);
   
        	
        	LogoutPage lo=new LogoutPage(driver);
        	lo.hrOfficer_Assistant_Logout();
        	
        	wLib.acceptAlert(driver);
        }
        
        {
        	//Login as Hr Assistant Then Delete employee.................
        	
//        	LoginPage lp=new LoginPage(driver);
//        	lp.HrAsisstantLogin(wLib, driver);
//        	
//        	HomePage hp=new HomePage(driver);
//        	hp.clickAssistantEmployee();
//        	
//        	DeleteHrAssistantPom dea=new DeleteHrAssistantPom(driver);
//        	dea.deleteEmpHrAssit(rLib.getDataFromExcel("EmployeeDetails", 1, 1));
//        	String data = wLib.getTextAlert(driver);
//        	System.out.println("delete employeee by Hr Assistant  ::"+data);
//        	wLib.acceptAlert(driver);
//   
//        	LogoutPage lo=new LogoutPage(driver);
//        	lo.hrOfficer_Assistant_Logout();
//        	
//        	wLib.acceptAlert(driver);
        }
	}

}
