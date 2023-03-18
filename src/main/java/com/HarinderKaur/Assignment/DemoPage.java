package com.HarinderKaur.Assignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoPage extends TestBase {

	public DemoPage() {
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
	
	@FindBy(css="#test-4-div button.btn-primary")
	WebElement primaryButton;
	
	@FindBy(css="#test-4-div button.btn-secondary")
	WebElement secondaryButton;
	
	@FindBy(css="button[id='test5-button']")
	WebElement test5Button;
		

	public void enterEmailInputField(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPasswordInputField(String password) {
		passwordInputField.sendKeys(password);
	}

	public void login(String email, String password) {
		enterEmailInputField(email);
		enterPasswordInputField(password);
		signInButton.submit();
	}

	public String getTextFromListItem2() {
		return listItem2.getText();
	}

	public String getTextFromDropDown() {
		return dropDown.getText();
	}

	public void selectDropDownValue(String option3) {
		Select sc = new Select(dropDown);
		sc.selectByVisibleText(option3);
	}
	
	public void verifyIfPrimaryButtonEnabled() {
		
		boolean isPrimaryButtonEnabled= primaryButton.isEnabled();
		boolean isSecondaryButtonDisabled = secondaryButton.isEnabled();
		
	}
}
