package org.sonam.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sonam.base.TestBase;

public class SignInPasswordPage extends SignInUsernamePage {
    @FindBy(id = "login-passwd")
    WebElement passwdInput;

    public SignInPasswordPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void enterPassword(String password){
        passwdInput.sendKeys(password);
    }

    public SignInUsernamePage gotToSignInPage(){
        nextButton.click();
        return new SignInUsernamePage();
    }
}
