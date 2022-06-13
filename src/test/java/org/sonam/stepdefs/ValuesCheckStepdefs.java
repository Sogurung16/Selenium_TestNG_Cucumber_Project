package org.sonam.stepdefs;

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

public class ValuesCheckStepdefs {
    private static CalendarPage calendarPage;


    private static int valueNumber;

    @Given("I am on the calendar page")
    public void iAmOnTheCalendarPage() {
        LandingPage landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        signInUsernamePage.enterUsername(
                ExcelDataProvider.getCellValue(
                        PropertiesLoader.getProperties().getProperty("validUsername")
                ));

        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        signInPasswordPage.enterPassword(
                ExcelDataProvider.getCellValue(
                        PropertiesLoader.getProperties().getProperty("validPassword")
                ));

        HomePage homePage = signInPasswordPage.goToHomePage();

        FinancePage financePage = homePage.goToFinancePage();
        calendarPage = financePage.goToMarketDataCalenderPage();
    }

    @When("I check Earnings number value")
    public void iCheckEarningsNumberValue() {
        valueNumber = calendarPage.getEarningsValue();
    }

    @Then("the number should not be less than {int}")
    public void theNumberShouldNotBeLessThan(int arg0) {
        Assert.assertFalse(valueNumber<arg0);
    }

    @When("I check Stock splits number value")
    public void iCheckStockSplitsNumberValue() {
        valueNumber = calendarPage.getStockSplitsValue();
    }

    @When("I check IPO pricing number value")
    public void iCheckIPOPricingNumberValue() {
        valueNumber = calendarPage.getIPO_PricingValue();
    }

    @When("I check Economic events number value")
    public void iCheckEconomicEventsNumberValue() {
        valueNumber = calendarPage.getEconomicEventsValue();
    }
}
