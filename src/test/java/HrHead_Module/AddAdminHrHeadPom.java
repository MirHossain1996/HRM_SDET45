package HrHead_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genriUtility.ExcelUtility;
import com.hrm.genriUtility.FileUtility;
import com.hrm.genriUtility.WebDriverUtility;

public class AddAdminHrHeadPom {


	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement addAdminClick;
	
	@FindBy(xpath="(//button[@name='hr_admin'])")
	private WebElement savebutton;

	@FindBy(xpath="(//select[@id='hr_type'])")
	private WebElement hr_typeadmin;
	
	public AddAdminHrHeadPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAddAdminClick() {
		return addAdminClick;
	}


	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public WebElement getHr_typeadmin() {
		return hr_typeadmin;
	}


	public void addAdminHrHead(ExcelUtility rLib,WebDriver driver,WebDriverUtility wLib,FileUtility fileUt) throws Throwable {
		addAdminClick.click();
		rLib.getList(driver, "Admin");
		wLib.select(hr_typeadmin, 2);
		savebutton.click();
		String data = wLib.getTextAlert(driver);
		System.out.println("admin created  :"+data);
		wLib.acceptAlert(driver);
		
	}
}