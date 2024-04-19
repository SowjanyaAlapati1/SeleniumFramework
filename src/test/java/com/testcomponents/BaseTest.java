package com.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import project.Pageobjects.Landingpage;


public class BaseTest{

			
	
	public WebDriver driver;
	Landingpage landingpage;
	ExtentTest test;
	ExtentReports extent; 	
	public WebDriver initializedriver() throws IOException {
		//properties class for global level
		Properties properties=new Properties();
		FileInputStream fis=new FileInputStream("/Users/sreeramkalluri/Music/java/SeleniumFramework/src/main/java/Com/resources/globaltest.properties");
		properties.load(fis);
		String browser=properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1440,900));
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver =new FirefoxDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs (OutputType.FILE) ;
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		}
	
	@BeforeMethod(alwaysRun = true)
	public Landingpage launchapplication() throws IOException {
		driver = initializedriver();
		landingpage=new Landingpage(driver);
		landingpage.naviagteurl();
		return landingpage;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	public void ExtentRepo()
	 {
						 	 
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/extent-report.html");
			htmlReporter.config().setReportName("web automation results");
			htmlReporter.config().setDocumentTitle("Test results");
			ExtentReports extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.setSystemInfo("Tester", "Sowjanya");


		}
	public void onTestFailure(ITestResult result)throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed: " + result.getThrowable());
        }
		getScreenshot("testcasename", driver);
        extent.flush();
	}

	
	
		
			



	}
