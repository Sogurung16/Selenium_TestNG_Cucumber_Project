package org.sonam.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sonam.util.PropertiesLoader;

import java.util.Properties;

public class TestBase {
    public static WebDriver webDriver;

    public static void initialisation(){
        String browserName = PropertiesLoader.getProperties().getProperty("BrowserName");
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        //can add additional browsers (e.g. else if browser name = firefox)
        String URL = PropertiesLoader.getProperties().getProperty("URL");
        webDriver.get(URL);
    }
}
