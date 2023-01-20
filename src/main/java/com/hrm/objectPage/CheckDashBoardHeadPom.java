package com.hrm.objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckDashBoardHeadPom {

	@FindBy(xpath="//span[.='Employee']/ancestor::div[@class='info-box']/descendant::span[@class='info-box-number']")
	private WebElement employee_num;
	
	@FindBy(xpath="//span[.='Corporate']/ancestor::div[@class='info-box mb-3']/descendant::span[@class='info-box-number']")
	private WebElement corporate_num;
	
	@FindBy(xpath="//span[.='Braches']/ancestor::div[@class='info-box mb-3']/descendant::span[@class='info-box-number']")
	private WebElement Branches_num;
	
	@FindBy(xpath="//span[.='Admin Account']/ancestor::div[@class='info-box mb-3']/descendant::span[@class='info-box-number']")
	private WebElement Admin_num;

	
	public CheckDashBoardHeadPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAdmin_Count() {
		return Admin_num;
	}


	public WebElement getBranches_num() {
		return Branches_num;
	}


	public WebElement getCorporate_num() {
		return corporate_num;
	}


	public WebElement getEmployee_num() {
		return employee_num;
	}
	public void checkDashBoardHead() {
		String countAdmin = Admin_num.getText();
		String countCorporate = corporate_num.getText();
		String countBranch = Branches_num.getText();
		String countEmployee = employee_num.getText();
		System.out.println("Hr_Head_Dashboard present Admin Account is==>"+countAdmin+", Corporate ==>"+countCorporate+" ,Branch==>"+countBranch+" ,Employee==>"+countEmployee);
	}
	public void checkDashborad_crp_Bf_create() {
		String countCorporate = corporate_num.getText();
		System.out.println("Before create corporate number of corporate present ==>"+countCorporate);
	}
	public void checkDashborad_crp_Af_create() {
		String countCorporate = corporate_num.getText();
		System.out.println("After create corporate number of corporate present ==>"+countCorporate);
	}
	
	public void checkDashborad_Branch_Bf_create() {
		String countBranch = Branches_num.getText();
		System.out.println("Before create Branch number of branch present ==>"+countBranch);
	}
	public void checkDashborad_Branch_Af_create() {
		String countBranch = Branches_num.getText();
		System.out.println("After create baranch number of branch present ==>"+countBranch);
	}
	
	public void checkDashborad_Admin_Bf_create() {
		String countAdmin = Admin_num.getText();
		System.out.println("Before create Admin number of Admin present ==>"+countAdmin);
	}
	public void checkDashborad_Admin_Af_create() {
		String countAdmin = Admin_num.getText();
		System.out.println("After create Admin number of Admin present ==>"+countAdmin);
	}
	
	public void checkDashborad_Emp_Bf_create() {
		String countEmployee = employee_num.getText();
		System.out.println("Before create Employee number of Employee present ==>"+countEmployee);
	}
	public void checkDashborad_Emp_Af_create() {
		String countEmployee = employee_num.getText();
		System.out.println("After create Employee number of Employee present ==>"+countEmployee);
	}
	
	
}
