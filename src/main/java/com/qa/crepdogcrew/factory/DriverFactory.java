package com.qa.crepdogcrew.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	public OptionsManager optionsManager;

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		optionsManager = new OptionsManager(prop);
		System.out.println("Browser Name is : "+browserName);
		switch (browserName) {
		case "chrome": {
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.chromeOptions()));
			break;
		}
		case "firefox": {
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.firefoxOptions()));
			break;
		}
		case "edge": {
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver(optionsManager.edgeOptions()));
			break;
		}
		case "safari": {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName);
		}
		getDriver().get(prop.getProperty("url"));
		//getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return getDriver();

	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public Properties init_properties() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;

	}
	/*
	 * Take the screenshot
	 */
	public File takeScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		return srcFile;
	}

}
