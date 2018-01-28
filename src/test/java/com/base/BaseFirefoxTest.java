package com.base;

import attd.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseFirefoxTest {
    protected WebDriver firefox;

    @BeforeTest
    public void configureBrowser(){
        firefox = WebDriverFactory.configureFirefox();
        firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser() {
        firefox.quit();
    }

}
