package com.base;


import attd.selenium.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseChromeTest {
    protected WebDriver chrome;

    @BeforeTest
    public void configureBrowser(){
        chrome = WebDriverFactory.configureChrome();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeBrowser(){
        chrome.quit();
    }

}
