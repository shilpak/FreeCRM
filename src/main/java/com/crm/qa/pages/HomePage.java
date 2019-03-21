package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[@class='user-display' and contains(text(), 'Shilpa Kothari')]")
	WebElement userNameLabel;

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newcontactlink;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath="//div[@id='main-nav']//a[@class='item active']")
	WebElement taskslink;

	public HomePage() {		
		//here 'this' means current class object
		PageFactory.initElements(driver,  this);
	}

	//Actions
	public String validateLoginPageTitle() {
		return  driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLink() {
		contactlink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		taskslink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		newcontactlink.click();
	}
	
	

}
