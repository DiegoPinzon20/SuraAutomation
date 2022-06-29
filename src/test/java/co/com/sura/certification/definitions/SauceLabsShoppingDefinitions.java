package co.com.sura.certification.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemo.pages.CartPageSauce;
import saucedemo.pages.MainPageSauce;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SauceLabsShoppingDefinitions {

    private List<String> cartItems;
    private MainPageSauce mainPageSauce;
    private CartPageSauce cartPageSauce;

    @When("user adds the following products to cart")
    public void userAddsTheFollowingProductsToCart(List<String> items) {
        this.cartItems = items;
        items.forEach(itemName -> mainPageSauce.addItemToCart(itemName));
    }

    @Then("the shopping cart count should be {int}")
    public void theShoppingCartCountShouldBe(int expectedCount) {
        assertThat(mainPageSauce.getTheNumberOfProductsInTheCart(), is(expectedCount));
    }

    @Then("the items should appear in the cart")
    public void theItemsShouldAppearInTheCart() {
        mainPageSauce.viewCartItems();
        cartItems.forEach(itemName -> assertThat(cartPageSauce.isTheProductInTheCart(itemName), is(true)));
    }

    @When("the user orders by lower price")
    public void userOrdersByLowerPrice(){
        mainPageSauce.orderProductsByMinorPrice();
    }

    @And("the user selects the first product in the list")
    public void userSelectsTheFirstProductInTheList(){
        mainPageSauce.addFirstProduct();
    }
}
