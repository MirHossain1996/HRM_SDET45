package HrAssistant_Module;

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

public class DeleteEmpHrAssistant_Test {
	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(500);
		String expectedtext = "Insert Successfully";

		//step1: get common data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("hrassistantemail");
		String pwd=p.getProperty("hrassistantpwd");

		//step2: Read the data from excel file
		FileInputStream fis2 = new FileInputStream("./src/test/resources/EmployeeModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("EmployeeDetails");		
		String empName=sheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(empName);

		//login the hrassistant page	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("hr_email")).sendKeys(un);	
		driver.findElement(By.name("hr_password")).sendKeys(pwd);
		WebElement selectType = driver.findElement(By.name("hr_type"));
		Select s=new Select(selectType);
		s.selectByIndex(3);
		driver.findElement(By.name("login_hr")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(empName);
		WebElement click = driver.findElement(By.xpath("//td[@class='sorting_1']"));

		click.click();
		driver.findElement(By.xpath("(//i[@title='Delete Employee'])[2]")).click();
		driver.findElement(By.xpath("(//button[.='Delete'])")).click();
		String delete="Delete Successfully!!!";
		String delete1 = a.getText();
		if(delete.equalsIgnoreCase(delete1))
			System.out.println("delete successfully");
		else 
			System.out.println("not deleted");

		a.accept();
		driver.close();
//		List<WebElement> actualname = driver.findElements(By.xpath("//td[.='"+empName+"']"));
//		System.out.println(empName+"   before delete number employe present as as a same name  :"+actualname.size());
//		
//		 List<WebElement> clicks = driver.findElements(By.xpath("//td[@class='sorting_1']"));
//		 for (int i = 0; i <clicks.size(); i++) {
//			clicks.get(i).click();
//			Thread.sleep(5000);
//			driver.findElement(By.xpath("(//i[@title='Delete Employee'])[2]")).click();
//			Thread.sleep(5000);
//			
//			driver.findElement(By.xpath("(//button[.='Delete'])")).click();
//			a.accept();
//			Thread.sleep(5000);
//			System.out.println("one deleted");
//			driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(empName);
//			
//		}
//		 
//		 List<WebElement> actualname1 = driver.findElements(By.xpath("//td[.='"+empName+"']"));
//			System.out.println(empName+"   after delete number employe present as as a same name  :"+actualname1.size());
//			
//		
		
		
}
}