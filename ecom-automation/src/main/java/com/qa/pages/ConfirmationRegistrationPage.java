package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ConfirmationRegistrationPage {
	WebDriver driver;

	By continueBtn = By.xpath("//a[text() = 'Continue']");

	public ConfirmationRegistrationPage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("Your Account Has Been Created!")) {
			throw new IllegalStateException(
					"This is not ConfirmationRegistration Page," + " current page is: " + driver.getCurrentUrl());
		}

	}

	public MyAccountPage goToMyAccount() {
		driver.findElement(continueBtn).click();
		return new MyAccountPage(driver);
	}

}
