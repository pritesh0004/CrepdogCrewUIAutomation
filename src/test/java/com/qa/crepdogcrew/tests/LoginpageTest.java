package com.qa.crepdogcrew.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.crepdogcrew.base.BaseTest;
import com.qa.crepdogcrew.utils.CsvUtil;
import com.qa.crepdogcrew.utils.ExcelUtil;

public class LoginpageTest extends BaseTest {

	@BeforeClass
	public void prerequisitesOfSigninPage() {
		loginPage = homePage.isSigninLinkWorking();
	}

	@Test
	public void isCorrectCrepdogCrewSigninTitleTest() {
		String actualTitle = loginPage.isCorrectCrepdogCrewDigninTitle();
		Assert.assertEquals(actualTitle, "Sign in - Crepdog Crew");
	}

	@Test
	public void isCorrectCrepdogCrewLoginHeaderTest() {
		boolean flag = loginPage.isCorrectCrepdogCrewLoginHeader();
		Assert.assertTrue(flag);
	}

	@DataProvider
	public Object[][] setOfEmailAddress() {
		return new Object[][] { { "pritesh01@gma!l.com" }, { "pritesh02@gma!l.com" } };
	}
	
	@DataProvider
	public Object[][] getEmailAddressFromCSV() {
		return CsvUtil.csvData("csvEmailData");
	}
	
	@DataProvider
	public Object[][] getEmailAddressFromExcel() {
		return ExcelUtil.getTestData("Email");
	}

	@Test(dataProvider = "getEmailAddressFromExcel")
	public void isCrepdogCrewDigninEmailFieldErrorMessageCorrectTest(String emailAddress) {
		String actualError = loginPage.isCrepdogCrewDigninEmailFieldErrorMessageCorrect(emailAddress);
		Assert.assertEquals(actualError, "Enter a valid email address");
	}

}