package com.qa.crepdogcrew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	private final By crepdogCrewDashboardLogo = By.cssSelector("img.header__logo-image");
	private final By crepdogCrewDashboardSignIn = By.xpath("//a[@class='tap-area sm:block']");
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCrepdogCrewDashboardLogoDisplayed() {
		return driver.findElement(crepdogCrewDashboardLogo).isDisplayed();
	}

	public String isCorrectCrepdogCrewDashboardTitle() {
		return driver.getTitle();
	}
	
	public LoginPage isSigninLinkWorking() {
		driver.findElement(crepdogCrewDashboardSignIn).click();
		return new LoginPage(driver);
		
	}

}



