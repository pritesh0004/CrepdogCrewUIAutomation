package com.qa.crepdogcrew.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private final By crepdogCrewSigninHeader = By.xpath("//span[contains(text(),'Sign in')]");
	private final By crepdogCrewSigninEmail = By.xpath("//input[@id='customer-authentication-web-email']");
	private final By crepdogCrewSigninEmailSubmit = By.xpath("(//button[@type='submit'])[1]");
	private final By crepdogCrewSigninEmailError = By.xpath("//div[@id='error-for-customer-authentication-web-email']");
	
	public String isCorrectCrepdogCrewDigninTitle() {
		return driver.getTitle();
	}
	
	public boolean isCorrectCrepdogCrewLoginHeader() {
		return driver.findElement(crepdogCrewSigninHeader).isDisplayed();
	}
	
	public String isCrepdogCrewDigninEmailFieldErrorMessageCorrect(String emailAddress) {
		driver.findElement(crepdogCrewSigninEmail).sendKeys(emailAddress);
		driver.findElement(crepdogCrewSigninEmailSubmit).click();
		driver.findElement(crepdogCrewSigninEmail).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(crepdogCrewSigninEmailError).getText();		
		
	}

}
