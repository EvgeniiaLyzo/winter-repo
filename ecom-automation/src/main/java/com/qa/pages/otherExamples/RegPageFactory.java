package com.qa.pages.otherExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// PAGE FACTORY NOT RECOMMENDED FOR USE!!!
// THIS IS FOR PURPOSE OF EXAMPLE
// JUST ADDED A COMMENT TO CHECK GIT


public class RegPageFactory {
	private WebDriver driver;
	
	public RegPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	public WebElement firstName;
	
	@FindBy(id = "input-lastname")
	public WebElement lastName;
	
	@FindBy(id = "input-email")
	public WebElement email;
	
	
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void method() {}
	
//	By firstName = By.id("input-firstname");
//	By lastName = By.id("input-lastname");
//	By email = By.id("input-email");
//	By phone = By.id("input-telephone");
//	By password = By.id("input-password");
//	By confirmPassword = By.id("input-confirm");
//	By agreeBox = By.name("agree");
//	By continueButton = By.xpath("//input[@value='Continue']");

}
