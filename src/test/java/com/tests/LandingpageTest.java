package com.tests;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testcomponents.BaseTest;

import project.Pageobjects.Homepage;
import project.Pageobjects.Landingpage;


public class LandingpageTest extends BaseTest{
	Landingpage lp;
	Homepage hp;

	@Test(groups="errors")
	public void Hashmaptest()throws InterruptedException {

		lp=new Landingpage(driver);
		hp=new Homepage(driver);
		HashMap<String, String> map1=new HashMap<String, String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of test iterations");
		int n=(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter test data for n iterations");
		for(int i=0;i<n;i++) {
			System.out.println("Enter emailid");
			String emailid=sc.nextLine();
			System.out.println("Enter password");
			String pwd = sc.nextLine();
			map1.put(emailid, pwd);
			for(Map.Entry<String, String> m:map1.entrySet()) {
				lp.userlogin(m.getKey());	
				lp.pwdlogin(m.getValue());
				lp.clickloginbutton();
				try {
					if(m.getKey().equalsIgnoreCase("*Email is required")&& lp.errormessage.isDisplayed()) {
						System.out.println("Enter valid email test passed");
					}
					else if(m.getValue().equalsIgnoreCase("'*Password is required")&&lp.blankpwd.isDisplayed()) {
						System.out.println("blank pwd test passed");
					}
					else {
						System.out.println("login test failed");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}
	
	@DataProvider
	public Object[][] Setmultipledata() {

		Object[][] data=new Object[2][2];
		data[0][0]="www";
		data[0][1]=";";

		data[1][0]="ddd";
		data[1][1]="";
		return data;
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "sowjanyakalluri96@gmail.com");
		map.put("pwd", "Sowjanya@123");

		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "sowjnayakllur.com");
		map1.put("pwd", "Sowjnaya@123");

		return new Object[][] {{map},{map1}};

	}		
	@Test(groups={"regression"})
	public WebElement Arraylisttest()throws InterruptedException {

		lp=new Landingpage(driver);
		ArrayList<String> emailid=new ArrayList<String>();
		ArrayList<String> pass=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no.of test iterations");
		int n = (Integer.parseInt(sc.nextLine()));
		System.out.println("enter test data for n iterations");
		for(int i=0;i<n;i++) {
			System.out.println("enter email id");
			emailid.add(sc.nextLine());

			System.out.println("enter password");
			pass.add(sc.nextLine());

			lp.userlogin(emailid.get(i));
			lp.pwdlogin(pass.get(i));
			lp.clickloginbutton();

			if(emailid.get(i).equalsIgnoreCase("valid") && lp.errormessage.isDisplayed()) {
				System.out.println(lp.errormessage.getText());
				return lp.errormessage;
			}

			else if(pass.get(i).equalsIgnoreCase("password")&& lp.blankpwd.isDisplayed()){
				System.out.println(lp.blankpwd.getText());
				return lp.blankpwd;
			}
			else if(emailid.get(i).equalsIgnoreCase("valid") && lp.pwd.isDisplayed()) {
				System.out.println(lp.pwd.getText());
				return lp.pwd;

			}
			else if(pass.get(i).equalsIgnoreCase("valid") && lp.clicklogin.isDisplayed()) {
				System.out.println(lp.clicklogin.getText());
				return lp.clicklogin;
			}
			else {
				System.out.println("test failed");
				return null;
			}
			
		}
		return null;
		
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test(groups="sanity")
	public void arraylistcheck() throws InterruptedException {

		lp=new Landingpage(driver);
		hp=new Homepage(driver);

		lp.userlogin("sowjanyakalluri96@gmail.com");
		lp.pwdlogin("Sowjanya@123");
		lp.clickloginbutton();

		String[] items= {"ZARA COAT3","ADIDAS"};
		List<WebElement> l=lp.products;

		for(int i=0;i<l.size();i++) {
			String[] name = l.get(i).getText().split(" ");
			//System.out.println(name[i].trim());

			List<String> itemsneeded = Arrays.asList(items);

			if(itemsneeded.contains(name)) {
				hp.addtocart();
			}
			else {
				System.out.println(hp.addcart);	
				
			}
			
				
		}
	}
	
	@Test(dataProvider="getData")

			public void loginsuccessvalidation(HashMap<String, String> map) throws InterruptedException {
			lp=new Landingpage(driver);
			hp=new Homepage(driver);

			lp.userlogin(map.get("email"));
			lp.pwdlogin(map.get("pwd"));
			lp.clickloginbutton();
			lp.cleardata();
			if (lp.errorvalidation()) {
	            System.out.println("Invalid email format error is displayed.");
	            
	        } else if(lp.blankerror()){
	            System.out.println("Blank email error is displayed.");
	            // Perform actions if the error message is not displayed
	        }
	        else {
	        	System.out.println("Blank email error is not displayed.");

	        }
			
			
				}
	}















