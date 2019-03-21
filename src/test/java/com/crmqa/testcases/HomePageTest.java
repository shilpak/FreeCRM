package com.crmqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	public HomePageTest() {
		
		//the super word will call the base class constructor
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		intialisation();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyCorrectUsernameTest() {
	Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}
	
	public void verifyclickOnDealsLink() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
