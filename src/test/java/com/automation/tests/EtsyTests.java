package com.automation.tests;


import com.automation.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.automation.utils.MobileUtils;

import java.net.URL;

public class EtsyTests {
    AppiumDriver<AndroidElement> driver;

    @Before
    public void setUp() throws Exception {
        // to specify test settings and required info about the device and app under test
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "https://cybertek-appium.s3.amazonaws.com/etsy.apk");

        // 4723 is the default port number of appium server
        URL url = new URL("http://localhost:4723/wd/hub");
        // we use throws to handle the exception
        driver = new AndroidDriver<>(url, desiredCapabilities);
    }

    @Test
    public void loginTest(){
        MobileUtils.waitFor(4000);
        //click on get started button
        driver.findElementById("com.etsy.android:id/btn_link").click();
        MobileUtils.waitFor(4000);
        //enter email
        driver.findElementById("com.etsy.android:id/edit_username").sendKeys("areatha@uspeakw.com");
        //enter password
        driver.findElementById("com.etsy.android:id/edit_password").sendKeys("Cybertek2020");
        //click on sign in button
        driver.findElementById("com.etsy.android:id/button_signin").click();
        MobileUtils.waitFor(4000);
    }

    @After
    public void tearDown(){
        driver.closeApp();
    }


}
