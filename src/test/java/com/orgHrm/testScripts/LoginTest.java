package com.orgHrm.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orgHrm.Pages.LoginPage;
import com.orgHrm.base.PredefinedAction;

public class LoginTest {

	@Test
	public void loginOrgHrm() {

		PredefinedAction.setup();
		LoginPage loginPage = new LoginPage();
		loginPage.enterUsername("Admin");
		String actualUsername = loginPage.getUsername();
		Assert.assertEquals(actualUsername, "Admin");
		loginPage.enterPassword("admin123");
		String actualPassword = loginPage.getPassword();
		Assert.assertEquals(actualPassword, "admin123");
		loginPage.isLoginButtonDisplayed();

		loginPage.clickLoginButton();
		System.out.println("URL Contain DashBoARD");
		Assert.assertTrue(loginPage.getCurrentUrl().contains("dashboard"));
		// LoginPage.closeBrowser();

	}
}
