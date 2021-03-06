package uk.gov.harrow.testbase;/*
 *Vinay Creation
 *Date of Creation
 */

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import uk.gov.harrow.browserselector.BrowserSelector;
import uk.gov.harrow.loadproperty.LoadProperty;
import uk.gov.harrow.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class TestBase extends HomePage {
    BrowserSelector selectBrowser = new BrowserSelector();
    LoadProperty loadProperty = new LoadProperty();

    String baseUrl = loadProperty.getProperty("baseUrl");
    String browser = loadProperty.getProperty("browser");

    @BeforeMethod
    public void openBrowser() {

        selectBrowser.selectBrowser(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

