package org.sonam.nav;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.CalendarPage;
import org.sonam.base.TestBase;

import java.time.Duration;

public class FinancePage extends TestBase {

    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/nav/div/div/div/div[3]/div/nav/ul/li[2]/div[1]")
    WebElement marketDataTab;
    @FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/nav/ul/li[2]/div[2]/ul/li[1]/a")
    WebElement calender;

    public FinancePage() {
        PageFactory.initElements(webDriver, this);
        wait.withTimeout(Duration.ofMillis(5000));
        //wait.until(ExpectedConditions.visibilityOf(marketDataTab));
    }

    public CalendarPage goToMarketDataCalenderPage() {
        Actions action = new Actions(webDriver);
        action.moveToElement(marketDataTab).build().perform();
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(calender)))
                .click().build().perform();
        return new CalendarPage();
    }
}
