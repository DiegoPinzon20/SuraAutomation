package co.com.sura.certification.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import saucedemo.pages.LoginPageSauce;
import saucedemo.pages.MainPageSauce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SauceLabsLoginDefinitions {

    private LoginPageSauce loginPageSauce;
    private MainPageSauce mainPageSauce;

    private final String invalidCredentialsMessage = "Epic sadface: Username and password do not match any user in this service";
    private final String lockedUserMessage = "Epic sadface: Sorry, this user has been locked out.";
    private final String requiredUsernameMessage = "Epic sadface: Username is required";
    private final String requiredPasswordMessage = "Epic sadface: Password is required";

    @Given("user navigates to SwagLabs login page")
    public void userNavigatesToSwagLabsLoginPage() {
        loginPageSauce.open();
    }

    @When("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        loginPageSauce.enterCredentials("standard_user", "secret_sauce");
    }

    @Then("the user should see the product catalog page")
    public void theUserShouldSeeTheProductCatalogPage() {
        assertThat(mainPageSauce.titleMainPageIsVisible(), is(true));
    }

    @When("user logs in with invalid credentials")
    public void userLogsInWithInvalidCredentials() {
        loginPageSauce.enterCredentials("standard_user", "admin123");
    }

    @Then("the user should see the invalid credentials message")
    public void theUserShouldSeeTheInvalidCredentialsMessage() {
        assertThat(loginPageSauce.getLoginMessage(), equalTo(invalidCredentialsMessage));
    }

    @When("user logs in with locked out credentials")
    public void userLogsInWithLockedOutCredentials() {
        loginPageSauce.enterCredentials("locked_out_user", "secret_sauce");
    }

    @Then("the user should see the user blocked message")
    public void theUserShouldSeeTheUserBlockedMessage() {
        assertThat(loginPageSauce.getLoginMessage(), equalTo(lockedUserMessage));
    }

    @When("user login with empty password")
    public void userLoginWithEmptyPassword() {
        loginPageSauce.enterCredentials("problem_user", "");
    }

    @Then("the user should see the password required message")
    public void theUserShouldSeeThePasswordRequiredMessage() {
        assertThat(loginPageSauce.getLoginMessage(), equalTo(requiredPasswordMessage));
    }

    @When("user login with empty password username")
    public void userLoginWithEmptyPasswordUsername() {
        loginPageSauce.enterCredentials("", "secret_sauce");
    }

    @Then("the user should see the username required message")
    public void theUserShouldSeeTheUsernameRequiredMessage() {
        assertThat(loginPageSauce.getLoginMessage(), equalTo(requiredUsernameMessage));
    }
}