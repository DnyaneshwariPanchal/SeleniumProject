package com.orgHrm.Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.orgHrm.Pages.myinfo.ContactDetailPage;
import com.orgHrm.Pages.myinfo.PersonalDetailPage;
import com.orgHrm.Pages.myinfo.SalaryPage;
import com.orgHrm.base.PredefinedAction;

public class DashBoardPage extends PredefinedAction {

	
	
	public boolean isTopbarTitleDisplayed() {
		//return driver.findElement(By.className("oxd-topbar-header-title")).isDisplayed();
		WebElement e=getElement(Locator.CLASSNAME,"oxd-topbar-header-title", false);
		return e.isDisplayed();
		
	}

	public int noOfWidgets() {
//		List<WebElement> widgets = driver.findElements(
//				By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']"));
//		return widgets.size();
		
		List<WebElement> listofWidget=getAllElement(Locator.XPATH, "//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']", false);
         return listofWidget.size();
	}

	public List<String> getWidgetHeaderTest() {

//		List<String> listofWidgetText = new ArrayList<String>();
//		List<WebElement> listofWidget = driver.findElements(By.xpath(
//				"//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']//div[@class='orangehrm-dashboard-widget-name']/p"));
//		for (WebElement widgetText : listofWidget) {
//			listofWidgetText.add(widgetText.getText());
//		}
		List<String> listofWidgetText=listOfAllElementText(Locator.XPATH,"//div[@class='oxd-grid-item oxd-grid-item--gutters orangehrm-dashboard-widget']//div[@class='orangehrm-dashboard-widget-name']/p", false);
		return listofWidgetText;
	}

	public PersonalDetailPage clickOnMyInfoPage() {
		//driver.findElement(By.xpath("//span[text()='My Info']")).click();
		// driver.findElement(By.xpath("//span[contains(text(),'My Info')]")).click();
		
		WebElement e=getElement(Locator.XPATH, "//span[text()='My Info']", false);
		e.click();
		return new PersonalDetailPage();
	}
	
	public ContactDetailPage clickOnContactDetailPage() {
		//driver.findElement(By.xpath("//a[text()='Contact Details']")).click();
		// driver.findElement(By.xpath("//span[contains(text(),'My Info')]")).click();
		
		WebElement e=getElement(Locator.XPATH, "//a[text()='Contact Details']", false);
		e.click();
		return new ContactDetailPage();
	}
	
	
	public SalaryPage clickOnSalaryPage() {
		driver.findElement(By.xpath("//a[text()='Salary']")).click();
		return new SalaryPage();
		
	}
	
}
