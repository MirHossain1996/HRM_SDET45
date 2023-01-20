package HrHead_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hrm.genriUtility.ExcelUtility;

public class AddCorporteHrHeadPom {
	@FindBy(xpath="//button[@class='btn btn-primary']/ancestor::div[1]/descendant::h3")
	private WebElement addCorporate;
	
	@FindBy(xpath="//input[@placeholder='Corporate Name']")
	private WebElement copName;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement saveCorp;
	
	public AddCorporteHrHeadPom(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddCorporate() {
		return addCorporate;
	}

	public WebElement getCopName() {
		return copName;
	}
	
 
	public WebElement getSaveCorp() {
		return saveCorp;
	}

	public void AddCorporate(com.hrm.genriUtility.WebDriverUtility wLib,WebDriver driver,ExcelUtility rLib) throws Throwable, Throwable {
		addCorporate.click();
		copName.sendKeys(rLib.getDataFromExcel("Branch&corporate", 1, 1));
		saveCorp.click();
		String data = wLib.getTextAlert(driver);
		System.out.println("Hr head Corporate ::"+data);
		wLib.acceptAlert(driver);
	}
}
