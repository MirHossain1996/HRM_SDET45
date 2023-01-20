package com.hrm.objectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class AddBranchHrHead {
	
	@FindBy(xpath="//button[@class='btn btn-primary']/preceding::h3")
	private WebElement addBranch;
	
	@FindBy(xpath="//input[@placeholder='Branches Name']")
	private WebElement branchName;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveBranch;
	
	public AddBranchHrHead(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddBranch() {
		return addBranch;
	}

	public WebElement getBranchName() {
		return branchName;
	}

	public WebElement getSaveBranch() {
		return saveBranch;
	}
public void AddBranch(WebDriverUtility wLib,ExcelUtility rLib,WebDriver driver) throws Throwable, Throwable {
	addBranch.click();
	branchName.sendKeys(rLib.getDataFromExcel("Branch&corporate", 1, 0));
	saveBranch.click();
	String data = wLib.getTextAlert(driver);
	System.out.println("Hr Head Branch  ::"+data);
	wLib.acceptAlert(driver);
}
}

