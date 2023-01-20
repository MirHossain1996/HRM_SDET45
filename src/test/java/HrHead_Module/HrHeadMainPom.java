package HrHead_Module;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;
import com.hrm.objectPage.AddBranchHrHead;
import com.hrm.objectPage.AddCorpHrHead;
import com.hrm.objectPage.AddEmpHrHead;
import com.hrm.objectPage.HomePage;
import com.hrm.objectPage.LoginPage;
import com.hrm.objectPage.LogoutPage;

public class HrHeadMainPom {

	public static void main(String[] args) throws Throwable {


		WebDriver driver=new ChromeDriver();
		ExcelUtility rLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		FileUtility fileUt= new FileUtility();
		HashMap<String, String> fields=new HashMap<String, String>();
		wLib.implictWait(driver);
		wLib.maximamWindow(driver);
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		{
			//HrHead Create Corporate...........................................................
			LoginPage lp=new LoginPage(driver);
			lp.HrHeadLogin(wLib, driver);

			HomePage hp=new HomePage(driver);
			hp.ClickCorporate();

			AddCorpHrHead ach=new AddCorpHrHead(driver);
			ach.AddCorporate(wLib,driver,rLib);

			LogoutPage lo=new LogoutPage(driver);
			lo.hrHeadLogout();
			wLib.acceptAlert(driver);
			Thread.sleep(3000);
		}
		{
			//HrHead Create Branch.............................................................................
			LoginPage lp=new LoginPage(driver);
			lp.HrHeadLogin(wLib, driver);

			HomePage hp=new HomePage(driver);
			hp.clickBranch();

			AddBranchHrHead ahb=new AddBranchHrHead(driver);
			ahb.AddBranch(wLib, rLib, driver);

			LogoutPage lo=new LogoutPage(driver);
			lo.hrHeadLogout();
			wLib.acceptAlert(driver);
		    Thread.sleep(3000);
		}
		//HrHead Add Employee....................................................
		{
		LoginPage lp=new LoginPage(driver);
		lp.HrHeadLogin(wLib, driver);

		HomePage hp=new HomePage(driver);
		hp.clickHeadEmployee();

		AddEmpHrHead aeh=new AddEmpHrHead(driver);
		aeh.clickAddEmpHead();;
		aeh.AddHrHeadEmployee( rLib, jLib, driver, wLib, fileUt,"book");
		//rLib.list(driver, "Sheet2");

		LogoutPage lo=new LogoutPage(driver);
		lo.hrHeadLogout();
		wLib.acceptAlert(driver);

	}
	//Add admin as a Hr Head................................................
	{
		LoginPage lp=new LoginPage(driver);
		lp.HrHeadLogin(wLib, driver);
		
		HomePage hp=new HomePage(driver);
		hp.clickAdmin();
		
		AddAdminHrHeadPom aah=new AddAdminHrHeadPom(driver);
		aah.addAdminHrHead(rLib, driver, wLib, fileUt);
		
		LogoutPage lo=new LogoutPage(driver);
		lo.hrHeadLogout();
		wLib.acceptAlert(driver);

	}

}}