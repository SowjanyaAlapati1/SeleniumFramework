package com.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testcomponents.BaseTest;

import Com.Reusablemethods.Reusablemethods;
import project.Pageobjects.Homepage;
import project.Pageobjects.Landingpage;

public class Homepagetest extends BaseTest {
	Homepage hp;
	Landingpage lp;
	Reusablemethods methods;

	@Test(dataProvider = "getData", groups= {"regression"})
	public void landingpage(HashMap<String, String> map) throws InterruptedException, IOException {

		hp=new Homepage(driver);
		lp=new Landingpage(driver);
		methods=new Reusablemethods(driver);


		lp.userlogin(map.get("email"));	
		lp.pwdlogin(map.get("pwd"));
		lp.clickloginbutton();
		methods.elementvisibility(lp.ZARA);
		System.out.println("Test passed");


		hp.addtocart();
		hp.clickorders();
		hp.backtocart();
		hp.checkout();
		hp.countryselection("India");
		hp.orderplaced();
		hp.signoutpage();
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "sowjanyakalluri96@gmail.com");
		map.put("pwd", "Sowjanya@123");


		//		HashMap<String, String> map2=new HashMap<String, String>();
		//		map2.put("email", "sowjnayaklluri96@gmail.com");
		//		map2.put("pwd", "");
		return new Object[][] {{map}};


	}
}
