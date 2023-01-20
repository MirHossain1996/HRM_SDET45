package HrAssistant_Module;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genriUtility.FileUtility;

public class EditEmpHrAssistantPom {


	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement HrAssistantSearch;

	@FindBy(xpath="//select[@name='example1_length']")
	private WebElement showHrAssistant;

	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement clickC1;

	@FindBy(xpath="(//i[@class='fa fa-edit'])[2]")
	private WebElement editC1;

	@FindBy(xpath="(//input[@name='employee_firstname'])[4]")
	private WebElement firstname;

	@FindBy(xpath="//button[.='Update']")
	private List<WebElement> updateHrAssiatant;

	public EditEmpHrAssistantPom(WebDriver driver) {
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



	public WebElement getFirstname() {
		return firstname;
	}



	public void setUpdateHrAssiatant(List<WebElement> updateHrAssiatant) {
		this.updateHrAssiatant = updateHrAssiatant;
	}



	public List<WebElement> getUpdateHrAssiatant() {
		return updateHrAssiatant;
	}

	public void editEmployeeHrAssit(FileUtility fileUt,WebDriver driver,String empdetails) {
		Select s=new Select(showHrAssistant);
		s.selectByIndex(3);
		HrAssistantSearch.sendKeys(empdetails);
		clickC1.click();
		editC1.click();

		firstname.sendKeys(Keys.CONTROL+"a");
		firstname.sendKeys("Sahoo");

		fileUt.fileUpload("./src/test/resources/Chay.docx", driver, "(//input[@name='employee_file201'])[3]");
		fileUt.fileUpload("./src/test/resources/Screenshot (7).png", driver, "(//input[@name='employee_image'])[3]");
		for (int i = 0; i <updateHrAssiatant.size() ; i++) {
			updateHrAssiatant.get(i).click();
		}
	}


}
