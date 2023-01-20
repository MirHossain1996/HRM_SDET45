package com.hrm.objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genriUtility.Base_Officer_Class;

public class CheckDashBoard_Officer_Pom {

	@FindBy(xpath="//span[.='Employee']/ancestor::div[@class='info-box']/descendant::span[@class='info-box-number']")
	public WebElement employee_num;


	public CheckDashBoard_Officer_Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getEmployee_num() {
		return employee_num;
	}
	public void checkDashBoard_emp_officer() {
		String emp_num = employee_num.getText();
		System.out.println("Number of employee in Hr_officer Dashboard==>"+emp_num);
	}
	
	public void checkDashBoard_emp_Bf_officer() {
		String emp_num = employee_num.getText();
		System.out.println("BEFORE Add Employee Number of employee in Hr_officer Dashboard==>"+emp_num);
	}
	
	public void checkDashBoard_emp_Af_officer() {
		String emp_num = employee_num.getText();
		System.out.println("AFTER Add Employee  Number of employee in Hr_officer Dashboard==>"+emp_num);
	}
}
