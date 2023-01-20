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

public class DeleteEmpHrAssistant {
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
		driver.findElement(By.xpath("(//i[@title='Delete Employee'])[2]")).click();
		driver.findElement(By.xpath("(//button[.='Delete'])[3]")).click();
		String text = WebD.getTextAlert(driver);
		System.out.println(text);
		String delete="Delete Successfully!!!";
		
		if(delete.equalsIgnoreCase(text))
			System.out.println("delete successfully");
		else 
			System.out.println("not deleted");

		WebD.acceptAlert(driver);
		driver.close();
	
	}
}