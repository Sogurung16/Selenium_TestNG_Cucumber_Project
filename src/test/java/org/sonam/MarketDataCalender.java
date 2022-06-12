package org.sonam;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MarketDataCalender extends TestBase {
    /*@FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[1]")
    WebElement dateDayNo;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[2]/span")
    WebElement dateMonth;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[3]/span")
    WebElement dateDay;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[1]/div/div/div/div")
    WebElement calendarDropDownButton;
    @FindBy(xpath = "//*[@id=\"dropdown-menu\"]/div[3]/div/div[1]/form/input")
    WebElement dateSelector;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/ul/li[5]")
    WebElement valuesListElement;
    List<WebElement> valuesList;

    LocalDate testDate;*/

    WebElement dateSelector;
    WebElement applyDateChangeButton;
    WebElement calendarDropDownButton;

    public MarketDataCalender() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/ul/li[5]"
        )));
        calendarDropDownButton = webDriver.findElement(By
                .xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[1]/div/div/div/div"));
        //PageFactory.initElements(webDriver, this);

    }

    public CalendarPage submitDate(LocalDate date){
        Actions action = new Actions(webDriver);
        action.click(calendarDropDownButton).build().perform();

        dateSelector = webDriver.findElement(By
                .xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[1]/div/div/div/div[2]/div[3]/div/div[1]/form/input"));

        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(dateSelector)))
                .click().build().perform();

        dateSelector.clear();

        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        action.sendKeys(dateSelector, simpleDateFormat.format(date)).build().perform();
        applyDateChangeButton= webDriver.findElement(By
                .xpath("//*[@id=\"dropdown-menu\"]/div[3]/div/div[1]/form/button"));
        action.click(applyDateChangeButton).build().perform();
        return new CalendarPage();
    }
}
