package com.qa.pages.otherExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegPageOneElement {
	WebDriver driver;
	
	private static WebElement element = null;
	
	public RegPageOneElement(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement firstName() {
		return driver.findElement(By.id("input-firstname"));
	}

}
