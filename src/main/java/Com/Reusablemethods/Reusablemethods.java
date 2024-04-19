package Com.Reusablemethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusablemethods {

	protected WebDriver driver;
	public WebDriverWait wait;

	public Reusablemethods(WebDriver driver){

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	public void naviagteurl() {
		driver.get("https://rahulshettyacademy.com/client");

	}

	public void visibilityofelement(WebElement ele) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void invisibilityofelement(WebElement ele) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void maximizewindow() {
		driver.manage().window().maximize();
	}
	public void navigateto() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public void scrolldown() {

	}
	public void elementvisibility(WebElement ele) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
		
	public void getScreenshotas() throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("target.png");
		FileUtils.copyFile(src, dest);
	
	}
}
