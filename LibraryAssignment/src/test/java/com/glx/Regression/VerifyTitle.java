package com.glx.Regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle {
	
	@Test
	public void VerifyTitleTest(){
		System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/Ambuj/");
		Assert.assertTrue(driver.getTitle().contains("GalaxE Home"));
	}
}
