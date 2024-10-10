package com.orgHrm.testScripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.orgHrm.Pages.LoginPage;
import com.orgHrm.base.PredefinedAction;

public class TestBase {

	@BeforeClass
	public void loginToBrowser() {
		PredefinedAction.setup();	
		String username="admin";
		String password="admin123";
		LoginPage loginPage=new LoginPage();
		loginPage.Login(username, password);
	}
	
	@BeforeClass
	public void setUp() {
		
	}
	
	@AfterClass
	public void tearDown() {
		PredefinedAction.closeBrowser();
	}
}
