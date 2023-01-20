package HrAssistant_Module;

import java.awt.List;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

public class CreateEmpHrAssistant_Test {
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
		String empName=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(empName);

		//login the hrassistant page	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("hr_email")).sendKeys(un);	
		driver.findElement(By.name("hr_password")).sendKeys(pwd);
		Thread.sleep(2000);	
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
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/ancestor::div[1]/descendant::h3")).click();

		ArrayList<String> al = new ArrayList<String>();
		al.add("employee_companyid");
		al.add("employee_firstname");
		al.add("employee_lastname");
		al.add("employee_middlename");
		al.add("branches_datefrom");
		al.add("branches_recentdate");
		al.add("employee_department");
		al.add("employee_branches");
		al.add("employee_position");
		al.add("employee_contact");
		al.add("employee_sss");
		al.add("employee_tin");
		al.add("employee_hdmf_pagibig");
		al.add("employee_gsis");

		for (int i = 0; i <sheet.getRow(0).getLastCellNum(); i++) {
			String value = sheet.getRow(2).getCell(i).getStringCellValue();
			driver.findElement(By.name(al.get( i))).sendKeys(value);	
		}
//		handle file upload
		File f1=new File("./src/test/resources/Chay.docx");
		String softfile = f1.getAbsolutePath();
		driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(softfile);
		Thread.sleep(2000);
		File f2=new File("./src/test/resources/Screenshot (7).png");
		String pic = f2.getAbsolutePath();
		driver.findElement(By.name("employee_image")).sendKeys(pic);
		driver.findElement(By.xpath("//button[.='Save']")).click();
		String actualtext = a.getText();
		System.out.println(actualtext);
		if(expectedtext.equalsIgnoreCase(actualtext)) {
			System.out.println("Employee is added in employee list by Hr_assistant");
		}
		a.accept();
		
//		check employee created
		String excelname = sheet.getRow(2).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(excelname);
		String typename="MD";
		java.util.List<WebElement> actualname = driver.findElements(By.xpath("//td[.='MD']"));
		int count=0;
		for (int i = 0; i < actualname.size(); i++) {
			String totalemployee = actualname.get(i).getText();
			if(totalemployee.equalsIgnoreCase(typename)) {
				count++;
				System.out.println("MD employee is created by HR_Assistant");
			}
		}
		if(count==0)
			System.out.println("MD employee is not created by HR_Assistant");
		System.out.println("number of MD employee is :"+count);
		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();",button);
//		Robot rb=new Robot();
//		rb.delay(2000);
//		
//		StringSelection ss=new StringSelection("./src/test/resources/Chay.docx");
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		rb.keyPress(KeyEvent.VK_CONTROL);
//		rb.keyPress(KeyEvent.VK_V);
//		
//		rb.keyRelease(KeyEvent.VK_CONTROL);
//		rb.keyRelease(KeyEvent.VK_V);
//		
//		rb.keyPress(KeyEvent.VK_ENTER);
//		
//		Thread.sleep(2000);
//		driver.findElement(By.name("employee_image")).sendKeys(absulatepath2);
		driver.close();
		}
}
