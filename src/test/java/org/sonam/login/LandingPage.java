package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonam.base.TestBase;

import java.time.Duration;

public class LandingPage extends TestBase {
    @FindBy(className = "_yb_yulhv")
    WebElement signinButton;
    @FindBy(name = "agree")
    WebElement acceptAllCookiesButton;

    public LandingPage() {
        PageFactory.initElements(webDriver, this);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("agree"))));
        if(acceptAllCookiesButton!=null){
            acceptAllCookiesButton.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("_yb_yulhv"))));
    }

    public SignInUsernamePage gotToSignInPage(){
        signinButton.click();
        return new SignInUsernamePage();
    }
}
