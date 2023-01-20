package com.hrm.genriUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUtility {
	/**
	 * It used to read the data from commondata.properties file based on key which you pass as an argument
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String getPropertyKeyValue(String key) throws Exception {
	FileInputStream fis = new FileInputStream(iPathContent.PropertyPath);
	Properties p = new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;
	}
	
	public void fileUpload( String file,WebDriver driver,String xpath) {
		File f=new File(file);
		String  softFile=f.getAbsolutePath();
		driver.findElement(By.xpath(xpath)).sendKeys(softFile);
	
		
	}

	public void fileUpload(String file, WebDriver driver, WebElement fileupload) {
		File f=new File(file);
		String  softFile=f.getAbsolutePath();
		fileupload.sendKeys(softFile);
	}


}
