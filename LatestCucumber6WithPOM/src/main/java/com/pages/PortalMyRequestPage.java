package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalMyRequestPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By myRequest = By.linkText("طلباتي");
	
	

	
	// 2. Constructor of the page class:
	public PortalMyRequestPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	/*public String getLoginPageTitle() {
		return driver.getTitle();
	}*/
	
	public WebElement getMyRequest() {
		return driver.findElement(myRequest);
	}
	
	
	


	

}
