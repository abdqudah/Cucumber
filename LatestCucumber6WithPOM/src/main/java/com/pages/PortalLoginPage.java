package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalLoginPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By userName = By.id("qid");
	private By userNameLabel = By.xpath("//label[contains(text(),'رقم الهوية')]");
	private By establishment_id = By.id("eid");
	private By password = By.id("password");
	private By login_button = By.tagName("button");
	private By forgot_Password = By.linkText("ﻫﻞ ﻧﺴﻴﺖ ﻛﻠﻤﺔ اﻟﺴﺮ؟");
	private By account_Name= By.xpath("//a[contains(text(),'mol_admin')]");
	private By english_Button= By.xpath("//div[contains(text(),'English')]");
	private By password_Label= By.xpath("//label[contains(text(),'Password')]");
	private By error_Toast_Message_Login = By.xpath("//div[@id='toast-container']");
	private By otp = By.xpath("//input[@id='otp']");
	private By submit_OTP_Button= By.xpath("//button[contains(text(),'تقديم')]");
	private By back_To_Login_Page_Link = By.linkText("الرجوع الى شاشة الدخول");
	private By logout_Button = By.xpath("//header/app-navbar[1]/nav[1]/div[1]/div[1]/a[2]");
		

	
	// 2. Constructor of the page class:
	public PortalLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	/*public String getLoginPageTitle() {
		return driver.getTitle();
	}*/
	
	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	
	public WebElement getUserNameLabel() {
		return driver.findElement(userNameLabel);
	}
	
	public WebElement getEstablishmentId() {
		return driver.findElement(establishment_id);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(login_button);
	}

	public WebElement getForgotPassword() {
		return driver.findElement(forgot_Password);
	}
	
	public WebElement getAccountName() {
		return driver.findElement(account_Name);
	}
	
	public WebElement getEnglishButton() {
		return driver.findElement(english_Button);
	}
	
	public WebElement getPasswordLabel() {
		return driver.findElement(password_Label);
	}
	
	public WebElement getErrorToastMessage() {
		return driver.findElement(error_Toast_Message_Login);
	}
	
	public WebElement getOtp() {
		return driver.findElement(otp);
	}
	
	public WebElement getSubmitOtpButton() {
		return driver.findElement(submit_OTP_Button);
	}
	
	public WebElement getBackToLoginPageLink() {
		return driver.findElement(back_To_Login_Page_Link);
	}
	
	public WebElement getLogout() {
		return driver.findElement(logout_Button);
	}
	
	
	
	/*public WebElement getUserName() {
		return driver.findElement(userName);
	}
	public WebElement getEstablishmentId() {
		return driver.findElement(establishment_id);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(login_button);
	}

	public WebElement getForgotPassword() {
		return driver.findElement(forgot_Password);
	}*/
	
	/*public boolean isForgotPwdLinkExist() {
	
	return driver.findElement(forgot_Password).isDisplayed();
}*/


	public AccountsPage doLogin(String un,String esitID, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(userName).sendKeys(un);
		driver.findElement(establishment_id).sendKeys(esitID);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login_button).click();
		return new AccountsPage(driver);
	}

}
