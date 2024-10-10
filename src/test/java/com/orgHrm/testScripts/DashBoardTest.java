package com.orgHrm.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.orgHrm.Pages.DashBoardPage;
import com.orgHrm.Pages.LoginPage;
import com.orgHrm.base.PredefinedAction;

public class DashBoardTest extends TestBase{
	
	@BeforeClass
	public void setUp() {
		String username="admin";
		String password="admin123";
		
		PredefinedAction.setup();
		LoginPage loginPage=new LoginPage();
		loginPage.Login(username, password);
	}
	
	@Test
	public void widgetText() {
		DashBoardPage db=new DashBoardPage();
		int actualWidgetSize=db.noOfWidgets();
		int ExpectedWidgetSize=7;
		Assert.assertEquals(actualWidgetSize, ExpectedWidgetSize);
	}
	
//	@AfterClass
//	public void tearDown() {
//		PredefinedAction.closeBrowser();
//	
//	}

}
