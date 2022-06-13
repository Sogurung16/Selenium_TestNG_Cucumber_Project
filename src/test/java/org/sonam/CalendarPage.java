package org.sonam;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class CalendarPage extends TestBase {
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/ul/li[5]/div/span[1]")
    WebElement dateDayNo;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[2]/span")
    WebElement dateMonth;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[3]/span")
    WebElement dateDay;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[1]/div/div/div")
    WebElement calendarDropDownButton;
    @FindBy(xpath = "//*[@id=\"dropdown-menu\"]/div[3]/div/div[1]/form/button")
    WebElement applyDateChangeButton;
    @FindBy(xpath = "//*[@id=\"dropdown-menu\"]/div[3]/div/div[1]/form/input")
    WebElement dateSelector;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/ul/li[5]")
    WebElement valuesListElement;
    List<WebElement> valuesList;

    public CalendarPage() {
        PageFactory.initElements(webDriver, this);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dateDayNo));
    }

    public CalendarPage submitDate(LocalDate date){
        Actions action = new Actions(webDriver);
        action.click(calendarDropDownButton).build().perform();
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(dateSelector)))
                .click().build().perform();
        dateSelector.clear();
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        action.sendKeys(dateSelector, simpleDateFormat.format(date)).build().perform();
        action.click(applyDateChangeButton).build().perform();

        return new CalendarPage();
    }

    public HashMap<String, Integer> getValuesHashMap(){
        HashMap<String, Integer> valuesHashmap = new HashMap<>();
        valuesHashmap.put(getEarningsString(), getEarningsValue());
        valuesHashmap.put(getStockSplitsString(), getStockSplitsValue());
        valuesHashmap.put(getIPO_PricingString(), getIPO_PricingValue());
        valuesHashmap.put(getEconomicEventsString(), getEconomicEventsValue());

        return valuesHashmap;
    }

    public List<WebElement> getValuesList() {
        valuesList = valuesListElement.findElements(By.tagName("a"));
        return valuesList;
    }

    public WebElement getValueElement(By by){
        try{
            return valuesListElement.findElement(by);
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean isButtonClickable(WebElement element){
        boolean clickable = true;
        if(element!=null){
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch(TimeoutException timeoutException){
                timeoutException.printStackTrace();
                clickable = false;
            }
        }
        return clickable;
    }

    public WebElement getEarningsElement() {
        WebElement element;
        try {
            element = getValueElement(By.cssSelector("a[style='background-color:#b6e0ff']"));
        } catch (NoSuchElementException e) {
            e.getLocalizedMessage();
            element = null;
        }
        return element;
    }

    public WebElement getStockSplitsElement(){
        WebElement element;
        try {
            element = getValueElement(By.cssSelector("a[style='background-color:#ffcfb8']"));
        } catch (NoSuchElementException e) {
            e.getLocalizedMessage();
            element = null;
        }
        return element;
    }

    public WebElement getIPO_PricingElement(){
        WebElement element;
        try {
            element = getValueElement(By.cssSelector("a[style='background-color:#e7ccff']"));
        } catch (NoSuchElementException e) {
            e.getLocalizedMessage();
            element = null;
        }
        return element;
    }

    public WebElement getEconomicEventsElement(){
        WebElement element;
        try {
            element = getValueElement(By.cssSelector("a[style='background-color:#9debc2']"));
        } catch (NoSuchElementException e) {
            e.getLocalizedMessage();
            element = null;
        }
        return element;
    }

    public WebElement getDateDayNumElement(){
        return dateDayNo;
    }

    public WebElement getDateDayElement(){
        return dateDay;
    }

    public WebElement getDateMonthElement(){
        return dateMonth;
    }

    public int getValue(WebElement element){
        int value = 0;
        if(element!=null){
            value = Integer.parseInt(element
                    .getText()
                    .toLowerCase()
                    .replaceAll("\\D",""));
        }
        return value;
    }

    public int getEarningsValue() {
        return getValue(getEarningsElement());
    }

    public int getStockSplitsValue() {
        return getValue(getStockSplitsElement());
    }

    public int getIPO_PricingValue() {
        return getValue(getIPO_PricingElement());
    }

    public int getEconomicEventsValue() {
        return getValue(getEconomicEventsElement());
    }

    public String getValueTypeString(WebElement element){
        String valueTypeString = "";
        if(element!=null){
            valueTypeString =element
                    .getText()
                    .replaceAll("\\d","");
        }
        return valueTypeString.trim();
    }

    public String getEarningsString(){
        return getValueTypeString(getEarningsElement());
    }

    public String getStockSplitsString(){
        return getValueTypeString(getStockSplitsElement());
    }

    public String getIPO_PricingString(){
        return getValueTypeString(getIPO_PricingElement());
    }

    public String getEconomicEventsString(){
        return getValueTypeString(getEconomicEventsElement());
    }

    public String getDateDayNum(){
        return getDateDayNumElement().getText();
    }

    public String getDateDay(){
        return getDateDayElement().getText();
    }

    public String getDateMonth(){
        return getDateMonthElement().getText();
    }

    public String getBackgroundColor(WebElement element){
        return element.getCssValue("background-color");
    }
}
