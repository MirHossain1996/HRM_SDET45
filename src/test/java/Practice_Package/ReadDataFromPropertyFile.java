package Practice_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	//step1: get object representation for physical file
	FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
	
	//step2: create object properties
	Properties p=new Properties();
	
	//step3: load the file
	p.load(fis);
	
	//step4: get the data from property file
	String url = p.getProperty("url");
	String browser = p.getProperty("browser");
	String hrheademail = p.getProperty("hrheademail");
	String hrheadpwd = p.getProperty("hrheadpwd");
	
	System.out.println(url);
	System.out.println(browser);
	System.out.println(hrheademail);
	System.out.println(hrheadpwd);
}

}
