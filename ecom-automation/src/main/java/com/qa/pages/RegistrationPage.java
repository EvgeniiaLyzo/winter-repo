package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	WebDriver driver;

	String url = "https://naveenautomationlabs.com/opencart/index.php?route=account/register";
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By phone = By.id("input-telephone");
	By password = By.id("input-password");
	By confirmPswdTxb = By.id("input-confirm");
	By agreeBox = By.name("agree");
	By continueButton = By.xpath("//input[@value='Continue']");
	By emailRegistredWarning = By.xpath("//div[@class='alert alert-danger alert-dismissible']");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;

		if (!driver.getTitle().equals("Register Account")) {
			throw new IllegalStateException(
					"This is not Registration Page," + " current page is: " + driver.getCurrentUrl());
		}

	}

//	actions

	public ConfirmationRegistrationPage registerAsNewUser(String fName, String lName, String email, String phone,
			String password) {
		fillRegistrationForm(fName, lName, email, phone, password);
		return new ConfirmationRegistrationPage(driver);

	}
	
	public RegistrationPage registerAsExistingUser(String fName, String lName, String email, String phone,
			String password) {
		
		fillRegistrationForm(fName, lName, email, phone, password);
		driver.findElement(emailRegistredWarning);
		return this;

	}
	
	public void fillRegistrationForm(String fName, String lName, String email, String phone,
			String password) {
		enterFirstName(fName);
		enterLastName(lName);
		enterEmail(email);
		enterPhone(phone);
		enterPassword(password);
		confirmPassword(password);
		clickAgreeBtn();
		clickContinueBtn();		
	}

	public void enterFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void enterLastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}

	public void enterEmail(String email) {
		driver.findElement(this.email).sendKeys(email);
	}

	public void enterPhone(String phone) {
		driver.findElement(this.phone).sendKeys(phone);
	}

	public void enterPassword(String password) {
		driver.findElement(this.password).sendKeys(password);
	}

	public void confirmPassword(String password) {
		driver.findElement(this.confirmPswdTxb).sendKeys(password);
	}

	public void clickAgreeBtn() {
		driver.findElement(agreeBox).click();
	}

	public void clickContinueBtn() {
		driver.findElement(continueButton).click();
	}

}
