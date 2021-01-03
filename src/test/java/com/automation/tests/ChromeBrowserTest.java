package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class ChromeBrowserTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        // to specify test settings and required info about the device and app under test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        // caculator app is existing in the device and we did not provide apk...
        // address of appium server
        // if the server launced in other IP you have to specify it
        // 4723 is the default port number of appium server
        URL url = new URL("http://localhost:4723/wd/hub");
        // we use throws to handle the exception
        driver= new RemoteWebDriver(url,desiredCapabilities);
    }


    @Test
    public void mobileChromeTest() throws InterruptedException{

        driver.get("https://qa1.vytrack.com");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager225");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).sendKeys(Keys.ENTER);
        Thread.sleep(8000);

    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
