package HrHead_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genriUtility.DatabaseUtility;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class CreateCorporateHrHead {
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
		String browser = filU.getPropertyKeyValue("browser");

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
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and @data-target='#modal-overlay' ]")).click();
		String corporatebame = exU.getDataFromExcel("Branch&corporate", 3, 1);
		System.out.println(corporatebame);
		driver.findElement(By.xpath("//input[@name='corporate_name' and @placeholder='Corporate Name']")).sendKeys(corporatebame);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		String actualtext = WebD.getTextAlert(driver);
		WebD.acceptAlert(driver);
		String expectedtext="Insert Successfully!!!";
		if(expectedtext.equalsIgnoreCase(actualtext))
			System.out.println("corporate is created ");
		else
			System.out.println("corporate is not craeted");
		
		
		driver.close();
		
}
}