package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By emailTxb = By.id("input-email");
	By passwordTxb = By.id("input-password");
	By loginBtn = By.xpath("//input[@value='Login']");
	By continueBtn = By.xpath("//a[text()='Continue']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		if (!driver.getTitle().equals("Account Login")) {
			throw new IllegalStateException(
					"This is not Login Page," + " current page is: " + driver.getCurrentUrl());
		}
	}
	
	public MyAccountPage login(String email, String password) {
		
		try {
		driver.findElement(emailTxb).sendKeys(email);
		driver.findElement(this.passwordTxb).sendKeys(password);
		driver.findElement(loginBtn).click();
		return new MyAccountPage(driver);
		
		} catch (Exception e) {
			System.out.println("Problem occured when logging in");
			throw(e);
		}
			
	}
	
	public RegistrationPage goToRegistrationPage() {
		try {
			driver.findElement(continueBtn).click();
			return new RegistrationPage(driver);
		} catch (NoSuchElementException e) {
			System.out.println("Problem occured when going to RegPage");
			throw(e);
		}
	}
}
