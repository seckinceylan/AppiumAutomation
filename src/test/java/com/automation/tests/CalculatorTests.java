package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class CalculatorTests {

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
        //for new apps we use app
        // for pre installed "appPackage and appActivity
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");

        // caculator app is existing in the device and we did not provide apk...
        // address of appium server
        // if the server launced in other IP you have to specify it
        // 4723 is the default port number of appium server
        URL url = new URL("http://localhost:4723/wd/hub");
        // we use throws to handle the exception
        driver= new AndroidDriver<>(url,desiredCapabilities);
    }
    @Test
    public void calculatorTest() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver,20);

        AndroidElement btn2 = driver.findElement(MobileBy.id("com.android.calculator2:id/digit_2"));
        btn2.click();
        wait.until(ExpectedConditions.elementToBeClickable(btn2));
        AndroidElement btnPlus = driver.findElement(MobileBy.AccessibilityId("plus"));
        btnPlus.click();
        btn2.click();
        AndroidElement btnEquals = driver.findElement(MobileBy.AccessibilityId("equals"));
        btnEquals.click();
        AndroidElement resultElement = driver.findElement(MobileBy.id("com.android.calculator2:id/result"));

        int expected = 4;
        int actual = Integer.parseInt(resultElement.getText());
        Assert.assertEquals(expected,actual);



    }

    @Test
    public void calculatorTestWithTouchActions(){
        AndroidElement btn9 = driver.findElementById("com.android.calculator2:id/digit_9");
        AndroidElement btn0 = driver.findElementById("com.android.calculator2:id/digit_0");
        AndroidElement dividebtn = driver.findElementByAccessibilityId("divide");
        AndroidElement btn5 = driver.findElementById("com.android.calculator2:id/digit_5");
        AndroidElement resultElement = driver.findElement(MobileBy.id("com.android.calculator2:id/result"));
        AndroidElement btnEquals = driver.findElement(MobileBy.AccessibilityId("equals"));
        // we can use touch actions
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn9))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn0))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(dividebtn))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btn5))).perform();
        touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(btnEquals))).perform();

        int expected = 18;
        int actual = Integer.parseInt(resultElement.getText());
        Assert.assertEquals(expected,actual);

    }

    @After
    public void tearDown(){
        driver.closeApp();
    }
}
