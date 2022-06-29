package saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;
import org.openqa.selenium.support.FindBy;
import saucedemo.model.UserInformationModel;

@At("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutPageSauce extends PageObject {

    @FindBy(id = "continue")
    WebElementFacade continueButton;

    @FindBy(id = "cancel")
    WebElementFacade cancelButton;

    @FindBy(id = "first-name")
    WebElementFacade firstNameInput;

    @FindBy(id = "last-name")
    WebElementFacade lastNameInput;

    @FindBy(id = "postal-code")
    WebElementFacade postalCodeInput;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElementFacade messageErrorCheckout;

    @FindBy(id = "finish")
    WebElementFacade finishCheckoutButton;

    @FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']")
    WebElementFacade messageSuccessfulCheckout;

    public void enterInformationForm(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        finishCheckoutInformation();
    }

    public void enterInformationForm(UserInformationModel userInformationModel){
        enterFirstName(userInformationModel.getFirstName());
        enterLastName(userInformationModel.getLastName());
        enterPostalCode(userInformationModel.getPostalCode());
        finishCheckoutInformation();
    }
    private void enterFirstName(String firstName){
        firstNameInput.type(firstName);
    }

    private void enterLastName(String lastName){
        lastNameInput.type(lastName);
    }

    private void enterPostalCode(String postalCode){
        postalCodeInput.type(postalCode);
    }

    private void finishCheckoutInformation(){
        continueButton.click();
        finishCheckoutButton.click();
    }

    public boolean wasThePurchaseSuccessful(){
        return messageSuccessfulCheckout.isVisible();
    }
}
