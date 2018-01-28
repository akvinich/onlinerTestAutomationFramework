package attd.selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

    public static WebDriver configureFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\WebDrivers\\geckodriver.exe");
        FirefoxProfile profile = new ProfilesIni().getProfile("selenium");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxDriver(capabilities);
    }

    public static WebDriver configureChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDrivers\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setJavascriptEnabled(true);
        return new ChromeDriver(capabilities);
    }
}
