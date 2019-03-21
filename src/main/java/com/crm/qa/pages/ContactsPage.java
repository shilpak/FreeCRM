package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.CacheLookup;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstNameLabel;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastNameLabel;
	
	@FindBy(xpath="//div[@name='company']//input[@type='text']")
	WebElement companyLabel;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	
	
	//Initializing the page objects
	public ContactsPage() {		
		//here 'this' means current class object
		PageFactory.initElements(driver,  this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsBy(String name) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//div//input[@name='id']")).click();
	}
	
	public void createNewContact(String ftName, String ltname, String comp) {
		firstNameLabel.sendKeys(ftName);
		lastNameLabel.sendKeys(ltname);
		companyLabel.sendKeys(comp);
		saveButton.click();
	}
	
}
////*[@name='client_lookup']//following-sibling::input[@value='Lookup']