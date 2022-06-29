package saucedemo.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@At("https://www.saucedemo.com/inventory.html")
public class MainPageSauce extends PageObject {

    @FindBy(xpath = "//span[@class='title']")
    private WebElementFacade titleMainPage;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElementFacade countProductsOnCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElementFacade shoppingButton;

    @FindBy(xpath="//select[@class='product_sort_container']")
    private WebElementFacade filterDropdown;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private List<WebElementFacade>  buttonsAddToCart;

    public boolean titleMainPageIsVisible(){
        return titleMainPage.isVisible();
    }

    public void addItemToCart(String itemName){
        String buttonLocator = String.format("//div[text()='%s']/../../../div/button", itemName);
        WebElement addCartButton = getDriver().findElement(By.xpath(buttonLocator));
        assertThat(addCartButton.isDisplayed(), equalTo(true));
        addCartButton.click();
    }

    public int getTheNumberOfProductsInTheCart(){
        return Integer.parseInt(countProductsOnCart.getText());
    }

    public void viewCartItems(){
        shoppingButton.click();
    }

    public void orderProductsByMinorPrice(){
        filterDropdown.selectByValue("lohi");
    }

    public void orderProductsByMajorPrice(){
        filterDropdown.selectByValue("hilo");
    }

    public void addFirstProduct(){
        buttonsAddToCart.get(0).click();
    }
}
