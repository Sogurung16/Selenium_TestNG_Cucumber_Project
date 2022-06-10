package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonam.base.TestBase;

import java.time.Duration;

public class SignInUsernamePage extends TestBase{
    @FindBy(id = "login-username")
    WebElement usernameInput;
    @FindBy(id = "login-signin")
    WebElement nextButton;

    public SignInUsernamePage() {
        PageFactory.initElements(webDriver, this);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("login-username"))));
    }

    public SignInPasswordPage goToSignInPasswordPage(String username){
        usernameInput.sendKeys(username);
        nextButton.click();
        return new SignInPasswordPage();
    }
}
