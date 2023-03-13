package com.qa.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.data.DataClass;
import com.qa.pages.Site;
import com.qa.util.Utils;
import com.qa.util.ExcelObject;
import com.relevantcodes.extentreports.LogStatus;

public class EcomTest extends BaseTest {

//	---------------------------------------------------------------/

	@Test(priority = 0, enabled = false)
	public void titleTest() {
		boolean result = false;

		try {
			test.log(LogStatus.INFO, "Verify Title of Ecom site");
			Site.goToHomePage(driver);
			result = true;
			test.log(LogStatus.PASS, "Title is as expected - Passed");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Title is as expected - Failed");
			e.printStackTrace();

		}
		assertTrue(result);

	}

	@Test(priority = 1, enabled = false)
	public void footerLinkTest() {
		boolean result = false;

		try {
			test.log(LogStatus.INFO, "Verify footer link of Ecommerce Home Page");
			Site.goToHomePage(driver).goToContactUs();
			result = true;
			test.log(LogStatus.PASS, "Footer is as expected - Passed");

		} catch (Exception e) {
			Utils.takeSnapshot(driver, test);
			test.log(LogStatus.FAIL, "Footer is as expected - Failed");
			e.printStackTrace();
		}
		assertTrue(result);
	}

	@Test(priority = 2, enabled = false, dataProvider = "registrationData")
	public void registerNewUserTest(String fName, String lName, String email, String phone, String password) {
		
		boolean result = false;

		try {
			test.log(LogStatus.INFO, "Verify reistration process of a new user");
			Site.goToRegistrationPage(driver).registerAsNewUser(fName, lName, email, phone, password);
			result = true;
			test.log(LogStatus.PASS, "Registration of a new user - Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Registration of a new user - Failed");
			Utils.takeSnapshot(driver, test);
			e.printStackTrace();
			log.error("ERROR OCCURED WHEN REGISTERING NEW USER!");
		}
		assertTrue(result);

	}

	@Test(priority = 3, enabled = false, dataProvider = "registrationData")
	public void registerExistingUserTest(String fName, String lName, String email, String phone, String password) {

		boolean result = false;
		try {
			test.log(LogStatus.INFO, "Verify registration process of the existing user of Ecom site");
			Site.goToRegistrationPage(driver).registerAsExistingUser(fName, lName, email, phone, password);
			result = true;
			test.log(LogStatus.PASS, "Registration of an existing user - Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Registration of an existing user - Failed");
			Utils.takeSnapshot(driver, test);
			e.printStackTrace();
			log.error("ERROR OCCURED WHEN REGISTERING EXISTING USER!");
		}
		assertTrue(result);
	}

	@Test(priority = 4, enabled = true, dataProvider = "loginData")
	public void login(String fName, String lName) {

		boolean result = false;

		try {
			test.log(LogStatus.INFO, "Verify login process of the existing user of Ecom site");
			Site.goToLoginPage(driver).login(fName, lName);
			result = true;
			test.log(LogStatus.PASS, "Login - Passed");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login - Failed");
			Utils.takeSnapshot(driver, test);
			e.printStackTrace();
			log.error("ERROR OCCURED WHEN LOGGING IN!");
		}

		assertTrue(result);

	}

//	***********Data Providers**********************

	@DataProvider(name = "registrationData")
	public Object[][] registrationData() throws IOException {
		return new ExcelObject(rootPath + DataClass.TESTDATA_FILE, DataClass.REGISTRATION_DATA_SHEET).getData();
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		return new ExcelObject(rootPath + DataClass.TESTDATA_FILE, DataClass.LOGIN_DATA_SHEET).getData();
		
	}

}
