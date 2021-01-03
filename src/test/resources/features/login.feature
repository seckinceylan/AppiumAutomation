Feature: Login
  As user, I want to be able to login with etsy, facebook and google accounts

  Scenario: 1. Just a login with Etsy account
    Given user clicks on get started button
    When user logs in with etsy account
    Then user verifies that logo is displayed