package com.hrm.objectPage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class AddEmpHrOfficer {

	@FindBy(xpath="//button[@class='btn btn-primary']/preceding::h3")
	private WebElement addEmployee;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveEmployee;
	
	public AddEmpHrOfficer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddEmployee() {
		return addEmployee;
	}

	public WebElement getSaveEmployee() {
		return saveEmployee;
	}
	public void AddHrOfficerEmployee(ExcelUtility rLib,WebDriver driver,WebDriverUtility wLib ,FileUtility fileUt) throws Throwable {
		addEmployee.click();
		rLib.getList(driver, "EmployeeDetails");
		fileUt.fileUpload("./src/test/resources/Chay.docx", driver, "(//input[@name='employee_file201'])[1]");
		fileUt.fileUpload("./src/test/resources/Screenshot (7).png", driver, "//input[@name='employee_image']");
//		File docx=new File("./src/test/resources/Mshyamkumar.docx");
//			String docsPath = docx.getAbsolutePath();
//			driver.findElement(By.name("employee_file201")).sendKeys(docsPath);
//			Thread.sleep(2000);
//			File img=new File("./src/test/resources/Screenshot (8).png");
//			   String imgPath =img.getAbsolutePath();
//			driver.findElement(By.name("employee_image")).sendKeys(imgPath);
//			// driver.findElement(By.name("emplo")).click();
			saveEmployee.click();

		  String data = wLib.getTextAlert(driver);
		  System.out.println("Hr officer Employee :"+data);
		   Thread.sleep(2000);
		   wLib.acceptAlert(driver);
		 
		   
	}
}
