package com.crmqa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentRepo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetname = "contacts";
	
	
	public ContactsPageTest() {
		
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
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() throws InterruptedException {
		
		contactsPage.selectContactsBy("harry john Joe");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() throws InterruptedException {	
		
		contactsPage.selectContactsBy("harry john Joe");
		contactsPage.selectContactsBy("Dan Reck");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {		
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData") 
	public void validateCreateNewContact(String firstName, String lastName, String company) {
		
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(firstName, lastName, company);		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
