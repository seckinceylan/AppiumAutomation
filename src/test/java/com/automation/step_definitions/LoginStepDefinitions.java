package com.automation.step_definitions;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user clicks on get started button")
    public void user_clicks_on_get_started_button() {
        loginPage.clickGetStarted();
    }

    @When("user logs in with etsy account")
    public void user_logs_in_with_etsy_account() {
        loginPage.login();
    }

    @Then("user verifies that logo is displayed")
    public void user_verifies_that_logo_is_displayed() {
        System.out.println("user verifies that logo is displayed");
    }
}
