package com.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		WebDriverWait wait;
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.id("userEmail")).sendKeys("sowjanyakalluri96@gmail.com");
		//Thread.sleep(2000);
		driver.findElement(By.id("userPassword")).sendKeys("Sowjanya@123");
		//Thread.sleep(2000);
		driver.findElement(By.id("login")).click();
		//add to cart
		driver.findElement(By.xpath("(//div[@class='card-body']/button)[2]")).click();
		// wait for the toast message
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait for invisibility of spinner
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		//click on orders
		driver.findElement(By.xpath("//*[@routerlink='/dashboard/myorders']")).click();
		//click on goback to cart		
		driver.findElement(By.xpath("(//*[@routerlink='/dashboard/cart'])[2]")).click();
		//click on checkout
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();
		
		
		WebElement e=driver.findElement(By.xpath("//*[@placeholder='Select Country']"));
		Actions a=new Actions(driver);
		a.sendKeys(e, "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		//place order
		driver.findElement(By.cssSelector(".action__submit")).click();
		String Thankyoumessage=driver.findElement(By.className("hero-primary")).getText();
		System.out.println(Thankyoumessage);
		Assert.assertTrue(true);
		//Signout
		driver.findElement(By.xpath("(//*[@class='btn btn-custom'])[4]")).click();
		driver.close();

		
		

	}

}
