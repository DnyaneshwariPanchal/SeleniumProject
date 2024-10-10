package com.orgHrm.Pages.myinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orgHrm.base.PredefinedAction;

public class SalaryPage extends PredefinedAction {
	
	public boolean isSalaryPageLoaded() {
		WebElement salaryPage = driver.findElement(By.xpath("//div[@class='orangehrm-container']"));
		return salaryPage.isDisplayed();
	}
}
