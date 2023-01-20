package com.hrm.genriUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * it is used to maximize window
	 * @param driver
	 */
	public void maximamWindow( WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implictWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * It is used to wait until to be visible
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value){
		Select s=new Select(element);
		s.deselectByValue(value);

	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index){
		Select s=new Select(element);
		s.selectByIndex(index);

	}
	/**
	 * 
	 * @param visiblettext
	 * @param element
	 */
	public void select( String visiblettext,WebElement element){
		Select s=new Select(element);
		s.selectByVisibleText(visiblettext);

	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
	}
	/**
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target);
	}
	/**
	 * 
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyPress() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL); 
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyPressA() throws Throwable {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_A);
	}
	/**
	 * 
	 * @throws Throwable
	 */
	public void keyRelease() throws Throwable {
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_CONTROL);
	}
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param adress
	 */
	public void switchToFrame(WebDriver driver, WebElement adress) {
		driver.switchTo().frame(adress);
	}
	/**
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> window=driver.getWindowHandles();
		Iterator<String> itr=window.iterator();
		while(itr.hasNext()) {
			String wind=itr.next();
			String currentWindowTitle=driver.switchTo().window(wind).getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * 
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src=t.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenshotName+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}


	/**
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollBarAction(WebDriver driver,int x,int y) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(x,y)");
	}

	/**
	 * 
	 * @param driver
	 * @param element
	 * @param x
	 * @param y
	 */
	public void scrollAction(WebDriver driver,WebElement element,int x,int y) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(x,y)",element);
	}



}
