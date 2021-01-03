package com.automation.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.MobileUtils;

import java.net.URL;

public class ChewyTests {

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
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/chewy.apk");
        // caculator app is existing in the device and we did not provide apk...
        // address of appium server
        // if the server launced in other IP you have to specify it
        // 4723 is the default port number of appium server
        URL url = new URL("http://localhost:4723/wd/hub");
        // we use throws to handle the exception
        driver= new AndroidDriver<>(url,desiredCapabilities);
    }
    @Test
    public void t() throws InterruptedException{
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver,20);
        By doneBy = MobileBy.id("com.chewy.android:id/doneButton");
        wait.until(ExpectedConditions.presenceOfElementLocated(doneBy));
        AndroidElement doneBtn = driver.findElement(doneBy);
        wait.until(ExpectedConditions.elementToBeClickable(doneBy));
        doneBtn.click();

        //MobileUtils.swipeScreenSmall(MobileUtils.Direction.UP,driver);
        //Thread.sleep(3000);


        By dogIconBy = MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Dog Category\"]/android.widget.ImageView");
        MobileUtils.scrollToElement(MobileUtils.Direction.UP,driver,dogIconBy);
        wait.until(ExpectedConditions.presenceOfElementLocated(dogIconBy));
        AndroidElement dogsIcon = driver.findElement(dogIconBy);
        wait.until(ExpectedConditions.elementToBeClickable(dogIconBy));
        dogsIcon.click();
        Thread.sleep(3000);
    }





    @After
    public void tearDown(){
        driver.closeApp();
    }
}
