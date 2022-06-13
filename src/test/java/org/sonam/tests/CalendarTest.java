package org.sonam.tests;

import org.sonam.CalendarPage;
import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.HomePage;
import org.sonam.util.ExcelDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

public class CalendarTest {
    private CalendarPage calendarPage;

    //setup: Navigate to Calender Page
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "url","day","month","year","username","password"})
    public void setup(String browser, String url, String year, String month, String day, String username, String password){
        LocalDate testDate = LocalDate.of(Integer.valueOf(day), Month.valueOf(month.toUpperCase()),Integer.valueOf(year));

        TestBase.initialisation(browser, url);
        LandingPage landingPage = new LandingPage();

        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(password));

        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(password));

        HomePage homePage = signInPasswordPage.goToHomePage();

        FinancePage financePage = homePage.goToFinancePage();
        calendarPage = financePage.goToMarketDataCalenderPage();
        calendarPage = calendarPage.submitDate(testDate);
    }

    @Test(testName = "Thursday values list is not empty",groups = "Values Check")
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

    //Assert correct date, currently test is only valid for current week Thu
    // TODO(1): Future Improvements, Extract updated date text
    @Test(testName = "Date is set to 16th June 2022", groups = {"Date Check"})
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

    @Test(testName = "Earnings value field background colour check", groups = {"Css Checks","Background Colour"})
    @Parameters("earningsBackgroundColour")
    void earningsBackgroundCoulourCheck(String earningsBackgroundColour){
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertEquals(calendarPage.getBackgroundColor(calendarPage.getEarningsElement()),earningsBackgroundColour);
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @Test(testName = "StockSplits value field background colour check", groups = {"Css Checks","Background Colour"})
    @Parameters("stockSplitsBackgroundColour")
    void stockSplitsBackgroundCoulourCheck(String stockSplitsBackgroundColour){
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertEquals(calendarPage.getBackgroundColor(calendarPage.getStockSplitsElement()),stockSplitsBackgroundColour);
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @Test(testName = "IPO_Pricing value field background colour check", groups = {"Css Checks","Background Colour"})
    @Parameters("ipo_PricingBackgroundColour")
    void ipo_PricingBackgroundCoulourCheck(String ipo_PricingBackgroundColour){
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(calendarPage.getBackgroundColor(calendarPage.getIPO_PricingElement()),ipo_PricingBackgroundColour);
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }

    @Test(testName = "EconomicEvents value field background colour check", groups = {"Css Checks","Background Colour"})
    @Parameters("economicEventsBackgroundColour")
    void economicEventsBackgroundCoulourCheck(String economicEventsBackgroundColour){
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertEquals(calendarPage.getBackgroundColor(calendarPage.getEconomicEventsElement()),economicEventsBackgroundColour);
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    @Test(testName = "Earnings value field font check", groups = {"Css Checks","Font"})
    @Parameters("expectedFontSize")
    void EarningsFontCheck(String expectedFontSize){
        if(calendarPage.getEarningsElement()!=null){
            Assert.assertEquals(calendarPage.getEarningsElement().getCssValue("font-size"),expectedFontSize);
        } else{
            Assert.assertNull(calendarPage.getEarningsElement());
        }
    }

    @Test(testName = "StockSplits value field font check", groups = {"Css Checks","Font"})
    @Parameters("expectedFontSize")
    void stockSplitsFontCheck(String expectedFontSize){
        if(calendarPage.getStockSplitsElement()!=null){
            Assert.assertEquals(calendarPage.getStockSplitsElement().getCssValue("font-size"),expectedFontSize);
        } else{
            Assert.assertNull(calendarPage.getStockSplitsElement());
        }
    }

    @Test(testName = "IPO_Pricing value field font check", groups = {"Css Checks","Font"})
    @Parameters("expectedFontSize")
    void ipo_PricingFontCheck(String expectedFontSize){
        if(calendarPage.getIPO_PricingElement()!=null){
            Assert.assertEquals(calendarPage.getIPO_PricingElement().getCssValue("font-size"),expectedFontSize);
        } else{
            Assert.assertNull(calendarPage.getIPO_PricingElement());
        }
    }
    @Test(testName = "EconomicEvents value field font check", groups = {"Css Checks","Font"})
    @Parameters("expectedFontSize")
    void economicEventsFontCheck(String expectedFontSize){
        if(calendarPage.getEconomicEventsElement()!=null){
            Assert.assertEquals(calendarPage.getEconomicEventsElement().getCssValue("font-size"),expectedFontSize);
        } else{
            Assert.assertNull(calendarPage.getEconomicEventsElement());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        TestBase.close();
    }
}
