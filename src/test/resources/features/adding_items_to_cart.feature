# Created by DiegoPinzon at 15/06/2022
# author: diego.pizon@sofka.com.co

Feature: Add products to shopping cart

  Rule: Items added from the catalog page should appear in the cart
  As a user, I want to add items to the shopping cart

    Background: Login SauceLabs page
      Given user navigates to SwagLabs login page
      And user logs in with valid credentials

    @AddItemsToCartSauceLabs
    Scenario: User adds some items to shopping cart
      When user adds the following products to cart
        | Sauce Labs Backpack      |
        | Sauce Labs Fleece Jacket |
        | Sauce Labs Onesie        |
      Then the shopping cart count should be 3
      And the items should appear in the cart

    @AddTheProductWithTheLowestPrice
    Scenario: User adds the cheapest product in the catalog
      When the user orders by lower price
      And the user selects the first product in the list
      Then the shopping cart count should be 1