package org.sonam.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.sonam.base.TestBase.webDriver;

public class HomePage {
    @FindBy(id = "login-passwd")
    WebElement passwdInput;

    public HomePage() {
        PageFactory.initElements(webDriver, this);
    }
}
