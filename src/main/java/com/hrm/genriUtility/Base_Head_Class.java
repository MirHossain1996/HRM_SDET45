package com.hrm.genriUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.hrm.objectPage.LoginPage;
import com.hrm.objectPage.LogoutPage;

public class Base_Head_Class {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public  ExcelUtility eLib=new ExcelUtility();
	public  WebDriverUtility wLib=new WebDriverUtility();
	public   JavaUtility jLib=new JavaUtility();
	public   FileUtility fLib=new FileUtility();
	
	@BeforeSuite
	public void configDB() {
		System.out.println("---Conect the Database----");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() {
		String BROWSER=iPathContent.Browser;
		String URL=iPathContent.url;
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else
			System.out.println("Invalid Srowser");
		sdriver=driver;
		wLib.maximamWindow(driver);
		wLib.implictWait(driver);
		driver.get(URL);
		System.out.println("....launching the browser...");
		
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() {
//		String USERNAME_head=iPathContent.HrHeadEmail;
//		String PASSWORD_Head=iPathContent.HrHeadPwd;
//		String USERNAME_officer=iPathContent.HrOfficerEmail;
//		String PASSWORD_officer=iPathContent.HrOfficerPwd;
//		String USERNAME_assistant=iPathContent.HrAssistantEmail;
//		String PASSWORD_assistant=iPathContent.HrAssistantPwd;
		
		LoginPage lip=new LoginPage(driver);
		lip.HrHeadLogin(wLib, driver);
//		lip.HrAsisstantLogin(wLib, driver);
//		lip.HrOfficerLogin(wLib, driver);
		System.out.println("---login as a Hr_Head ----------------");
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() {
		LogoutPage lop =new LogoutPage(driver);
		lop.hrHeadLogout();
//		lop.hrOfficer_Assistant_Logout();
		System.out.println("---logout as a Hr_Head ---------------");
		wLib.acceptAlert(driver);
	}
	
	@AfterClass(groups= {"smoke","regression"})
	public void  configAC() {
		driver.quit();
		System.out.println("---close the browser----");
	}
	@AfterSuite
	public void disconnectDB() {
		System.out.println("........disconnect from db.......");
	}
}
