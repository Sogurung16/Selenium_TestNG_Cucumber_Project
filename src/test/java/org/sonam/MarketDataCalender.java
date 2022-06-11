package org.sonam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;
import org.sonam.nav.FinancePage;

public class MarketDataCalender extends TestBase {
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[1]")
    WebElement dateDayNo;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[2]/span")
    WebElement dateMonth;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[3]/span")
    WebElement dateDay;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]")
    WebElement valuesList;

    public MarketDataCalender() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOf(valuesList));
    }

    public boolean doesListValuesExists(){
        return valuesList.findElements(By.tagName("li")).isEmpty();
    }

    /*public FinancePage goToFinancePage(){
        financeTab.click();
        return new FinancePage();
    }*/

}
