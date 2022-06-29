# Created by DiegoPinzon at 15/06/2022
# author: diego.pizon@sofka.com.co

Feature: Make a purchase at SauceDemo Labs

  Rule: Complete the purchase process on the SauceDemo Labs website
  As a user, I want to complete the purchase of the products added to the shopping cart.

    Background: Log in and add products to the cart on the SauceLabs page
      Given user navigates to SwagLabs login page
      And user logs in with valid credentials
      And user add multiple products to shopping cart
      And user goes to the shopping cart page

    @SuccessfulPurchase
    Scenario: Successful purchase
      When user navigates to the checkout page
      And user enters the following billing information
        | firstName | lastName | postalCode |
        | Diego     | Pinzon   | 540010     |
      Then the user should see the purchase completed successfully message