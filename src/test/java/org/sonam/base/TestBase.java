package org.sonam.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sonam.util.PropertiesLoader;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public static void initialisation(String browserName, String url){
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-dev-shm-usage","--start-maximized","--disable-extensions","--no-sandbox");
            //System.setProperty("webdriver.chrome.driver","D:/Driver/chromedriver_win32/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver(chromeOptions);
        }
        //can add additional browsers (e.g. else if browser name = firefox)
        wait = new WebDriverWait(webDriver, Duration.ofMillis(3000));
        webDriver.get(url);
    }

    public static void close(){
        webDriver.quit();
    }
}
