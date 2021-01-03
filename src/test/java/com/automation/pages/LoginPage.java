package com.automation.pages;

import com.automation.utils.ConfigurationReader;
import com.automation.utils.MobileUtils;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage{

    @AndroidFindBy(id = "com.etsy.android:id/btn_link")
    private AndroidElement getStartedBtn;

    @AndroidFindBy(id = "com.etsy.android:id/edit_username")
    private AndroidElement emailInputBox;

    @AndroidFindBy(id = "com.etsy.android:id/edit_password")
    private AndroidElement passwordElement;

    @AndroidFindBy(id = "com.etsy.android:id/edit_signin")
    private AndroidElement signInButton;

    public void clickGetStarted(){
        MobileUtils.clickWithWait(getStartedBtn);
    }

    public void login(){
        String email = ConfigurationReader.getProperty("email");
        String password = ConfigurationReader.getProperty("password");
        login(email,password);
    }
    public void login(String email, String password){
        MobileUtils.waitFor(2000);
        emailInputBox.sendKeys(email);
        passwordElement.sendKeys(password);
        signInButton.click();
    }
}
