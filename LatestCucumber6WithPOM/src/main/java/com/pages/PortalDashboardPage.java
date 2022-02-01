package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalDashboardPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By processTabs= By.cssSelector(".col-12.col-md-4");
	private By header = By.xpath("//header/app-navbar[1]/nav[1]/div[1]/a");
	private By dashboard = By.linkText("Dashboard");
	

	
	// 2. Constructor of the page class:
	public PortalDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:
	/*public String getLoginPageTitle() {
		return driver.getTitle();
	}*/
	
	
	public List<WebElement> getProcess() {
		return driver.findElements(processTabs);
	}

	public List<WebElement> getHeader() {
		return driver.findElements(header);
	}
	
	public WebElement getDashboard() {
		return driver.findElement(dashboard);
	}
	


	

}
