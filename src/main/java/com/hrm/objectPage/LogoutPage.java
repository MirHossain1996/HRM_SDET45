package com.hrm.objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy(xpath="//b[.='Welcome!,']")
	private WebElement hrHeadLogout1;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement hrHeadLogout2;
	@FindBy(xpath="(//a[@class='nav-link'])[2]")
	private WebElement HrOfficerLogout1;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]")
	private WebElement HrOfficerLogout2;
	
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement getHrOfficerLogout1() {
		return HrOfficerLogout1;
	}
	public WebElement getHrOfficerLogout2() {
		return HrOfficerLogout2;
	}
	public WebElement getHrHeadLogout1() {
		return hrHeadLogout1;
	}
	public WebElement getHrHeadLogout2() {
		return hrHeadLogout2;
	}

	public void hrHeadLogout() {
		hrHeadLogout1.click();
		hrHeadLogout2.click();
	}

	public void hrOfficer_Assistant_Logout() {
		HrOfficerLogout1.click();
		HrOfficerLogout2.click();
	}
}
