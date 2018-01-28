package attd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected final String script = "var object = arguments[0];"
            + "var theEvent = document.createEvent(\"MouseEvent\");"
            + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
            + "object.dispatchEvent(theEvent);"
            ;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String relativePath) {
        //driver.manage().window().maximize();
        driver.get(relativePath);
    }

    protected WebElement findByXPath(String xpathLocator) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpathLocator))));
    }

    protected WebElement findById(String id) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.id(id))));
    }

    protected WebElement findByCss(String cssLocator) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(cssLocator))));
    }

    protected WebElement findByClassName(String className) {
        return (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.className(className))));
    }

    protected void clickLink(String linkText) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.linkText(linkText)))).click();
    }

    protected void clickPartLink(String linkText) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.partialLinkText(linkText)))).click();
    }

    protected void clickPsevdoElementBeforeCss(String beforeElementCSS) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement el =  (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(beforeElementCSS))));
        js.executeScript("arguments[0].click()", el);
    }

    protected void clickPsevdoElementBeforeXpath(String beforeElementXpath) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement el =  (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated((By.xpath(beforeElementXpath))));
        js.executeScript("arguments[0].click()", el);
    }

    protected void waitCompletedAllAjaxConnections(){
        new WebDriverWait(driver, 4000).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }

}
