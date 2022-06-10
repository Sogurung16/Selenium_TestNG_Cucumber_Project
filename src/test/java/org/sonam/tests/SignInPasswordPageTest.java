package org.sonam.tests;

import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInPasswordPageTest{
    private LandingPage landingPage;

    @BeforeSuite
    public void setup(){
        TestBase.initialisation();
        landingPage = new LandingPage();
    }

    @Test
    @Parameters({"Browser","URL"})
    void testAbletoGetSignInButton(){
        landingPage.gotToSignInPage();
    }
}
