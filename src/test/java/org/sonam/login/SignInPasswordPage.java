package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonam.base.TestBase;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

public class SignInPasswordPage extends TestBase {
    @FindBy(id = "login-passwd")
    WebElement passwdInput;
    @FindBy(id = "login-signin")
    WebElement nextButton;

    public SignInPasswordPage() {
        PageFactory.initElements(webDriver, this);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("login-passwd"))));
    }

    public HomePage gotToHomePage(String password){
        passwdInput.sendKeys(password);
        nextButton.click();
        return new HomePage();
    }
}
