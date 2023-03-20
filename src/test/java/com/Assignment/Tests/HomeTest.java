package com.Assignment.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Assignment.Base.TestBase;
import com.Assignment.Pages.HomePage;
import com.Assignment.Utils.Utils;
import com.Assignment.Utils.Utils.NameRecord;

public class HomeTest extends TestBase {
	private HomePage homePage;
	private SoftAssert softAssert;
	private int sizeOfListGroup = 3;
	private String emailInput = "email123@gmail.com";
	private String passwordInput = "Password1";
	private String textOfListItem2 = "List Item 2";
	private String badgeValueOfListItem2 = "6";
	private String defaultDropdownValue = "Option 1";
	private String dropdownValue = "Option 3";

	@BeforeMethod
	public void setUp() {
		launchBrowser();
		homePage = new HomePage();
		softAssert = new SoftAssert();
	}

	@Test
	public void test1_validateLogin() {
		homePage.inputLoginCredentials(emailInput, passwordInput);

		// validating if values in email and password field are present
		softAssert.assertEquals(homePage.getValueFromEmail(), "email123@gmail.com", "email input not present");
		softAssert.assertEquals(homePage.getValueFromPassword(), "Password1", "password not present");

		// validating if submit button is displayed
		softAssert.assertTrue(homePage.isSignInButtonDisplayed(), "SignIn button not displayed");
		softAssert.assertAll();
	}

	@Test
	public void test2_validateListGroup() {
		// validate if list group contains 3 elements
		softAssert.assertEquals(homePage.getSizeOfListGroup(), sizeOfListGroup);

		// validate text of list item 2
		softAssert.assertEquals(homePage.getTextFromListItem2(), textOfListItem2, "text doesn't match");

		// validate badge value of list item 2
		softAssert.assertEquals(homePage.getBadgeValueOfListItem2(), badgeValueOfListItem2,
				"badge value doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void test3_validateDropdownOptions() {

		// validate default value of dropdown
		softAssert.assertEquals(homePage.getDefaultTextFromDropDown(), defaultDropdownValue,
				"default value doesn't match");
		homePage.selectDropDownValue(dropdownValue);

		// validate option 3 is selected
		softAssert.assertEquals(homePage.selectDropDownValue(dropdownValue), dropdownValue,
				" selected option doesn't match");
		softAssert.assertAll();
	}

	@Test
	public void test4_validateButtonisEnabledOrDisabled() {
		// validate if primary button is enabled
		softAssert.assertTrue(homePage.verifyIfPrimaryButtonIsEnabled(), "primary button is not enabled");

		// validate if secondary button is disabled
		softAssert.assertFalse(homePage.verifyIfSecondaryButtonIsDisabled(), "secondary button is not disabled");
		softAssert.assertAll();
	}

	@Test
	public void test5_validateSuccessMessageOnButtonClick() {
		homePage.clickTest5Button();

		// validate success message after click
		softAssert.assertEquals(homePage.getTextFromSuccessMessage(), "You clicked a button!",
				"success message not displayed");

		// validate if button is disabled after click
		softAssert.assertFalse(homePage.verifyIfTest5ButtonIsDisabled(), "Button is not disabled");
		softAssert.assertAll();
	}

	@Test
	public void test6_validateCellValue() {
		By by = By.cssSelector("table.table.table-bordered.table-dark tbody tr");

		// validate cell value
		softAssert.assertEquals(Utils.getElementFromTheGrid("Thadeus", NameRecord.APPNAME, by).getText(), "Ventosanzap",
				"app name doesn't match");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		quitBrowser();
	}
}
