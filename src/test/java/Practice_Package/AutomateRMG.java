package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateRMG {

	public static void main(String[] args) throws InterruptedException, SQLException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		String project_name="HRM_Softwere_Shyam";
		String created_by="Mr. deepak sir";
		Connection con=null;
		Statement state=null;

		try {
			driver.get("http://rmgtestingserver:8084/");
			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
			driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			driver.findElement(By.xpath("//span[.='Create Project']")).click();
			driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(project_name);
			driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Shyam");
			WebElement dropdown = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
			Select s=new Select(dropdown);
			s.selectByVisibleText("Created");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();


			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
			con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			state = con.createStatement();
			String query = "select * from project";
			ResultSet result = state.executeQuery(query);
			boolean flag = false;
			while(result.next()) {
				String actualcreater=result.getString(2);
				String actualprojectname=result.getString(4);
				System.out.println(actualcreater);
				if(actualcreater.equalsIgnoreCase(created_by) && actualprojectname.equalsIgnoreCase(project_name)) {
					flag=true;
					break;
				}
			}
			if(flag)
				System.out.println("Project is Created by"+created_by);
			else
				System.out.println("Project is  not Created "+created_by);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
			System.out.println("Database is closed ");

		}
		driver.close();
	}

}
