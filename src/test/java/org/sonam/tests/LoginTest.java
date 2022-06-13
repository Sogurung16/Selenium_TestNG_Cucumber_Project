package org.sonam.tests;

import org.openqa.selenium.TimeoutException;
import org.sonam.base.TestBase;
import org.sonam.login.LandingPage;
import org.sonam.login.SignInPasswordPage;
import org.sonam.login.SignInUsernamePage;
import org.sonam.nav.HomePage;
import org.sonam.util.ExcelDataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private static Object[][] data;

    private SignInUsernamePage signInUsernamePage;
    private SignInPasswordPage signInPasswordPage;
    private HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    //@Parameters({"browser", "url","filePath","xssfSheet"})
    public void setup(String browser, String url, String filePath, String xssfSheet){
        TestBase.initialisation(browser, url);
        LandingPage landingPage = new LandingPage();

        signInUsernamePage = landingPage.gotToSignInPage();

        ExcelDataProvider dataProvider = new ExcelDataProvider();
        data = dataProvider.getExcelData(filePath,xssfSheet);
    }

    @Test(testName = "Username is valid, Successful Login",groups = "Login Checks")
//    @Parameters("validUsername")
    void isUsernameValid(String validUsername){
        signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(validUsername));
        signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        Assert.assertNotNull(signInPasswordPage);
    }

    @Test(testName = "Password is valid, Successful Login",groups = "Login Checks")
//    @Parameters({"validUsername", "validPassword"})
    void isPasswordValid(String validUsername, String validPassword){
        signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(validUsername));
        signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();

        signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(validPassword));
        homePage = signInPasswordPage.goToHomePage();

        Assert.assertNotNull(homePage);
    }

    @Test(testName = "Username is invalid, Failed Login",groups = "Login Checks")
//    @Parameters("invalidUsername")
    void isUsernameInvalid(String invalidUsername){
        try{
            signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(invalidUsername));
            signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
        }catch (TimeoutException timeoutException){
            timeoutException.printStackTrace();
            Assert.assertNull(signInPasswordPage);
        }

    }

    @Test(testName = "Password is invalid, Failed Login",groups = "Login Checks")
//    @Parameters({"validUsername", "invalidPassword"})
    void isPasswordInvalid(String validUsername, String invalidPassword){
        try{
            signInUsernamePage.enterUsername(ExcelDataProvider.getCellValue(validUsername));

            signInPasswordPage = signInUsernamePage.goToSignInPasswordPage();
            signInPasswordPage.enterPassword(ExcelDataProvider.getCellValue(invalidPassword));

            homePage = signInPasswordPage.goToHomePage();
        }catch (TimeoutException timeoutException){
            timeoutException.printStackTrace();
            Assert.assertNull(homePage);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        TestBase.close();
    }
}
