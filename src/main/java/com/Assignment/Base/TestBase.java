package com.Assignment.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;

	public void launchBrowser() {
		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Not a valid browser");
			break;
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// Manage the page load timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// Manage the script load timeout
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		// Launch a page
		driver.get("C:/Users/kaurh/Downloads/QE-index.html");

	}

	public void quitBrowser() {
		// closing the browser
		driver.close();
	}

}
