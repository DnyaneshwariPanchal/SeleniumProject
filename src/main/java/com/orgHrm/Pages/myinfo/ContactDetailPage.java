package com.orgHrm.Pages.myinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orgHrm.base.PredefinedAction;

public class ContactDetailPage extends PredefinedAction {

	public boolean isContactDetailPageLoaded(){
		WebElement contactPage=driver.findElement(By.xpath("//form[@class='oxd-form']"));
		return contactPage.isDisplayed();
	}
}
