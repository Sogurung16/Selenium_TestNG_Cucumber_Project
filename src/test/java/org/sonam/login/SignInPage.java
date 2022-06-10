package org.sonam.login;

import org.openqa.selenium.support.PageFactory;
import org.sonam.base.TestBase;
import org.testng.annotations.Test;

public class SignInPage extends TestBase{

    public SignInPage() {
        PageFactory.initElements(webDriver, this);
    }
}
