package com.automation.pages;


import com.automation.utils.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    //make sure Logger imported from here: import org.apache.log4j.Logger;
    private final static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(){
        //AppiumFieldDecorator required for Appium
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);

    }

}
