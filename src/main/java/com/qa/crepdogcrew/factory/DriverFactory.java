package com.qa.crepdogcrew.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	public WebDriver driver;

	public WebDriver initDriver(String browserName) {
		switch (browserName) {
		case "chrome": {
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		case "edge": {
			driver = new EdgeDriver();
			break;
		}
		case "safari": {
			driver = new SafariDriver();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserName);
		}
		driver.get("https://crepdogcrew.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;

	}

}
