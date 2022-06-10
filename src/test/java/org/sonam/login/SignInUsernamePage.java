package org.sonam.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonam.base.TestBase;
import org.testng.annotations.Test;

public class SignInPage extends TestBase{
    @FindBy(id = "login-username")
    WebElement usernameInput;

    public SignInPage() {
        PageFactory.initElements(webDriver, this);
    }

    public SignInPage gotToSignInPage(){
        this.signinButton.click();
        return new SignInPage();
    }
}
