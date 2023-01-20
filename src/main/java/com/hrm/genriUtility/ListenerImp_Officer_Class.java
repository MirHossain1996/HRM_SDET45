package com.hrm.genriUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp_Officer_Class implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext context) {
		//consolidated the report
		report.flush();
	}

	public void onStart(ITestContext context) {

		//configure the report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-45 Extent Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Human Resourse Management");

		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("OS", "Windows10");
		report.setSystemInfo("Base-URL", "https://localhost:8888");
		report.setSystemInfo("Reporter ", "MD Mir Hossain");
	}



	public void onTestFailure(ITestResult result) {

		String failedscript=result.getMethod().getMethodName();
		System.out.println(failedscript+"======Execute i am listening============");
		String FS = failedscript+ new JavaUtility().getSystemDateAndTimeFormate();
		EventFiringWebDriver edriver= new EventFiringWebDriver(Base_Officer_Class.sdriver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		File path = new File("./screenshot/"+FS+".png");
		String filepath = path.getAbsolutePath();
		try {
			FileUtils.copyFile(srcfile,path );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath);
		test.log(Status.FAIL,result.getThrowable());
		Reporter.log("===Testscript Execution fail=======");


	}

	public void onTestSkipped(ITestResult result) {

		String methodname = result.getMethod().getMethodName();
		test.generateLog(Status.SKIP, methodname+"=======>Skiped");
		Reporter.log(methodname+"=======>Testscript excute Skiped");

	}

	public void onTestStart(ITestResult result) {
		//Execution start from here
		String methodname = result.getMethod().getMethodName();
		test=report.createTest(methodname);
		Reporter.log(methodname+"========>Testscripts execution started ");
	}
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.generateLog(Status.PASS, methodname+"=======>Pass");
		Reporter.log(methodname+"=======>Testscript excute successfully");
	}
}