package com.HarinderKaur.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test6Page extends TestBase {

	public WebElement getElementFromTheGrid(String firstName, NameRecord column) {

		int columnIndex = getIndexForColumn(column);
		List<WebElement> rowsInTable = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-dark tbody tr"));
		for (int i = 0; i < rowsInTable.size(); i++) {
			List<WebElement> cells = rowsInTable.get(i).findElements(By.cssSelector("td"));
			String firstNameText = cells.get(1).getText();
			if (firstNameText.equals(firstName)) {
				return cells.get(columnIndex);
			}
		}
		System.out.println("Column name was not found!!!");
		return null;
	}

	public int getIndexForColumn(NameRecord column) {
		List<WebElement> headers = driver
				.findElements(By.cssSelector("table.table.table-bordered.table-dark thead tr th"));

		for (WebElement webElement : headers) {
			String headerText = webElement.getText();
			if (headerText.equals(column.getName())) {
				return headers.indexOf(webElement);
			}
		}
		System.out.println("Column does not exist.....");
		return -1;
	}

	public enum NameRecord {

		FIRSTNAME("First Name"),
		LASTNAME("Last Name"),
		APPNAME("App Name");

		String name;

		private NameRecord(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
