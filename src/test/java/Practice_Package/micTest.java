package Practice_Package;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class micTest {
//	static {
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
//	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		HashMap<String, Integer> connectSetting=new HashMap<String, Integer>();
		HashMap<String, Object> profile=new HashMap<String, Object>();
		HashMap<String, Object> prefs=new HashMap<String, Object>();
		connectSetting.put("media_stream", 1);
		profile.put("managed_default_content_settings", connectSetting);
		profile.put("profile", profile);
		prefs.put("prefs", prefs);
		option.setExperimentalOption("perfs", prefs);
		
	//	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("mic test.com");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("(//h3[.='Mic Test'])[1]")).click();
		driver.findElement(By.id("mic-launcher")).click();
		
	}
}
