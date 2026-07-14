package com.qa.crepdogcrew.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
	@Parameters({"browser"})
	public void setUp(@Optional String browserName) {
		df = new DriverFactory();
		prop = df.init_properties();
		if(browserName!= null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		homePage = new HomePage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}

}
