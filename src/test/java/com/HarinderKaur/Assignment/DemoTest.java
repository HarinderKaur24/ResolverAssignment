package com.HarinderKaur.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HarinderKaur.Assignment.Test6Page.NameRecord;

public class DemoTest {
	WebDriver driver;
	WebDriverWait wdWait;
	Test6Page test6Page;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\kaurh\\OneDrive\\Documents\\Drivers\\chromedriver.exe");

		// launch a browser
		driver = new ChromeDriver();
		wdWait = new WebDriverWait(driver, 10);// explicit wait

		// launch a page
		driver.get(" ");
	}

	@Test
	public void test1() {
		WebElement emailInputField = driver.findElement(By.cssSelector("input[type='email']"));
		WebElement passwordInputField = driver.findElement(By.cssSelector("input[type='password']"));
		WebElement signInButton = driver.findElement(By.cssSelector("button[type='submit']"));
		
		emailInputField.sendKeys("email123@gmail.com");
		passwordInputField.sendKeys("Password1");
		
		String emailInput= emailInputField.getAttribute("value");
		String passwordInput = passwordInputField.getAttribute("value");
		boolean isSignInButtonDisplayed = signInButton.isDisplayed();
		
		//validating if values in email and password field are present		
		Assert.assertEquals(emailInput, "email123@gmail.com","email input not present");
		Assert.assertEquals(passwordInput, "Password1","password not present");
		
		//validating if submit button is displayed
		Assert.assertTrue(isSignInButtonDisplayed);
		signInButton.submit();
		
	}

	@Test
	public void test2() {
		List<WebElement> allListElements = driver.findElements(By.cssSelector("ul.list-group"));
		WebElement listItem2 = driver.findElement(By.cssSelector("#test-2-div li:nth-of-type(2)"));
		WebElement listItem2BadgeValue = driver.findElement(By.cssSelector("#test-2-div li:nth-of-type(2) span"));
		
		//validating if list group contains 3 elements
		Assert.assertEquals(allListElements.size(), 3);
		
		//validating text of list item 2
		Assert.assertEquals(listItem2.getText(), "List Item 2","text doesn't match");
		
		//validating badge value of list item 2
		Assert.assertEquals(listItem2BadgeValue.getText(), "6","badge value doesn't match");

	}

	@Test
	public void test3() {
		
		WebElement dropDown= driver.findElement(By.cssSelector("button[id='dropdownMenuButton']"));
		Assert.assertEquals(dropDown.getText(), "Option 1","default value doesn't match");
		Select sc= new Select(dropDown);
		sc.selectByVisibleText("Option 3");
	
	}

	@Test
	public void test4() {
		//validating if primary button is enabled 
		// and secondary button is disabled
		WebElement primaryButton = driver.findElement(By.cssSelector("#test-4-div button.btn-primary"));
		WebElement secondaryButton = driver.findElement(By.cssSelector("#test-4-div button.btn-secondary"));
		boolean isPrimaryButtonEnabled = primaryButton.isEnabled();
		boolean isSecondaryButtonEnabled = secondaryButton.isEnabled();
		Assert.assertTrue(isPrimaryButtonEnabled);
		Assert.assertFalse(isSecondaryButtonEnabled);

	}

	@Test
	public void test5() {
		WebElement test5Button=driver.findElement(By.cssSelector("button[id='test5-button']"));
		wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='test5-button']")));
		test5Button.click();
		
		//validating success message after click
		WebElement successMessage = driver.findElement(By.cssSelector("div[id='test5-alert']"));
		Assert.assertEquals(successMessage, "You clicked a button!");
		
		//validating if button is disabled after click
		boolean isButtonEnabled= test5Button.isEnabled();
		Assert.assertFalse(isButtonEnabled, "Button is enabled");
	}

	@Test
	public void test6() {
		Assert.assertEquals(test6Page.getElementFromTheGrid("Thadeus", NameRecord.APPNAME).getText(),
				"Ventosanzap", "app name doesn't match");		
	}

	public void tearDown() {
		driver.close(); // to close the browser after testing
	}
}
