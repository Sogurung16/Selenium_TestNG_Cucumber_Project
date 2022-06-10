package org.sonam.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;
import org.sonam.nav.FinancePage;

public class HomePage extends TestBase {
    @FindBy(id = "root_8")
    WebElement financeTab;

    public HomePage() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("root_8"))));
    }

    public FinancePage goToFinancePage(){
        financeTab.click();
        return new FinancePage();
    }
}
