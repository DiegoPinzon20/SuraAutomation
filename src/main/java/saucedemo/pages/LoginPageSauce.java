package saucedemo.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPageSauce extends PageObject {

    @FindBy( id = "user-name")
    WebElementFacade usernameField;

    @FindBy( id = "password")
    WebElementFacade passwordField;

    @FindBy( id = "login-button")
    WebElementFacade loginButton;

    @FindBy(xpath = "//h3[@data-test= 'error']")
    WebElementFacade loginErrorMessage;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(usernameField).waitUntilVisible();
    }
    @Step("User logs in by entering username and password")
    public void enterCredentials(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    private void enterUsername(String username){
        enter(username).into(usernameField);
    }
    private void enterPassword(String password){
        enter(password).into(passwordField);
    }
    private void clickLoginButton(){
        loginButton.click();
    }
    public String getLoginMessage(){
        return loginErrorMessage.getText();
    }

}
