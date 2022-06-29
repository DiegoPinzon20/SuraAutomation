# Created by DiegoPinzon at 15/06/2022
# author: diego.pizon@sofka.com.co

Feature: Login SauceDemo Labs

  Rule: User login Sauce Demo Web
  As a user, I need to login Sauce Demo Web with my credentials

    Background: Navigate to login page
      Given user navigates to SwagLabs login page

    @LoginSuccessfulSwagLabs
    Scenario: Successful Login
      When user logs in with valid credentials
      Then the user should see the product catalog page

    @LoginUnsuccessfulSwagLabs_InvalidCredentials
    Scenario: Unsuccessful Login
      When user logs in with invalid credentials
      Then the user should see the invalid credentials message

    @LoginUnsuccessfulSwagLabs_LockedOutUser
    Scenario: Locked Out User Login
      When user logs in with locked out credentials
      Then the user should see the user blocked message

    @LoginUnsuccessfulWithEmptyPassword
    Scenario: Login With Empty Password
      When user login with empty password
      Then the user should see the password required message

    @LoginUnsuccessfulWithEmptyUsername
    Scenario: Login With Empty Username
      When user login with empty password username
      Then the user should see the username required message