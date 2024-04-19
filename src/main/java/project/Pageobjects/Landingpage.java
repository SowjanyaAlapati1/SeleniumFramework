package project.Pageobjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Reusablemethods.Reusablemethods;

public class Landingpage extends Reusablemethods {
	public WebDriver driver;


	@FindBy(id="userEmail")
	public WebElement uid;

	@FindBy(id="userPassword")
	public WebElement pwd;

	@FindBy(id="login")
	public WebElement clicklogin;
	
	@FindBy(xpath="//*[@class='login-wrapper-footer-text']")
	public WebElement register;


	@FindBy(xpath="//*[text()='*Enter Valid Email']")
	public WebElement errormessage;

	@FindBy(id="toast-container")
	public WebElement blankpwd;

	//*[@id="products"]
	@FindBy(xpath="//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/h5/b")
	public List<WebElement> products;

	@FindBy(xpath="//*[text()='ZARA COAT 3']")
	public WebElement ZARA;

	@FindBy(xpath="//*[text()='Automation']")
	public WebElement successmsg;


	//constructor method
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//operational method

	public void userlogin(String emailid) {
		uid.sendKeys(emailid);

	}

	public void pwdlogin(String pwsd) {
		pwd.sendKeys(pwsd);

	}

	public void clickloginbutton() {
		

		clicklogin.click();	
	}
	
	public void waitforsuccessmsg(WebElement ele) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}


	public boolean errorvalidation() {
		errormessage.getText();
		return true;

	}
	public boolean blankerror() {
		blankpwd.getText();
		return true;

	}
	public void cleardata() throws InterruptedException {
		uid.clear();
		pwd.clear();
				
	}










}
