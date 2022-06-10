package org.sonam.tests;

import org.junit.jupiter.api.DisplayName;
import org.sonam.base.TestBase;
import org.sonam.login.HomePage;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.FinancePage;
import org.sonam.nav.MarketDataCalender;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigationTest {
    private LandingPage landingPage;

    @BeforeSuite
    public void setup(){
        TestBase.initialisation();
    }

    @Test
    @DisplayName("Navigation Test")
    @Parameters({"Browser","URL"})
    void navigationTest(){
        landingPage = new LandingPage();
        SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
        SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage("FirstTestLogin_12");
        HomePage homePage = signInPasswordPage.gotToHomePage("TestAbc_12!");
        FinancePage financePage = homePage.goToFinancePage();
        MarketDataCalender marketDataCalender = financePage.goToMarketDataCalenderPage();
    }

    public void teardown(){
        TestBase.close();
    }
}
