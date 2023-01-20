package com.hrm.objectPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeleteEmpHrAssistant {
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement HrAssistantSearch;

	@FindBy(xpath="//select[@name='example1_length']")
	private WebElement showHrAssistant;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement clickC1;
	
	@FindBy(xpath="//td[@class='child']/descendant::i[@title='Delete Employee']")
	private WebElement deleteC1;
	
	@FindBy(xpath="(//button[.='Delete'])")
	private List<WebElement> delete;
	
	public DeleteEmpHrAssistant(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getShowHrAssistant() {
		return showHrAssistant;
	}
	
	public WebElement getHrAssistantSearch() {
		return HrAssistantSearch;
	}
	public WebElement getClickC1() {
		return clickC1;
	}

	public WebElement getDeleteC1() {
		return deleteC1;
	}

	public List<WebElement> getDelete() {
		return delete;
	}


	public void deleteEmpHrAssit(String empdetails) {
		Select s=new Select(showHrAssistant);
		s.selectByIndex(3);
		HrAssistantSearch.sendKeys(empdetails);
		clickC1.click();
		deleteC1.click();
		for(int i=0;i<delete.size();i++) {
			delete.get(i).click();
			break;
		}
	}
	
	
}
