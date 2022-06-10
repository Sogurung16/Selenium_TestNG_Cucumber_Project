package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;

public class SignInUsernamePage extends TestBase{
    @FindBy(id = "login-username")
    WebElement usernameInput;
    @FindBy(id = "login-signin")
    WebElement nextButton;

    public SignInUsernamePage() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("login-username"))));
    }

    public SignInPasswordPage goToSignInPasswordPage(String username){
        usernameInput.sendKeys(username);
        nextButton.click();
        return new SignInPasswordPage();
    }
}
