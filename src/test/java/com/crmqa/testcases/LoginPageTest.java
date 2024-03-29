package com.crmqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;	
	
	public LoginPageTest() {

		//calling the constructor testbase class
		super();
	}

	@BeforeMethod
	public void setUp() {
		intialisation(); 
		loginPage = new LoginPage();		
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		
	String title = loginPage.validateLoginPageTitle();
	System.out.println(title);
	
	Assert.assertEquals(title, "Free CRM software in the cloud for sales and service");
	
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean value = loginPage.validateLogo();
		Assert.assertTrue(value);
	}

	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
