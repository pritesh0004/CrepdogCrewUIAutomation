package com.qa.crepdogcrew.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger log = LogManager.getLogger(HomepageTest.class);

	@Description("Valiate Homepage Logo Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void isCrepdogCrewDashboardLogoDisplayedTest() {
		log.info("Starting Homepage Logo Test");
		boolean flag = homePage.isCrepdogCrewDashboardLogoDisplayed();
		Assert.assertTrue(flag);
		log.info("Homepage Logo Test Passed");
	}

	@Description("Valiate Homepage Title Test")
	@Owner("Pritesh Khambekar")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void isCorrectCrepdogCrewDashboardTitleTest() {
		log.info("Starting Homepage Title Test");
		String actualTitle = homePage.isCorrectCrepdogCrewDashboardTitle();
		Assert.assertEquals(actualTitle, "Get Limited Edition Sneakers & Streetwear in India | Crepdog Crew");
		log.info("Homepage Title Test Passed");
	}

}
