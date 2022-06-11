package org.sonam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sonam.base.TestBase;
import java.util.*;

public class MarketDataCalender extends TestBase {
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[1]")
    WebElement dateDayNo;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[2]/span")
    WebElement dateMonth;
    @FindBy(xpath = "//*[@id=\"fin-cal-events\"]/div[2]/ul/li[5]/div/span[3]/span")
    WebElement dateDay;
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/div/div[2]/div/div/div[5]/div/div/div/div[2]/ul/li[5]")
    WebElement valuesListElement;
    List<WebElement> valuesList;

    public MarketDataCalender() {
        PageFactory.initElements(webDriver, this);
        wait.until(ExpectedConditions.visibilityOf(valuesListElement));
    }

    /*public HashMap<String, Integer> getValuesHashMap(){
        HashMap<String, Integer> valuesHashmap = new HashMap<>();
        valuesHashmap.put(getEarningsString(), getEarningsValue());
        valuesHashmap.put(getStockSplitsString(), getStockSplitsValue());
        valuesHashmap.put(getIPO_PricingString(), getIPO_PricingValue());
        valuesHashmap.put(getEconomicEventsString(), getEconomicEventsValue());

        return valuesHashmap;
    }*/

    public List<WebElement> getValuesList() {
        valuesList = valuesListElement.findElements(By.tagName("a"));
        return valuesList;
    }

    public WebElement getEarningsElement(){
        return valuesListElement.findElement(By.cssSelector("a[style='background-color:#b6e0ff']"));
    }

    public WebElement getStockSplitsElement(){
        return valuesListElement.findElement(By.cssSelector("a[style='background-color:#ffcfb8']"));
    }

    public WebElement getIPO_PricingElement(){
        return valuesListElement.findElement(By.cssSelector("a[style='background-color:#e7ccff']"));
    }

    public WebElement getEconomicEventsElement(){
        return valuesListElement.findElement(By.cssSelector("a[style='background-color:#9debc2']"));
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
}
