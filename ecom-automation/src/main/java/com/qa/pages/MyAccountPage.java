package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	WebDriver driver;
	
	By viewOrderHistoryLink = By.linkText("View your order history");
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getTitle().equals("My Account")) {
			throw new IllegalStateException(
					"This is not Login Page," + " current page is: " + driver.getCurrentUrl());
		}
		
	}
	
	public OrderHistoryPage goToviewOrderHistory() {
		driver.findElement(viewOrderHistoryLink).click();
		return new OrderHistoryPage(driver);
	}
	

}
