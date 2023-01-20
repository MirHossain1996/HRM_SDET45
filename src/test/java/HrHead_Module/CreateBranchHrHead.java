package HrHead_Module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.hrm.genriUtility.DatabaseUtility;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class CreateBranchHrHead {
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

		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[6]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

		String branchName = exU.getDataFromExcel("Branch&corporate", 2, 0);
		driver.findElement(By.xpath("(//input[@name='branches_name'])[1]")).sendKeys(branchName);
		driver.findElement(By.xpath("(//button[.='Save'])")).click();
		String expectedtext="Insert Successfully!!!";
		String text = WebD.getTextAlert(driver);
		if(expectedtext.equalsIgnoreCase(text))
			System.out.println("Branch is added sucessfully");
		else
			System.out.println("Branch is not added sucessfully");
		WebD.acceptAlert(driver);

		//click on show button change the limit
		WebElement showelement = driver.findElement(By.xpath("//select[@name='example1_length']"));
		WebD.select(showelement, 2);
		
		// check the number of same name branch created by HR head.
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(branchName);
		List<WebElement> branch = driver.findElements(By.xpath("//td[.='"+branchName+"']"));
		int count=0;
		for (int i = 0; i < branch.size(); i++) {
			branch.get(i).getText();
			count++;
		}
		if(count>0)
			System.out.println("present branch  : "+branchName);
		else
			System.out.println("Not present branch  :"+branchName);

		System.out.println("created "+branchName+"  branch   "+count+" times.");

		driver.close();

	}
}