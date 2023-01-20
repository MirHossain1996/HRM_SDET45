package com.hrm.objectPage;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class HrAssistantMainPage {

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
        	LoginPage lp=new LoginPage(driver);
        	lp.HrAsisstantLogin(wLib, driver);
        	
        	
        	
        	AddEmpHrAssistant aAp=new AddEmpHrAssistant(driver);
        	aAp.AddHrAssistantEmployee(rLib, driver, wLib,fileUt);
        	
        	LogoutPage lo=new LogoutPage(driver);
        	lo.hrOfficer_Assistant_Logout();
        	
        	wLib.acceptAlert(driver);
        }
        {
        //editemployee hr assistant........................
        	LoginPage lp=new LoginPage(driver);
        	lp.HrAsisstantLogin(wLib, driver);
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickAssistantEmployee();
        	
        	EditEmpHrAssistant eea=new EditEmpHrAssistant(driver);
        	eea.editEmployeeHrAssit(wLib,fileUt, driver, rLib.getDataFromExcel("EmployeeDetails", 1, 1),rLib.getDataFromExcel("EmployeeDetails", 1, 1),rLib);
        	
        	String data = wLib.getTextAlert(driver);
        	System.out.println("delete employeee by Hr Assistant  ::"+data);
        	wLib.acceptAlert(driver);
   
        	
        	LogoutPage lo=new LogoutPage(driver);
        	lo.hrOfficer_Assistant_Logout();
        	
        	wLib.acceptAlert(driver);
        }
        
        {
        	//Login as Hr Assistant Then Delete employee.................
        	
        	LoginPage lp=new LoginPage(driver);
        	lp.HrAsisstantLogin(wLib, driver);
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickAssistantEmployee();
        	
        	DeleteEmpHrAssistant dea=new DeleteEmpHrAssistant(driver);
        	dea.deleteEmpHrAssit(rLib.getDataFromExcel("EmployeeDetails", 1, 1));
        	String data = wLib.getTextAlert(driver);
        	System.out.println("delete employeee by Hr Assistant  ::"+data);
        	wLib.acceptAlert(driver);
   
        	LogoutPage lo=new LogoutPage(driver);
        	lo.hrOfficer_Assistant_Logout();
        	
        	wLib.acceptAlert(driver);
        }
	}

}
