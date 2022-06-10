package org.sonam.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonam.base.TestBase;

public class LandingPage extends TestBase {
    @FindBy(className = "_yb_yulhv")
    WebElement signinButton;
    @FindBy(name = "agree")
    WebElement acceptAllCookiesButton;

    public LandingPage() {
        PageFactory.initElements(webDriver, this);
        if(this.acceptAllCookiesButton!=null){
            this.acceptAllCookiesButton.click();
        }
    }

    public SignInPage gotToSignInPage(){
        this.signinButton.click();
        return new SignInPage();
    }
}
