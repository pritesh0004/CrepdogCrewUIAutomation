package com.qa.crepdogcrew.base;

import java.util.Properties;

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
	public Properties prop;

	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_properties();
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
