package org.sonam.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.sonam.CalendarPage;
import org.sonam.MarketDataCalender;
import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.time.Month;

public class CalendarTest {
    private MarketDataCalender marketDataCalender;
    private CalendarPage calendarPage;
    private LandingPage landingPage;

    //setup: Navigate to Calender Page
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setup(String browser, String url){
        LocalDate testDate = LocalDate.of(2022, Month.JUNE,9);

        TestBase.initialisation(browser, url);
        landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage("SonamtestUI123");
        HomePage homePage = signInPasswordPage.gotToHomePage("SonamtestUI123");
        FinancePage financePage = homePage.goToFinancePage();
        marketDataCalender = financePage.goToMarketDataCalenderPage();
        calendarPage = marketDataCalender.submitDate(testDate);
    }

    @Test(testName = "Thursday values list is not empty",groups = {"Values Check"})
    void areValuesEmpty(){
        Assert.assertFalse(calendarPage.getValuesList().isEmpty());
    }

    @Test(testName = "Earnings value not less than 1",groups = "Value Number Check")
    void lessThanOneEarningsValueIsFalse(){
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertFalse(calendarPage.getEarningsValue()<1);
        }else{
            Assert.assertTrue(calendarPage.getEarningsValue()==0);
        }
    }

    @Test(testName = "StockSplits value not less than 1",groups = "Value Number Check")
    void lessThanOneStockSplitsValueIsFalse(){
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertFalse(calendarPage.getStockSplitsValue()<1);
        }else{
            Assert.assertTrue(calendarPage.getStockSplitsValue()==0);
        }
    }

    @Test(testName = "IPO_Pricing value not less than 1",groups = "Value Number Check")
    void lessThanOneIPO_PricingValueIsFalse(){
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertFalse(calendarPage.getIPO_PricingValue()<1);
        }else{
            Assert.assertTrue(calendarPage.getIPO_PricingValue()==0);
        }
    }

    @Test(testName = "EconomicEvents value not less than 1",groups = "Value Number Check")
    void lessThanOneEconomicEventsValueIsFalse(){
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertFalse(calendarPage.getEconomicEventsValue()<1);
        }else{
            Assert.assertTrue(calendarPage.getEconomicEventsValue()==0);
        }
    }

    @Test(testName = "Earnings field spelling check",groups = "Spelling Check")
    @Parameters("earningsString")
    void isEarningsSpellingCorrect(String earningsString){
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertTrue(calendarPage.getEarningsString().equals(earningsString));
        }else{
            Assert.assertTrue(calendarPage.getEarningsString().equals(""));
        }
    }

    @Test(testName = "StockSplits field spelling check",groups = "Spelling Check")
    @Parameters("stockSplitsString")
    void isStockSplitsSpellingCorrect(String stockSplitsString){
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertTrue(calendarPage.getStockSplitsString().equals(stockSplitsString));
        }else{
            Assert.assertTrue(calendarPage.getStockSplitsString().equals(""));
        }
    }

    @Test(testName = "IPO_Pricing field spelling check",groups = "Spelling Check")
    @Parameters("ipo_PricingString")
    void isIPO_PricingSpellingCorrect(String ipo_PricingString){
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(calendarPage.getIPO_PricingString(),(ipo_PricingString));
        }else{
            Assert.assertTrue(calendarPage.getIPO_PricingString().isEmpty());
        }
    }

    @Test(testName = "EconomicEvents field spelling check",groups = "Spelling Check")
    @Parameters("economicEventsString")
    void isEconomicEventsSpellingCorrect(String economicEventsString){
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertTrue(calendarPage.getEconomicEventsString().equals(economicEventsString));
        }else{
            Assert.assertTrue(calendarPage.getEconomicEventsString().equals(""));
        }
    }

    @Test(testName = "Earnings element exists", groups = {"Values Checks"})
    void doesEarningsElementExist(){
        Assert.assertNotNull(calendarPage.getEarningsElement());
    }

    @Test(testName = "StockSplits element exists", groups = {"Values Checks"})
    void doesStockSplitsElementExist(){
        Assert.assertNotNull(calendarPage.getStockSplitsElement());
    }

    @Test(testName = "IPO_Pricing element exists", groups = {"Values Checks"})
    void doesIPO_PricingElementExist(){
        Assert.assertNotNull(calendarPage.getIPO_PricingElement());
    }

    @Test(testName = "EconomicEvents element exists", groups = {"Values Checks"})
    void doesEconomicEventsElementExist(){
        Assert.assertNotNull(calendarPage.getEconomicEventsElement());
    }

    //Assert correct date TODO(1): Future Improvements, Extract updated date text
    @Test(testName = "Date is set to 16th June 2022", groups = {"Date check"})
    @Parameters({"dateDayNum","dateMonth","dateDay"})
    void correctDateSet(String dateDayNum, String dateMonth, String dateDay){
        String expectedDate = dateDayNum+" "+dateMonth+" "+dateDay;
        String actualDate =
                calendarPage.getDateDayNum()+" "+
                calendarPage.getDateMonth()+" "+
                calendarPage.getDateDay();
        Assert.assertEquals(actualDate,expectedDate);
    }

    @Test(testName = "Earnings is clickable", groups = {"Values Checks"})
    void isEarningsClickable(){
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getEarningsElement()));
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @Test(testName = "StockSplits is clickable", groups = {"Values Checks"})
    void isStockSplitsClickable(){
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getStockSplitsElement()));
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @Test(testName = "IPO_Pricing is clickable", groups = {"Values Checks"})
    void IPO_PricingClickable(){
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getIPO_PricingElement()));
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @Test(testName = "EconomicEvents is clickable", groups = {"Values Checks"})
    void isEconomicEventsClickable(){
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertTrue(calendarPage.isButtonClickable(calendarPage.getEconomicEventsElement()));
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    //Background Colours check
    //correct font

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        TestBase.close();
    }
}
