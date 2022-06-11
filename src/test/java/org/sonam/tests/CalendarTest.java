package org.sonam.tests;

import org.junit.jupiter.api.DisplayName;
import org.sonam.MarketDataCalender;
import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalendarTest {
    private MarketDataCalender marketDataCalender;
    private LandingPage landingPage;

    //setup: Navigate to Calender Page
    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setup(String browser, String url){
        TestBase.initialisation(browser, url);
        landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage("FirstTestLogin_12");
        HomePage homePage = signInPasswordPage.gotToHomePage("TestAbc_12!");
        FinancePage financePage = homePage.goToFinancePage();
        marketDataCalender = financePage.goToMarketDataCalenderPage();
    }

    @Test(testName = "Thursday values are not empty")
    void areValuesEmpty(){
        Assert.assertFalse(marketDataCalender.getValuesList().isEmpty());
    }

    @Test
    @DisplayName("Thursday values size greater than 0")
    void valuesSizeGreaterThanZero(){
        Assert.assertTrue(marketDataCalender.getValuesList().size()>0);
    }

    @Test
    @DisplayName("Earnings value not less than 1")
    void lessThanOneEarningsValueIsFalse(){
        Assert.assertFalse(marketDataCalender.getEarningsValue()<1);
    }

    @Test
    @DisplayName("StockSplits value not less than 1")
    void lessThanOneStockSplitsValueIsFalse(){
        Assert.assertFalse(marketDataCalender.getStockSplitsValue()<1);
    }

    @Test
    @DisplayName("IPO_Pricing value not less than 1")
    void lessThanOneIPO_PricingValueIsFalse(){
        Assert.assertFalse(marketDataCalender.getIPO_PricingValue()<1);
    }

    @Test
    @DisplayName("EconomicEvents value not less than 1")
    void lessThanOneEconomicEventsValueIsFalse(){
        Assert.assertFalse(marketDataCalender.getEconomicEventsValue()<1);
    }

    @Test(testName = "Earnings field spelling check")
    void isEarningsSpellingCorrect(){
        if(marketDataCalender.getEarningsElement()!=null){
            Assert.assertTrue(marketDataCalender.getEarningsString().equals("Earnings"));
        }else{
            Assert.assertTrue(marketDataCalender.getEarningsString().equals(""));
        }
    }

    @Test(testName = "StockSplits field spelling check")
    void isStockSplitsSpellingCorrect(){
        if(marketDataCalender.getEarningsElement()!=null){
            Assert.assertTrue(marketDataCalender.getStockSplitsString().equals("Stock splits"));
        }else{
            Assert.assertTrue(marketDataCalender.getEarningsString().equals(""));
        }
    }

    @Test(testName = "IPO_Pricing field spelling check")
    void isIPO_Pricing_SpellingCorrect(){
        if(marketDataCalender.getEarningsElement()!=null){
            Assert.assertTrue(marketDataCalender.getIPO_PricingString().equals("IPO pricing"));
        }else{
            Assert.assertTrue(marketDataCalender.getEarningsString().equals(""));
        }
    }

    @Test(testName = "EconomicEvents field spelling check")
    void isEconomicEventsSpellingCorrect(){
        if(marketDataCalender.getEarningsElement()!=null){
            Assert.assertTrue(marketDataCalender.getEconomicEventsString().equals("Economic events"));
        }else{
            Assert.assertTrue(marketDataCalender.getEarningsString().equals(""));
        }
    }

    //Earnings exist etc
    //are the values clickable

    @AfterMethod
    public void teardown(){
        TestBase.close();
    }
}
