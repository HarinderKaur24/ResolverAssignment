package com.Assignment.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Assignment.Base.TestBase;

public class HomePage extends TestBase {
	WebDriverWait wdWait = new WebDriverWait(driver, 30); // explicit wait
	Actions action = new Actions(driver);;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[type='email']")
	WebElement emailInputField;

	@FindBy(css = "input[type='password']")
	WebElement passwordInputField;

	@FindBy(css = "button[type='submit']")
	WebElement signInButton;

	@FindBy(css = "#test-2-div li:first-of-type")
	WebElement listItem1;

	@FindBy(css = "#test-2-div li:nth-of-type(2)")
	WebElement listItem2;

	@FindBy(css = "#test-2-div li:last-of-type")
	WebElement listItem3;

	@FindBy(css = "#test-2-div li:nth-of-type(2) span")
	WebElement listItem2BadgeValue;

	@FindBy(css = "button[id='dropdownMenuButton']")
	WebElement dropDown;

	@FindBy(css = "div.dropdown-menu.show a:last-of-type")
	WebElement dropdownOption3;

	@FindBy(css = "#test-4-div button.btn-primary")
	WebElement primaryButton;

	@FindBy(css = "#test-4-div button.btn-secondary")
	WebElement secondaryButton;

	@FindBy(css = "button[id='test5-button']")
	WebElement test5Button;

	@FindBy(css = "div[id='test5-alert']")
	WebElement successMessageOnClickingTest5Button;

	public void enterEmailInputField(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPasswordInputField(String password) {
		passwordInputField.sendKeys(password);
	}

	public void inputLoginCredentials(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
	}

	public void login() {
		signInButton.submit();
	}

	public String getValueFromEmail() {
		return emailInputField.getAttribute("value");
	}

	public String getValueFromPassword() {
		return passwordInputField.getAttribute("value");
	}

	public boolean isSignInButtonDisplayed() {
		return signInButton.isDisplayed();
	}

	public int getSizeOfListGroup() {
		List<WebElement> allListElements = driver.findElements(By.cssSelector("ul.list-group li"));
		return allListElements.size();
	}

	public String getTextFromListItem2() {
		String text = listItem2.getText();
		return text.substring(0, text.lastIndexOf(" "));
	}

	public String getBadgeValueOfListItem2() {
		return listItem2BadgeValue.getText();
	}

	public String getDefaultTextFromDropDown() {
		return dropDown.getText();
	}

	public String selectDropDownValue(String option3) {
		action.moveToElement(dropDown).perform();
		dropDown.click();
		wdWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id='dropdownMenuButton']")));
		dropdownOption3.click();
		return dropDown.getText();
	}

	public boolean verifyIfPrimaryButtonIsEnabled() {
		return primaryButton.isEnabled();
	}

	public boolean verifyIfSecondaryButtonIsDisabled() {
		return secondaryButton.isEnabled();
	}

	public void clickTest5Button() {
		wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='test5-button']")));
		test5Button.click();
	}

	public String getTextFromSuccessMessage() {
		return successMessageOnClickingTest5Button.getText();
	}

	public boolean verifyIfTest5ButtonIsDisabled() {
		return test5Button.isEnabled();
	}
}
