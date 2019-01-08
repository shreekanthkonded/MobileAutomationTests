package com.MobileTesting.Assigments;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Senario5 
{
	public static AppiumDriver<MobileElement> driver;
	@BeforeTest
	public static void Launchapp() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "d125e0ac0703");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("paltformVersion", "7.0");
		capabilities.setCapability("appPackage", "com.july.cricinfo");
		capabilities.setCapability("appActivity", "com.espn.sportscenter.ui.LaunchActivity");
		capabilities.setCapability("noReset", "false");
		driver=new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		Thread.sleep(2000);
		String id="com.android.packageinstaller:id/permission_message"; 
		String id1="com.android.packageinstaller:id/permission_message";
		if(id.equals(id1))
		{
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		}
		Thread.sleep(3000);
		driver.findElementById("com.july.cricinfo:id/btn_sign_up_later").click();
		
	}
	
	public static void waitTime(long timings) throws InterruptedException
	{
		Thread.sleep(timings);
	}
	
	@Test(priority=1)
	public static void firstScenario() throws InterruptedException
	{
		driver.findElementById("com.july.cricinfo:id/nextText").click();
		waitTime(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='IPL']").click();
		waitTime(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Chennai Super Kings']").click();
		waitTime(2000);
		driver.findElementById("com.july.cricinfo:id/nextText").click();
		waitTime(5000);
		/*driver.findElementByXPath("//android.widget.TextView[@text='CSK']").click();
		waitTime(2000);*/
	}
	
	@Test(priority=2)
	public static void SearchIcon() throws InterruptedException
	{
		driver.findElementByXPath("//*[@content-desc='Search']").click();
		waitTime(2000);
		driver.findElementById("com.july.cricinfo:id/search_src_text").sendKeys("India");
		waitTime(2000);
		if(driver.findElementByXPath("//*[@text='India']").isDisplayed())
		{
			System.out.println("con is true");
		}
		else
			System.out.println("Cond is false");
	}
}
