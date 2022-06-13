package org.sonam.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.sonam.CalendarPage;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.HomePage;
import org.sonam.util.ExcelDataProvider;
import org.sonam.util.PropertiesLoader;
import org.testng.Assert;

public class NavigationStepdefs {
    private static LandingPage landingPage;
    private static SignInUsernamePage signInUsernamePage;
    private static SignInPasswordPage signInPasswordPage;
    private static HomePage homePage;
    private static FinancePage financePage;
    private static CalendarPage calendarPage;

    @Given("I am on the Yahoo landing page")
    public void iAmOnTheYahoolandingPage() {
        landingPage = new LandingPage();
    }

    @And("I go to the Username page")
    public void iGoToTheUsernamePage() {
        signInUsernamePage = landingPage.gotToSignInPage();
    }

    @And("I go to the Password page")
    public void iGoToThePasswordPage() {
        signInUsernamePage.enterUsername(
                ExcelDataProvider.getCellValue(
                        PropertiesLoader.getProperties().getProperty("validUsername")
                ));
        signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
    }

    @And("I go to the Home page")
    public void iGoToTheHomePage() {
        signInPasswordPage.enterPassword(
                ExcelDataProvider.getCellValue(
                        PropertiesLoader.getProperties().getProperty("validPassword")
                ));
        homePage = signInPasswordPage.goToHomePage();
    }

    @And("I go to the Finance page")
    public void iGoToTheFinancePage() {
        financePage = homePage.goToFinancePage();
    }

    @When("I go to the Calendar page")
    public void iGoToTheCalendarPage() {
        calendarPage = financePage.goToMarketDataCalenderPage();
    }

    @Then("I should be on the Calendar page")
    public void iShouldBeOnTheCalendarPage() {
        Assert.assertNotNull(calendarPage);
    }
}
