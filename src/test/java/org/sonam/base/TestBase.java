package org.sonam.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v102.runtime.model.WebDriverValue;
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
            System.out.println(chromeOptions.setBrowserVersion("102.0.5005.61"));
            WebDriverManager.chromedriver()
                   .driverVersion("102.0.5005.61")
                   .browserVersion("102.0.5005.61")
                   .setup();
            //System.setProperty("webdriver.chrome.driver","D:/Driver/chromedriver_win32/chromedriver.exe");
            //WebDriverManager.chromedriver().setup();
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
