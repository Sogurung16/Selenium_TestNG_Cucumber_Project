package org.sonam.nav;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;

public class FinancePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/nav/ul/li[2]/div[1]")
    WebElement marketDataTab;
    @FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav\"]/div/div[3]/div/nav/ul/li[2]/div[2]/ul/li[1]/a")
    WebElement calender;

    public FinancePage() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOf(marketDataTab));
    }

    public MarketDataCalender goToMarketDataCalenderPage(){
        Actions action = new Actions(webDriver);
        action.moveToElement(marketDataTab).perform();
        wait.until(ExpectedConditions.visibilityOf(calender));
        calender.click();
        return new MarketDataCalender();
    }
}
