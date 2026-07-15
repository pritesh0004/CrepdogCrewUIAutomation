package com.qa.crepdogcrew.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.crepdogcrew.base.BaseTest;
import com.qa.crepdogcrew.utils.CsvUtil;
import com.qa.crepdogcrew.utils.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Design Sign In Page Functionality")
@Feature("Test Sign In Functionality")
@Story("Test Sign In Title , Header and Email Field")
public class LoginpageTest extends BaseTest {

	@BeforeClass
	public void prerequisitesOfSigninPage() {
		loginPage = homePage.isSigninLinkWorking();
	}

	@Description("Valiate Sign In Title Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void isCorrectCrepdogCrewSigninTitleTest() {
		String actualTitle = loginPage.isCorrectCrepdogCrewDigninTitle();
		Assert.assertEquals(actualTitle, "Sign in - Crepdog Crew");
	}

	@Description("Valiate Sign In Header Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
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

	@Description("Valiate Sign In Email Field Error Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test(dataProvider = "getEmailAddressFromExcel")
	public void isCrepdogCrewDigninEmailFieldErrorMessageCorrectTest(String emailAddress) {
		String actualError = loginPage.isCrepdogCrewDigninEmailFieldErrorMessageCorrect(emailAddress);
		Assert.assertEquals(actualError, "Enter a valid email address");
	}

}