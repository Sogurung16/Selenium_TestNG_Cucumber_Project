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

    private int valueNumber;
    private String valueString, date, fontSize, backgroundColour;

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
        if(calendarPage.getEarningsElement()!=null){
            valueNumber = calendarPage.getEarningsValue();
        }
    }

    @Then("the earnings number should not be less than {int}")
    public void theNumberShouldNotBeLessThan(int arg0) {
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertFalse(valueNumber<arg0);
        }else{
            Assert.assertEquals(valueNumber,0);
        }
    }

    @When("I check Stock splits number value")
    public void iCheckStockSplitsNumberValue() {
        if(calendarPage.getStockSplitsElement()!=null){
            valueNumber = calendarPage.getStockSplitsValue();
        }
    }

    @When("I check IPO pricing number value")
    public void iCheckIPOPricingNumberValue() {
        if(calendarPage.getIPO_PricingElement()!=null){
            valueNumber = calendarPage.getIPO_PricingValue();
        }
    }

    @When("I check Economic events number value")
    public void iCheckEconomicEventsNumberValue() {
        if(calendarPage.getEconomicEventsElement()!=null){
            valueNumber = calendarPage.getEconomicEventsValue();
        }
    }

    @Then("the stock splits number should not be less than {int}")
    public void theStockSplitsNumberShouldNotBeLessThan(int arg0) {
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertFalse(valueNumber<arg0);
        }else{
            Assert.assertEquals(valueNumber,0);
        }
    }

    @Then("the ipo pricing number should not be less than {int}")
    public void theIpoPricingNumberShouldNotBeLessThan(int arg0) {
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertFalse(valueNumber<arg0);
        }else{
            Assert.assertEquals(valueNumber,0);
        }
    }

    @Then("the economic events should not be less than {int}")
    public void theEconomicEventsShouldNotBeLessThan(int arg0) {
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertFalse(valueNumber<arg0);
        }else{
            Assert.assertEquals(valueNumber,0);
        }
    }

    @When("I check Earnings spelling")
    public void iCheckEarningsSpelling() {
        if(calendarPage.getEarningsElement()!=null){
            valueString = calendarPage.getEarningsString();
        }
    }

    @Then("the Earnings spelling should be correct")
    public void theEarningsSpellingShouldBeCorrect() {
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertEquals(valueString, "Earnings");
        }else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @When("I check Stock splits spelling")
    public void iCheckStockSplitsSpelling() {
        if(calendarPage.getStockSplitsElement()!=null){
            valueString = calendarPage.getStockSplitsString();
        }
    }

    @Then("the Stock splits spelling should be correct")
    public void theStockSplitsSpellingShouldBeCorrect() {
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertEquals(valueString, "Stock splits");
        }else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @When("I check IPO pricing spelling")
    public void iCheckIPOPricingSpelling() {
        if(calendarPage.getIPO_PricingElement()!=null){
            valueString = calendarPage.getIPO_PricingString();
        }
    }

    @Then("the IPO pricing spelling should be correct")
    public void theIPOPricingSpellingShouldBeCorrect() {
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(valueString, "IPO pricing");
        }else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @When("I check Economic events spelling")
    public void iCheckEconomicEventsSpelling() {
        if(calendarPage.getEconomicEventsElement()!=null){
            valueString = calendarPage.getEconomicEventsString();
        }
    }

    @Then("the Economic events spelling should be correct")
    public void theEconomicEventsSpellingShouldBeCorrect() {
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertEquals(valueString, "Economic events");
        }else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    @When("I check the date field")
    public void iCheckTheDateField() {
        date = calendarPage.getDateDayNum() + " " +
                calendarPage.getDateMonth() + " " +
                calendarPage.getDateDay();
    }


    @Then("the date should be correct")
    public void theDateShouldBeCorrect() {
        String expectedDateDayNum = PropertiesLoader.getProperties().getProperty("dateDayNum");
        String expectedDateMonth = PropertiesLoader.getProperties().getProperty("dateMonth");
        String expectedDateDay = PropertiesLoader.getProperties().getProperty("dateDay");

        Assert.assertEquals(date,
                expectedDateDayNum + " " +
                        expectedDateMonth + " " +
                        expectedDateDay);
    }

    @Then("Earnings should be clickable")
    public void earningsShouldBeClickable() {
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getEarningsElement()));
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @Then("Stock splits should be clickable")
    public void stockSplitsShouldBeClickable() {
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getStockSplitsElement()));
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @Then("IPO pricing should be clickable")
    public void ipoPricingShouldBeClickable() {
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getIPO_PricingElement()));
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @Then("Economic events should be clickable")
    public void economicEventsShouldBeClickable() {
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getEconomicEventsElement()));
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    @Then("Earnings font size should be correct")
    public void earningsFontSizeShouldBeCorrect() {
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertEquals(fontSize,
                    PropertiesLoader.getProperties().getProperty("expectedFontSize"));
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @Then("Stock splits font size should be correct")
    public void stockSplitsFontSizeShouldBeCorrect() {
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertEquals(fontSize,
                    PropertiesLoader.getProperties().getProperty("expectedFontSize"));
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @Then("IPO pricing font size should be correct")
    public void ipoPricingFontSizeShouldBeCorrect() {
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(fontSize,
                    PropertiesLoader.getProperties().getProperty("expectedFontSize"));
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @Then("Economic events font size should be correct")
    public void economicEventsFontSizeShouldBeCorrect() {
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertEquals(fontSize,
                    PropertiesLoader.getProperties().getProperty("expectedFontSize"));
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    @When("I check Earnings text font size")
    public void iCheckEarningsTextFontSize() {
        if(calendarPage.getEarningsElement()!=null){
            fontSize = calendarPage.getEarningsElement().getCssValue("font-size");
        }
    }

    @When("I check Stock splits text font size")
    public void iCheckStockSplitsTextFontSize() {
        if(calendarPage.getStockSplitsElement()!=null){
            fontSize = calendarPage.getStockSplitsElement().getCssValue("font-size");
        }
    }

    @When("I check IPO pricing text font size")
    public void iCheckIPOPricingTextFontSize() {
        if(calendarPage.getIPO_PricingElement()!=null){
            fontSize = calendarPage.getIPO_PricingElement().getCssValue("font-size");
        }
    }

    @When("I check Economic events text font size")
    public void iCheckEconomicEventsTextFontSize() {
        if(calendarPage.getEconomicEventsElement()!=null){
            fontSize = calendarPage.getEconomicEventsElement().getCssValue("font-size");
        }
    }

    @Then("Earnings background colour should be correct")
    public void earningsBackgroundColourShouldBeCorrect() {
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertEquals(backgroundColour,
                    PropertiesLoader.getProperties().getProperty("earningsBackgroundColour"));
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @When("I check Earnings background colour")
    public void iCheckEarningsBackgroundColour() {
        if(calendarPage.getEarningsElement()!=null){
            backgroundColour = calendarPage.getBackgroundColor(calendarPage.getEarningsElement());
        }
    }

    @When("I check Stock splits background colour")
    public void iCheckStockSplitsBackgroundColour() {
        if(calendarPage.getStockSplitsElement()!=null){
            backgroundColour = calendarPage.getBackgroundColor(calendarPage.getStockSplitsElement());
        }
    }

    @Then("Stock splits background colour should be correct")
    public void stockSplitsBackgroundColourShouldBeCorrect() {
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertEquals(backgroundColour,
                    PropertiesLoader.getProperties().getProperty("stockSplitsBackgroundColour"));
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @When("I check IPO pricing background colour")
    public void iCheckIPOPricingBackgroundColour() {
        if(calendarPage.getIPO_PricingElement()!=null){
            backgroundColour = calendarPage.getBackgroundColor(calendarPage.getIPO_PricingElement());
        }
    }

    @Then("IPO pricing background colour should be correct")
    public void ipoPricingBackgroundColourShouldBeCorrect() {
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(backgroundColour,
                    PropertiesLoader.getProperties().getProperty("ipo_PricingBackgroundColour"));
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @When("I check Economic events background colour")
    public void iCheckEconomicEventsBackgroundColour() {
        if(calendarPage.getEconomicEventsElement()!=null){
            backgroundColour = calendarPage.getBackgroundColor(calendarPage.getEconomicEventsElement());
        }
    }

    @Then("Economic events background colour should be correct")
    public void economicEventsBackgroundColourShouldBeCorrect() {
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertEquals(backgroundColour,
                    PropertiesLoader.getProperties().getProperty("economicEventsBackgroundColour"));
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }
}
