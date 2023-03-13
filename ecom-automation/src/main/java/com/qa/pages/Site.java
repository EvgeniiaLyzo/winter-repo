package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Site {
	public static final String BASE_URL = "https://naveenautomationlabs.com/opencart/index.php?route=";

	public static HomePage goToHomePage(WebDriver driver) {
		driver.get(BASE_URL + "common/home");
		return new HomePage(driver);
	}

	public static RegistrationPage goToRegistrationPage(WebDriver driver) {
		driver.get(BASE_URL + "account/register");
		return new RegistrationPage(driver);
	}
	
	public static LoginPage goToLoginPage(WebDriver driver) {
		driver.get(BASE_URL + "account/login");
		return new LoginPage(driver);
	}
	
	public static MyAccountPage goToMyAccountPage(WebDriver driver, String email, String password) {
		try {
		driver.get(BASE_URL + "account/account");
		return new MyAccountPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			return goToLoginPage(driver).login(email, password);
			return new LoginPage(driver).login(email, password);		

		}
	}
	
	public static OrderHistoryPage goToOrderHistoryPage(WebDriver driver, String email, String password) {
		try {
		driver.get(BASE_URL + "account/account");
		return new OrderHistoryPage(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return goToMyAccountPage(driver, email, password).goToviewOrderHistory();		
		}
	}
	
	
	
//	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		goToMyAccountPage(driver, "eve@gmail.com", "123123");
//	}
//	
	

}
