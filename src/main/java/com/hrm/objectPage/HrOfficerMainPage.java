package com.hrm.objectPage;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class HrOfficerMainPage {

	public static void main(String[] args) throws Throwable {

		   WebDriver driver=new ChromeDriver();
	        ExcelUtility rLib=new ExcelUtility();
	        WebDriverUtility wLib=new WebDriverUtility();
	        JavaUtility jLib=new JavaUtility();
	        FileUtility fileUt=new FileUtility();
	        HashMap<String, String> fields=new HashMap<String, String>();
	        wLib.implictWait(driver);
	        wLib.maximamWindow(driver);
        {
        	driver.get("http://rmgtestingserver/domain/HRM_System/");
        	LoginPage lp=new LoginPage(driver);
        	lp.HrOfficerLogin(wLib, driver);
        	
        	HomePage hp=new HomePage(driver);
        	hp.clickOfficerEmployee();
        	
        	AddEmpHrOfficer aOp=new AddEmpHrOfficer(driver);
        	aOp.AddHrOfficerEmployee(rLib, driver, wLib,fileUt);
        	
        	LogoutPage lo=new LogoutPage(driver);
        	lo.hrOfficer_Assistant_Logout();
        	
        	wLib.acceptAlert(driver);
	}

}}
