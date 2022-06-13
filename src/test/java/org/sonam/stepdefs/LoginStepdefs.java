package org.sonam.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.HomePage;
import org.sonam.util.ExcelDataProvider;
import org.sonam.util.PropertiesLoader;
import org.testng.Assert;

public class LoginStepdefs{
    private static LandingPage landingPage;
    private static SignInUsernamePage signInUsernamePage;
    private static SignInPasswordPage signInPasswordPage;
    private static HomePage homePage;

    @Given("I am on the Username page")
    public void iAmOnTheUsernamePage() {
        landingPage = new LandingPage();
        signInUsernamePage = landingPage.gotToSignInPage();
    }

    @When("I enter valid username details")
    public void iEnterUsernameDetails() {
        signInUsernamePage.enterUsername(
                ExcelDataProvider.getCellValue(
                PropertiesLoader.getProperties().getProperty("validUsername")
                ));
    }

    @When("I enter valid password details")
    public void iEnterPasswordDetails() {
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(
                PropertiesLoader.getProperties().getProperty("validPassword")
        ));
    }

    @Then("I should see the homepage")
    public void iShouldSeeTheHomepage() {
        homePage = signInPasswordPage.goToHomePage();
        Assert.assertNotNull(homePage);
    }

    @When("I enter invalid username details")
    public void iEnterInvalidUsernameDetails() {
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(
                PropertiesLoader.getProperties().getProperty("invalidUsername")
        ));
    }

    @When("I enter invalid password details")
    public void iEnterInvalidPasswordDetails() {
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(
                PropertiesLoader.getProperties().getProperty("invalidPassword")
        ));
    }

    @Then("I should not see the Password page")
    public void iShouldNotSeeThePasswordPage() {
        signInUsernamePage.enterUsername(
                ExcelDataProvider.getCellValue(
                        PropertiesLoader.getProperties().getProperty("validUsername")
                ));
        signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        Assert.assertNull(signInPasswordPage);
    }

    @Then("I should not see the homepage")
    public void iShouldNotSeeTheHomepage() {
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(
                PropertiesLoader.getProperties().getProperty("invalidPassword")
        ));
        homePage = signInPasswordPage.goToHomePage();
        Assert.assertNull(homePage);
    }
}
