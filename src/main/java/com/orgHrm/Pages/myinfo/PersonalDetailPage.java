package com.orgHrm.Pages.myinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orgHrm.base.PredefinedAction;

public class PersonalDetailPage extends PredefinedAction {

	public boolean isPersonalDetailPageVisible() {
		return driver.findElement(By.xpath("//label[text()='Employee Full Name']")).isDisplayed();
	}

	public void findMiddleName(String username) {
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(username);

	}

	public String getMiddleName() {
		return driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value");
	}

//	public void isPersonalPageLoaded() {
//		WebElement element = wait
//				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='middleName']")));
//	}
}
