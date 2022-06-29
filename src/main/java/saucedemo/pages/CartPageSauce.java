package saucedemo.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@At("https://www.saucedemo.com/cart.html")
public class CartPageSauce extends PageObject {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElementFacade> itemsInCart;

    @FindBy(xpath = "//button[@name='checkout']")
    WebElementFacade checkoutButton;

    public boolean isTheProductInTheCart(String itemName) {
        return itemsInCart.stream().anyMatch(webElementFacade -> webElementFacade.getTextContent().equals(itemName));
    }

    public void checkoutPage(){
        checkoutButton.click();
    }
}
