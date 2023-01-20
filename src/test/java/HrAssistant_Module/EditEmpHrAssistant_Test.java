package HrAssistant_Module;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditEmpHrAssistant_Test {
	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(500);

		//step1: get common data from property file
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String url=p.getProperty("url");
		String un=p.getProperty("hrassistantemail");
		String pwd=p.getProperty("hrassistantpwd");

		//step2: Read the data from excel file.....................................
		FileInputStream fis2 = new FileInputStream("./src/test/resources/EmployeeModuleData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("EmployeeDetails");		
		String empName=sheet.getRow(1).getCell(0).getStringCellValue();

		//login the hr_assistant page	........................................
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

		//		Handle alert popup
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		a.accept();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		String excelname = sheet.getRow(2).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(excelname);
		driver.findElement(By.xpath("(//td[.='c_2'])[1]")).click();
		driver.findElement(By.xpath("(//i[@title='Edit Employee'])[2]")).click();
		Thread.sleep(2000);
		WebElement firstname = driver.findElement(By.xpath("(//input[@name='employee_firstname'])[28]"));
		firstname.click();
		Robot r1=new Robot();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		firstname.sendKeys("Raja");
		Thread.sleep(2000);
		//		JavascriptExecutor j=(JavascriptExecutor)driver;
		//		j.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		WebDriverWait wait1=new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='employee_gsis'])[28]")));
		WebElement gss = driver.findElement(By.xpath("(//input[@name='employee_gsis'])[28]"));
		gss.click();
		r1.keyPress(KeyEvent.VK_CONTROL);
		r1.keyPress(KeyEvent.VK_A);
		r1.keyRelease(KeyEvent.VK_CONTROL);
		gss.sendKeys("2662626");
		Thread.sleep(2000);

		Thread.sleep(3000);
		File f1=new File("./src/test/resources/agile.docx");
		String softfile = f1.getAbsolutePath();
		driver.findElement(By.xpath("(//input[@name='employee_file201'])[15]")).sendKeys(softfile);
		File f2=new File("./src/test/resources/Screenshot (7).png");
		String pic = f2.getAbsolutePath();	
		driver.findElement(By.xpath("(//input[@name='employee_image'])[15]")).sendKeys(pic);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@name='edit_emplo']/ancestor::div[@class='modal-content']/descendant::button[.='Update'])[14]")).click();
		//driver.close();

	}
}

