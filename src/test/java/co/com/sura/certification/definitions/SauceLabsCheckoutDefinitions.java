package co.com.sura.certification.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import saucedemo.model.UserInformationModel;
import saucedemo.pages.CartPageSauce;
import saucedemo.pages.CheckoutPageSauce;
import saucedemo.pages.MainPageSauce;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SauceLabsCheckoutDefinitions {

    CheckoutPageSauce checkoutPageSauce;
    MainPageSauce mainPageSauce;
    CartPageSauce cartPageSauce;

    @And("user add multiple products to shopping cart")
    public void userAddMultipleProductsToShoppingCart() {
        List<String> listOfProducts = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Fleece Jacket", "Sauce Labs Onesie");
        listOfProducts.forEach(itemName -> mainPageSauce.addItemToCart(itemName));
    }

    @And("user goes to the shopping cart page")
    public void userGoesToTheShoppingCartPage() {
        mainPageSauce.viewCartItems();
    }

    @When("user navigates to the checkout page")
    public void userNavigatesToTheCheckoutPage() {
        cartPageSauce.checkoutPage();
    }

    @And("user enters the following billing information")
    public void userEntersTheFollowingBillingInformation(UserInformationModel userInformation) {
        checkoutPageSauce.enterInformationForm(userInformation);
    }

    @Then("the user should see the purchase completed successfully message")
    public void theUserShouldSeeThePurchaseCompletedSuccessfullyMessage() {
        assertThat(checkoutPageSauce.wasThePurchaseSuccessful(), is(true));
    }
}
