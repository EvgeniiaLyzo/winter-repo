package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utils {
	
	
	public static void takeSnapshot(WebDriver driver, ExtentTest test) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Reports/ScreenShots/" + generateScreenshotName();
		try {
			FileHandler.copy(file, new File(path));
			test.log(LogStatus.INFO, "SnapShot-->" + test.addScreenCapture(path));
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}
	
	
	public static boolean reportBaseOnElement(WebDriver driver, ExtentTest test, String xpath, Logger log) {
		try {
			driver.findElement(By.xpath(xpath));
			test.log(LogStatus.PASS, "Element FOUND");
			log.info("Element FOUND");
			takeSnapshot(driver, test);
			return true;
		} catch (NoSuchElementException e) {
			log.error("Element not found");
			log.error(e);
			test.log(LogStatus.FAIL, "Element NOT FOUND");
			takeSnapshot(driver, test);
			return false;
		}
	}
	
	public static void handleExeption(Exception e, String msgForReport, String msgForLog) {
		
	}
	
	
	
	public static String generateScreenshotName() {
		return  "ss" + String.valueOf(System.currentTimeMillis()) + ".png";
		
	}
	
	public static void generateRandomEmail() {
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
