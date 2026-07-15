package com.qa.crepdogcrew.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.crepdogcrew.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Design Homepage Page Functionality")
@Feature("Test Homepage Functionality")
@Story("Test Homepage Logo and Title")
public class HomepageTest extends BaseTest{

	@Description("Valiate Homepage Logo Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void isCrepdogCrewDashboardLogoDisplayedTest() {
		boolean flag = homePage.isCrepdogCrewDashboardLogoDisplayed();
		Assert.assertTrue(flag);
	}

	@Description("Valiate Homepage Title Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void isCorrectCrepdogCrewDashboardTitleTest() {
		String actualTitle = homePage.isCorrectCrepdogCrewDashboardTitle();
		Assert.assertEquals(actualTitle, "Get Limited Edition Sneakers & Streetwear in India | Crepdog Crew");
	}

}
