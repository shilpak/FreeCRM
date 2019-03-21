package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends TestBase {

	//Page Factory
	@FindBy(name="email")

	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	
	By firstLoginbtn = By.xpath("//span[contains(text(),'Log In')]");
	
	By loginbtn = By.xpath("//div[@class='ui fluid large blue submit button']");

	@FindBy(xpath="//*[contains(text(), 'Sign Up')]")
	WebElement signUpLink;

	@FindBy(xpath="//section[@class='bg-image bg-image-1 section-50 section-sm-80 section-lg-top-80 section-lg-bottom-326 text-center inset-left-10 inset-right-10']")
	WebElement crmbackgroundImg;

	//Initialisizing the page objects
	public LoginPage() {
		//here this means current class object
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validateLoginPageTitle() {
		return  driver.getTitle();
	}

	public boolean validateLogo() {
		return crmbackgroundImg.isDisplayed();
	}

	public HomePage login(String us, String pass){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstLoginbtn)).click();
		username.sendKeys(us);
		password.sendKeys(pass);
		//Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn)).click();
		return new HomePage();
	}


















}
