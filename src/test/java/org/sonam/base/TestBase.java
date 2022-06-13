package org.sonam.base;

import io.cucumber.java.hu.De;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    public static void initialisation(String browserName, String url){
        if(browserName.equalsIgnoreCase("edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--disable-dev-shm-usage","--disable-extensions","--no-sandbox");
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver(edgeOptions);
        }
        //can add additional browsers (e.g. else if browser name = firefox)
        wait = new WebDriverWait(webDriver, Duration.ofMillis(3000));
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void close(){
        webDriver.quit();
    }
}
