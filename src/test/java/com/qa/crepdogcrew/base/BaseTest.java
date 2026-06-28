package com.qa.crepdogcrew.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.crepdogcrew.factory.DriverFactory;
import com.qa.crepdogcrew.pages.HomePage;
import com.qa.crepdogcrew.pages.LoginPage;

public class BaseTest {

	public WebDriver driver;
	DriverFactory df;
	protected HomePage homePage;
	protected LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		driver = df.initDriver("chrome");
		homePage = new HomePage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
