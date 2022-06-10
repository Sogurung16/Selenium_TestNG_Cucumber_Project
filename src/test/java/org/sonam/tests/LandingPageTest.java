package org.sonam.tests;

import org.junit.jupiter.api.Assertions;
import org.sonam.base.TestBase;
import org.sonam.login.HomePage;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LandingPageTest {
    private LandingPage landingPage;

    @BeforeSuite
    public void setup(){
        TestBase.initialisation();
        landingPage = new LandingPage();
    }

    @Test
    @Parameters({"Browser","URL"})
    void testAbletoGetSignInButton(){
       SignInUsernamePage signInUsernamePage = landingPage.gotToSignInPage();
       SignInPasswordPage signInPasswordPage = signInUsernamePage.goToSignInPasswordPage("FirstTestLogin_12");
       HomePage homePage = signInPasswordPage.gotToHomePage("TestAbc_12!");
    }
}
