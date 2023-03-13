package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	By contactUs = By.linkText("Contact Us");

	public HomePage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("Your Store")) {
			throw new IllegalStateException("This is not Home Page," + " current page is: " + driver.getCurrentUrl());
		}
	}

	public void goToContactUs() {
		driver.findElement(contactUs).click();
	}

}
