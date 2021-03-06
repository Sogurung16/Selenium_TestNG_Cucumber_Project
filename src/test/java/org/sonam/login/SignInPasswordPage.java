package org.sonam.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;
import org.sonam.nav.HomePage;

public class SignInPasswordPage extends TestBase {
    @FindBy(id = "login-passwd")
    WebElement passwdInput;
    @FindBy(id = "login-signin")
    WebElement nextButton;

    public SignInPasswordPage() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOf(passwdInput));
    }

    public void enterPassword(String password){
        passwdInput.sendKeys(password);
    }
    public HomePage goToHomePage(){
        nextButton.click();
        return new HomePage();
    }
}
