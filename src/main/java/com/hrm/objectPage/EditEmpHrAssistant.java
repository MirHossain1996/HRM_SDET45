package com.hrm.objectPage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class EditEmpHrAssistant {
	
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement HrAssistantSearch;

	@FindBy(xpath="//select[@name='example1_length']")
	private WebElement showHrAssistant;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement clickC1;
	
	@FindBy(xpath="(//i[@class='fa fa-edit'])[2]")
	private WebElement editC1;
	
	@FindBy(xpath="//input[@name='employee_firstname']")
	private List<WebElement> firstname;
	
	@FindBy(xpath="//button[.='Update']")
	private List<WebElement> updateHrAssiatant;
	
	@FindBy(xpath="//div[@id='modal-edits112']/descendant::div[@class='modal-content']/descendant::input[@name='employee_file201']")
	private WebElement fileupload;
	
	@FindBy(xpath="//div[@id='modal-edits112']/descendant::div[@class='modal-content']/descendant::input[@name='employee_image']")
	private WebElement picUpload;
	
	public EditEmpHrAssistant(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	

	public WebElement getHrAssistantSearch() {
		return HrAssistantSearch;
	}



	public WebElement getShowHrAssistant() {
		return showHrAssistant;
	}



	public WebElement getClickC1() {
		return clickC1;
	}



	public WebElement getEditC1() {
		return editC1;
	}



	public List<WebElement> getFirstname() {
		return firstname;
	}



	public void setUpdateHrAssiatant(List<WebElement> updateHrAssiatant) {
		this.updateHrAssiatant = updateHrAssiatant;
	}



	public WebElement getFileupload() {
		return fileupload;
	}



	public WebElement getPicUpload() {
		return picUpload;
	}



	public List<WebElement> getUpdateHrAssiatant() {
		return updateHrAssiatant;
	}

	public void editEmployeeHrAssit(WebDriverUtility wLib, FileUtility fileUt,WebDriver driver,String empdetails, String fname,ExcelUtility eLib) throws Throwable {
		Select s=new Select(showHrAssistant);
		s.selectByIndex(3);
		HrAssistantSearch.sendKeys(empdetails);
		clickC1.click();
		editC1.click();
		for (int i = 0; i < firstname.size(); i++) {
		 WebElement newfirst = firstname.get(i);
		 newfirst.click();
		 wLib.keyPress();
			wLib.keyPressA();
			wLib.keyRelease();
			newfirst.sendKeys("sahoo");
		break;
//		Robot r=new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_A);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_CLEAR);
		
		}
		
//		if(fname.contains(eLib.getDataFromExcel("EmployeeDetails", 0, 1)))
//		{                                                       
//			driver.findElement(By.name(eLib.getDataFromExcel("EmployeeDetails", 0, 1)));
//		}
	
//			firstname.sendKeys(Keys.CONTROL+"a");
//			firstname.sendKeys("Sahoo");
	
		fileUt.fileUpload("./src/test/resources/Chay.docx", driver, fileupload);
		fileUt.fileUpload("./src/test/resources/Screenshot (7).png", driver, picUpload);
		for (int i = 0; i <updateHrAssiatant.size() ; i++) {
			updateHrAssiatant.get(i).click();
		}
	}


}
