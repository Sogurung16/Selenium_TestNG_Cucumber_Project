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
import org.testng.annotations.*;

public class NavigationTest {
    private LandingPage landingPage;

    @Parameters({"browser", "url","day","month","year","username","password"})
    public void setup(String browser, String url){
        TestBase.initialisation(browser, url);
    }

    @Parameters({"day","month","year","username","password"})
    @Test(description = "Navigation Test", invocationCount = 5)
    void navigationTest(String username, String password){
        landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(username));

        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(password));

        HomePage homePage = signInPasswordPage.goToHomePage();

        FinancePage financePage = homePage.goToFinancePage();
        CalendarPage calendarPage = financePage.goToMarketDataCalenderPage();
        Assert.assertNotNull(calendarPage);
    }
    //successful end url navi

    @AfterMethod
    public void teardown(){
        TestBase.close();
    }
}
