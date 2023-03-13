package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
	WebDriver driver;

	By continueBtn = By.xpath("//a[text()='Continue']");

	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("Order History")) {
			throw new IllegalStateException(
					"This is not Order History Page," + " current page is: " + driver.getCurrentUrl());
		}
	}

	public MyAccountPage returnToMyAccount() {
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);

	}

}
