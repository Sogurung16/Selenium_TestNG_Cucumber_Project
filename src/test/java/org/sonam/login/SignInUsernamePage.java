package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;

import java.time.Duration;

public class SignInUsernamePage extends TestBase{
    @FindBy(id = "login-username")
    WebElement usernameInput;
    @FindBy(id = "login-signin")
    WebElement nextButton;

    public SignInUsernamePage() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("login-username"))));
    }

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public SignInPasswordPage goToSignInPasswordPage(){
        nextButton.click();
        return new SignInPasswordPage();
    }
}
