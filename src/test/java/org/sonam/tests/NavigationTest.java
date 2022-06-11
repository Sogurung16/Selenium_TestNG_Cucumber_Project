package org.sonam.tests;

import org.sonam.MarketDataCalender;
import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.HomePage;
import org.testng.annotations.*;

public class NavigationTest {
    private LandingPage landingPage;

    @BeforeMethod
    @Parameters({"browser", "url"})
    public void setup(String browser, String url){
        TestBase.initialisation(browser, url);
    }

    @Test(description = "Navigation Test", invocationCount = 5)
    void navigationTest(){
        landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage("FirstTestLogin_12");
        HomePage homePage = signInPasswordPage.gotToHomePage("TestAbc_12!");
        FinancePage financePage = homePage.goToFinancePage();
        MarketDataCalender marketDataCalender = financePage.goToMarketDataCalenderPage();
    }
    //successful end url navi

    @AfterMethod
    public void teardown(){
        TestBase.close();
    }
}
