package com.hrm.objectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hrm.genriUtility.WebDriverUtility;
import com.hrm.genriUtility.iPathContent;
public class LoginPage {
	@FindBy(name="hr_email")
	private WebElement hrUser;

	@FindBy(name="hr_password")
	private WebElement hrPassword;

	@FindBy(name="hr_type")
	private WebElement hrType;

	@FindBy(name="login_hr")
	private WebElement hrLogin;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getHrUser() {
		return hrUser;
	}
	public WebElement getHrPassword() {
		return hrPassword;
	}
	public WebElement getHrType() {
		return hrType;
	}
	public WebElement getHrLogoin() {
		return hrLogin;
	}

	public void HrHeadLogin(WebDriverUtility wLib,WebDriver driver) {
		hrUser.sendKeys(iPathContent.HrHeadEmail);
		hrPassword.sendKeys(iPathContent.HrHeadPwd);
		wLib.select(hrType, 1);
		hrLogin.click();
		wLib.acceptAlert(driver);
	}
	public void HrAsisstantLogin(WebDriverUtility wLib,WebDriver driver) {
		hrUser.sendKeys(iPathContent.HrAssistantEmail);
		hrPassword.sendKeys(iPathContent.HrAssistantPwd);
		wLib.select(hrType, 3);
		hrLogin.click();
		wLib.acceptAlert(driver);
	}
	public void HrOfficerLogin(WebDriverUtility wLib,WebDriver driver) {
		hrUser.sendKeys(iPathContent.HrOfficerEmail);
		hrPassword.sendKeys(iPathContent.HrOfficerPwd);
		wLib.select(hrType, 2);
		hrLogin.click();
		wLib.acceptAlert(driver);
	}
}