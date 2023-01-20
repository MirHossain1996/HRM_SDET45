package HrAssistant_Module;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genriUtility.DatabaseUtility;
import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.JavaUtility;
import com.hrm.genriUtility.WebDriverUtility;
import com.hrm.genriUtility.iPathContent;

public class CreateEmpHrAssistant {

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
		for (int i = 0; i < al.size(); i++) {
			exU.setDataExcel("EmployeeDetails", 0, i, al.get(i));	
		}	
		exU.getList(  driver, "EmployeeDetails", 1,2);

		//	 File f1=new File("./src/test/resources/Chay.docx");
		//		String softfile = f1.getAbsolutePath();
		//		driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(softfile);
		filU.fileUpload(fileadress, driver, "(//input[@name='employee_file201'])[1]");
		filU.fileUpload(picAdress, driver, "//input[@name='employee_image']");

		//		File f2=new File("./src/test/resources/Screenshot (7).png");
		//		String pic = f2.getAbsolutePath();
		//		driver.findElement(By.name("employee_image")).sendKeys(pic);

		driver.findElement(By.xpath("//button[.='Save']")).click();

		String actualtext = WebD.getTextAlert(driver);
		System.out.println(actualtext);
		String expectedtext = "Insert Successfully";
		if(expectedtext.equalsIgnoreCase(actualtext)) {
			System.out.println("Employee is added in employee list by Hr_assistant");
		}
		WebD.acceptAlert(driver);

		String firstname = exU.getDataFromExcel("EmployeeDetails", 1, 1);
//		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(firstname);
//		List<WebElement> namelist = driver.findElements(By.xpath("//td[.='"+firstname+"']"));
//		int count=0;
//		for (int i = 0; i < namelist.size(); i++) 
//		{	
//			namelist.get(i).getText();
//			count++;
//		}
//		if(count>0)
//			System.out.println("present employee name is  : "+firstname);
//		else {
//			System.out.println("Not present employee  :"+firstname);
//		}
//		System.out.println(firstname+"  name number of employee  is === "+count);

		//Logout from Hr assistant page
		driver.findElement(By.xpath("//a[@class='nav-link' and @data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link' and @data-toggle='dropdown']/following-sibling::div/child::a[2]")).click();
		WebD.acceptAlert(driver);

		//login as a Hr officer and check created employee is present or not
		driver.findElement(By.name("hr_email")).sendKeys(HrOffEmail);	
		driver.findElement(By.name("hr_password")).sendKeys(HrOffpwd);
		WebElement selectTypeForOfficer = driver.findElement(By.name("hr_type"));
		WebD.select(selectTypeForOfficer, 2);
		driver.findElement(By.name("login_hr")).click();
		WebD.acceptAlert(driver);

		driver.findElement(By.xpath("(//a[@class='nav-link'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='nav-link'])[4]")).click();
		
		//click on show button................................................................................................
		WebElement showelement = driver.findElement(By.xpath("//select[@name='example1_length']"));
		WebD.select(showelement, 2);
		
		//check the how many same name employee is present
		driver.findElement(By.xpath("//input[@class='form-control form-control-sm']")).sendKeys(firstname);	
		List<WebElement> namelistInOfficer = driver.findElements(By.xpath("//td[.='"+firstname+"']"));
		int count1=0;
		for (int i = 0; i < namelistInOfficer.size(); i++) {
			namelistInOfficer.get(i).getText();
			count1++;
		}

		if(count1>0)
			System.out.println(firstname+"==Employee is present in officer account: ");
		else
			System.out.println("Not present employee  :");

		System.out.println(firstname+"  This employee present  "+count1+" times");
		
		
		driver.findElement(By.xpath("//a[@class='nav-link' and @data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@class='nav-link' and @data-toggle='dropdown']/following-sibling::div/child::a[2]")).click();
		WebD.acceptAlert(driver);

		// driver.close();		
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
