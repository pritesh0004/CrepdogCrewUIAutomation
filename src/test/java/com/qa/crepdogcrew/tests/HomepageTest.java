package com.qa.crepdogcrew.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.crepdogcrew.base.BaseTest;

public class HomepageTest extends BaseTest{

	@Test
	public void isCrepdogCrewDashboardLogoDisplayedTest() {
		boolean flag = homePage.isCrepdogCrewDashboardLogoDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void isCorrectCrepdogCrewDashboardTitleTest() {
		String actualTitle = homePage.isCorrectCrepdogCrewDashboardTitle();
		Assert.assertEquals(actualTitle, "Get Limited Edition Sneakers & Streetwear in India | Crepdog Crew");
	}

}
