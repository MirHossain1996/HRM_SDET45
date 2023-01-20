package HrHead_Module;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBranchHrHead_Test {
	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(500);

		//step1: get common data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("hrheademail");
		String pwd=p.getProperty("hrheadpwd");

		//step2: Read the data from excel file.....................................
		FileInputStream fis2 = new FileInputStream("./src/test/resources/EmployeeModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("Branch&corporate");		
		String branchName=sheet.getRow(2).getCell(0).getStringCellValue();

		//login the hr_headpage	........................................
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("hr_email")).sendKeys(un);	
		driver.findElement(By.name("hr_password")).sendKeys(pwd);
		WebElement selectType = driver.findElement(By.name("hr_type"));
		Select s=new Select(selectType);
		s.selectByIndex(1);
		driver.findElement(By.name("login_hr")).click();

		//		Handle alert popup
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		a.accept();
		
		driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[6]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='branches_name'])[1]")).sendKeys(branchName);
		driver.findElement(By.xpath("(//button[.='Save'])")).click();
		String expectedtext="Insert Successfully!!!";
		String text = a.getText();
		if(expectedtext.equalsIgnoreCase(text))
			System.out.println("Branch is added sucessfully");
		else
			System.out.println("Branch is not added sucessfully");
		a.accept();
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(branchName);
		 List<WebElement> branch = driver.findElements(By.xpath("//td[.='kolkata']"));
		 int count=0;
		 for (int i = 0; i < branch.size(); i++) {
			 String actualbranch = branch.get(i).getText();
			 count++;
//		if(branchName.equals(actualbranch)) {
//			System.out.println("present branch ");
//		}
//		else
//			System.out.println("not present branch");
		
		 }
		 if(count>0)
			 System.out.println("present branch  : "+branchName);
		 else
			 System.out.println("Not present branch  :"+branchName);
		 
		 System.out.println(branchName+"  number of branch same name is  "+count);
			 
		 driver.close();
		
}
}