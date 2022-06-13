package org.sonam.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.sonam.base.TestBase;
import org.sonam.util.ExcelDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"},
    features = "src/test/resources/featureFiles",
    glue = {"org.sonam.stepdefs"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @Parameters({"browser", "url","filePath","xssfSheet"})
    @BeforeMethod
    public static void startup(String browser, String url, String filePath, String xssfSheet){
        TestBase.initialisation(browser,url);
        ExcelDataProvider dataProvider = new ExcelDataProvider();
        dataProvider.getExcelData(filePath,xssfSheet);
    }
    @AfterMethod
    public static void tearDown(){
        TestBase.webDriver.close();
    }
}
