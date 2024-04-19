package com.testcomponents;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.Status;


public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent;
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		//extent = ExtentReports.getReportObject();
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, "Test passed");
		extenttest.set(test);
	}
	
		@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception ex) {
			
			ex.printStackTrace();
		} 
		
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
		e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());	
		
		extent.flush();
	}
	
}


