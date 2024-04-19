package project.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Reusablemethods.Reusablemethods;

public class Homepage extends Reusablemethods{
	
	 
	
	@FindBy(id="toast-container")
	public WebElement toastmsg;
	
	@FindBy(css=".ng-animating")
	public WebElement spinner;
	
	@FindBy(xpath="(//div[@class='card-body']/button)[2]")
	public WebElement addcart;
	
	@FindBy(xpath="//*[@routerlink='/dashboard/myorders']")
	public WebElement orders;
	
	@FindBy(xpath="(//*[@routerlink='/dashboard/cart'])[2]")
	public WebElement backcart;

	@FindBy(xpath="(//*[@class='btn btn-custom'])[4]")
	public WebElement signout;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	public WebElement clickcheckoutbutton;

	@FindBy(xpath="//*[@placeholder='Select Country']")
	public WebElement country;
	
	@FindBy(css=".ta-results")
	public WebElement dropdownresults;
	
	@FindBy(xpath="(//*[@type='button'])[2]")
	public WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	public WebElement placeorder;
	
	@FindBy(className="hero-primary")
	public WebElement thankyoumsg;

	
	public Homepage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void addtocart() throws InterruptedException {
		Thread.sleep(5000);
		visibilityofelement(toastmsg);
		invisibilityofelement(spinner);
		addcart.click();
	}
	
	public void clickorders() throws InterruptedException {
		Thread.sleep(5000);
		orders.click();
	}
	public void backtocart() throws InterruptedException {
		Thread.sleep(3000);
		backcart.click();
	}
	public void checkout() {
		clickcheckoutbutton.click();
	}
	
	public void countryselection(String countryselection) throws InterruptedException {
		Actions a=new Actions(driver);
		a.sendKeys(country, countryselection).build().perform();
		elementvisibility(dropdownresults);
		selectcountry.click();
	}
	
	public void orderplaced() throws InterruptedException  {
		placeorder.click();
		Thread.sleep(2000);
	String msg=thankyoumsg.getText();
	System.out.println(msg);
		
	}
	public void signoutpage() throws InterruptedException {
		Thread.sleep(2000);
		signout.click();
		
	}
	


}
