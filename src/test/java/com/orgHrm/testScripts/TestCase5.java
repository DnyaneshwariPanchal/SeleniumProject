package com.orgHrm.testScripts;

import org.testng.Assert;

import com.orgHrm.Pages.DashBoardPage;
import com.orgHrm.Pages.myinfo.PersonalDetailPage;

public class TestCase5 extends TestBase {
	
	public void testcase4() {
		System.out.println("Step-Click on My Info ");
		DashBoardPage db= new DashBoardPage();
		PersonalDetailPage personalDetailPage=db.clickOnMyInfoPage();
		
		System.out.println("VERIFY- Personal detail Page displayed");
		boolean isPersonalDetailVisibleFlag=personalDetailPage.isPersonalDetailPageVisible();
		Assert.assertTrue(isPersonalDetailVisibleFlag);
		
		
	}

}
