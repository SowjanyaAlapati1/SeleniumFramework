package com.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.testcomponents.BaseTest;

import project.Pageobjects.Landingpage;

public class ErrorvalidationsTest extends BaseTest{
	
	Landingpage landing;
	ExtentTest test;

	@Test(priority = 1)
    public void InvalidEmailFormat() throws InterruptedException {
        // Navigate to the login page
	
        landing = new Landingpage(driver);
        
        // Enter an invalid email format
        landing.userlogin("sssss");
        landing.pwdlogin("sss");
        landing.clickloginbutton();
        
        if (landing.errorvalidation()) {
            System.out.println("Invalid email format error is displayed.");
            // Perform actions if the error message is displayed
        } else {
            System.out.println("Invalid email format error is not displayed.");
            // Perform actions if the error message is not displayed
        }
        
        landing.cleardata();
        landing.userlogin("sowjanyakalluri96@gmail.com");
        landing.pwdlogin("");
        landing.clickloginbutton();

        if (landing.blankerror()) {
            System.out.println("Invalid email test passed");
            // Perform actions if the error message is displayed
        } else {
            System.out.println("Blank email error is not displayed.");
            // Perform actions if the error message is not displayed
        }


       
    }
    }
	




