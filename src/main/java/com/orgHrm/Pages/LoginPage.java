package com.orgHrm.Pages;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orgHrm.Util.PropOperation;
import com.orgHrm.base.PredefinedAction;
import com.orgHrm.constant.Constant;

public class LoginPage extends PredefinedAction {

	private PropOperation propOperation;

	public LoginPage() {

		try {
			propOperation = new PropOperation(Constant.LoginPageLocator);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Login Locator file is not Present LoginPage.properties");
			e.printStackTrace();
		}

	}

	public boolean isLoginButtonDisplayed() {

		try {
				
			WebElement LoginButton=getElement(propOperation.getvalue("LoginButton"), false);
			return LoginButton.isDisplayed();
		} catch (NoSuchElementException ne) {
			return false;
		}
	}

	public boolean isLoginPanelDisplayed() {
//		try {
//			WebElement e=getElement("./src/com/orgHrm/Config/LoginPage.properties", false);
//			return e.isDisplayed();
//		} catch (NoSuchElementException ne) {
//			return false;
//		}
		return true;//isElementDisplayed(propOperation.getvalue("loginPanel"),false);
	}

	public void enterUsername(String username) {
		setText(propOperation.getvalue("username"), false, username);
	}

	public void enterPassword(String password) {
		setText(propOperation.getvalue("password"), false, password);
	}

	public void clickLoginButton() {
		clickOnElement(propOperation.getvalue("LoginButton"),false);
	}

	public void Login(String Username, String password) {
		enterUsername(Username);
		enterPassword(password);
		clickLoginButton();

	}

	public String getUsername() {
		return driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");

	}

	public String getPassword() {
		return driver.findElement(By.xpath("//input[@name='password']")).getAttribute("value");
	}

}
