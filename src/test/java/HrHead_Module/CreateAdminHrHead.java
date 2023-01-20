package HrHead_Module;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genriUtility.DatabaseUtility;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class CreateAdminHrHead {
	public static void main(String[] args) throws Throwable {
		
	
	WebDriver driver;
	DatabaseUtility db=new DatabaseUtility();
	ExcelUtility exU=new ExcelUtility();
	FileUtility filU=new FileUtility();
	JavaUtility javaU=new JavaUtility();
	WebDriverUtility WebD=new WebDriverUtility();	

	String url = filU.getPropertyKeyValue("url");	
	String HrHeadEmail = filU.getPropertyKeyValue("hrheademail");	
	String HrHeadpwd = filU.getPropertyKeyValue("hrheadpwd");
	String browser= filU.getPropertyKeyValue("browser");

	driver=new ChromeDriver();
	driver.get(url);
	WebD.maximamWindow(driver);
	WebD.implictWait(driver);
	//	login as a Hr Head. 
	driver.findElement(By.name("hr_email")).sendKeys(HrHeadEmail);	
	driver.findElement(By.name("hr_password")).sendKeys(HrHeadpwd);
	WebElement selectType = driver.findElement(By.name("hr_type"));
	WebD.select(selectType, 1);
	driver.findElement(By.name("login_hr")).click();
	WebD.acceptAlert(driver);
	
	driver.findElement(By.xpath("(//a[@class='nav-link'])[9]")).click();
	driver.findElement(By.xpath("(//a[@class='nav-link'])[10]")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-primary' and @data-target='#modal-overlay' ]")).click();

	
	
	driver.findElement(By.name("hr_companyid")).sendKeys("123");
	driver.findElement(By.name("hr_firstname")).sendKeys("Tanweer");
	driver.findElement(By.name("hr_lastname")).sendKeys("Dikhsha");
	driver.findElement(By.name("hr_middlename")).sendKeys("hasan");
	driver.findElement(By.name("hr_contactno")).sendKeys("95249011234");
	WebElement position = driver.findElement(By.name("hr_type"));
	WebD.select(position, 1);
	
	driver.findElement(By.name("hr_email")).sendKeys("tanweer123@gamil.com");
	driver.findElement(By.name("hr_password")).sendKeys("tanweer123");
	driver.findElement(By.xpath("//button[.='Save']")).click();
	String expectedtext="Insert Successfully!!!";
	 String actualtext = WebD.getTextAlert(driver);
	 WebD.acceptAlert(driver);
	 if(expectedtext.equalsIgnoreCase(actualtext))
		 System.out.println("Admin is Created");
	 else
		 System.out.println("Admin is not Created");
	 driver.close();
}
}