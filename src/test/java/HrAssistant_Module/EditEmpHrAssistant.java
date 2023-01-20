package HrAssistant_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genriUtility.DatabaseUtility;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class EditEmpHrAssistant {
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		DatabaseUtility db=new DatabaseUtility();
		ExcelUtility exU=new ExcelUtility();
		FileUtility filU=new FileUtility();
		JavaUtility javaU=new JavaUtility();
		WebDriverUtility WebD=new WebDriverUtility();

		String url = filU.getPropertyKeyValue("url");	
		String HrAsEmail = filU.getPropertyKeyValue("hrassistantemail");	
		String HrAspwd = filU.getPropertyKeyValue("hrassistantpwd");
		String browser = filU.getPropertyKeyValue("browser");
		String fileadress = filU.getPropertyKeyValue("fileAdress");
		String picAdress = filU.getPropertyKeyValue("picAdress");
		String HrOffEmail = filU.getPropertyKeyValue("hrofficeremail");	
		String HrOffpwd = filU.getPropertyKeyValue("hrofficerpwd");

		System.out.println(browser);
		System.out.println(url);
		System.out.println(HrAsEmail);
		System.out.println(HrAspwd);
		System.out.println(fileadress);		
		System.out.println(picAdress);	
		//		if(browser.equalsIgnoreCase("firefox")) {
		//			System.out.println("ChromeDriver is  not present ");
		//			driver=new FirefoxDriver();
		//			driver.get(url);
		//		}

		driver=new ChromeDriver();
		driver.get(url);
		WebD.maximamWindow(driver);
		WebD.implictWait(driver);

		//login as Hr assistant and create employee.
		driver.findElement(By.name("hr_email")).sendKeys(HrAsEmail);	
		driver.findElement(By.name("hr_password")).sendKeys(HrAspwd);
		WebElement selectType = driver.findElement(By.name("hr_type"));
		WebD.select(selectType, 3);
		driver.findElement(By.name("login_hr")).click();
		WebD.acceptAlert(driver);

		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		String firstname = exU.getDataFromExcel("EmployeeDetails", 1, 1);
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(firstname);	
		driver.findElement(By.xpath("//td[@class='sorting_1']/ancestor::tbody/child::tr[1]/child::td")).click();
		driver.findElement(By.xpath("(//i[@title='Edit Employee'])[2]")).click();
		WebElement tan = driver.findElement(By.xpath("(//input[@name='employee_firstname'])[4]"));
		tan.click();
		WebD.keyPress();
		WebD.keyPressA();
		WebD.keyRelease();
		tan.sendKeys("Sahoo");
		filU.fileUpload(fileadress, driver, "(//input[@name='employee_file201'])[3]");
		filU.fileUpload(picAdress, driver, "(//input[@name='employee_image'])[3]");
		driver.findElement(By.xpath("(//button[.='Update'])[2]")).click();
		String expectedtext="Update Successfully!!!";
		String actualtext = WebD.getTextAlert(driver);
		System.out.println(actualtext);
		WebD.acceptAlert(driver);
		if(expectedtext.equalsIgnoreCase(actualtext))
			System.out.println("employee modification is done");
		else
			System.out.println("employee modification is not  done");
		driver.close();
		
}
}