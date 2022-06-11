package org.sonam.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonam.util.PropertiesLoader;

import java.time.Duration;

public class TestBase {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public static void initialisation(String browserName, String url){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        //can add additional browsers (e.g. else if browser name = firefox)
        wait = new WebDriverWait(webDriver, Duration.ofMillis(3000));
        webDriver.get(url);
    }

    public static void close(){
        webDriver.quit();
    }
}
