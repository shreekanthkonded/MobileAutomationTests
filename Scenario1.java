package com.MobileTesting.Assigments;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Scenario1 {
	
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
	public  void Verify() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text='Series']").click();
		waitTime(2000);
		MobileElement element=(MobileElement)driver.findElement(By.xpath("(//*[@text='CSK'])[1]"));
		String team=element.getText();
		System.out.println(team);
		String fav="CSK";
		Assert.assertEquals(fav, team);
		System.out.println("condition is true");
		waitTime(2000);
		driver.findElementByXPath("(//*[@text='CSK'])[1]").click();
		waitTime(2000);
		driver.getPageSource().contains("Chennai Super Kings");
		waitTime(2000);
		
	}

}
