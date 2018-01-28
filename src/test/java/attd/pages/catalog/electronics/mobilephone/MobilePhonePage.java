package attd.pages.catalog.electronics.mobilephone;

import attd.pages.AbstractFilterPage;
import attd.selenium.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class MobilePhonePage extends AbstractFilterPage {

    private final String filterMore = "schema-filter-control__item";
    private final String manufacturerCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(3)";
    private final String priceCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(4)";
    //  private final String shopCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(5)";
    private final String dateCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(6)";
    private final String operatingSystemCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(7)";
    private final String screenSizeCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(8)";
    private final String screenResolutionCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(9)";
    private final String screenTechnologyCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(10)";
    private final String platformCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(11)";
    private final String ramCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(12)";
    private final String flashCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(13)";
    private final String memoryCardCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(14)";
    private final String cameraCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(15)";
    private final String quantitySimCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(16)";
    private final String formatSimCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(17)";
    private final String lteCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(18)";
    private final String bodyColorCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(19)";
    private final String dustMoistureProtectionCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(20)";
    private final String batteryCapacityCssLocator = "#schema-filter > div:nth-child(1) > div:nth-child(21)";


    public MobilePhonePage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonePage open() {
        open("https://catalog.onliner.by/mobile");
        return this;
    }

    // Производитель
    public MobilePhonePage filterByManufacturer(String... args) {
        WebElement manufacturer = this.findByCss(manufacturerCssLocator);
        this.clickAllCheckBoxesInBlockFilter(manufacturer, filterMore, args);
        return this;
    }

    // Минимальная цена в предложениях магазинов
    public MobilePhonePage filterByPrice(String from, String to) {
        WebElement price = this.findByCss(priceCssLocator);
        String attributeInputPlaceHolderFrom = "от";
        String attributeInputPlaceHolderTo = "до";
        this.sendKeysInputsFromTo(price, attributeInputPlaceHolderFrom, attributeInputPlaceHolderTo, from, to);
        return this;
    }

    /*
        // Магазины
        public MobilePhonePage filterByShop(String... args){
            WebElement shop = this.findByCss(shopCssLocator);
            this.clickAllCheckBoxesInBlockFilter(shop, filterMore, args);
            return this;
        }
    */
    // Дата выхода на рынок
    public MobilePhonePage filterByDateCheckBox(String... args) {
        WebElement date = this.findByCss(dateCssLocator);
        this.clickAllCheckBoxesInBlockFilter(date, args);
        return this;
    }

    public MobilePhonePage filterByDateInterval(String from, String to) {
        WebElement date = this.findByCss(dateCssLocator);
        String attributeInputPlaceHolderFrom = "2000";
        String attributeInputPlaceHolderTo = "2018";
        this.sendKeysInputsFromTo(date, attributeInputPlaceHolderFrom, attributeInputPlaceHolderTo, from, to);
        return this;
    }

    // Операционная система
    public MobilePhonePage filterByOS(String... args) {
        WebElement operatingSystem = this.findByCss(operatingSystemCssLocator);
        this.clickAllCheckBoxesInBlockFilter(operatingSystem, filterMore, args);
        return this;
    }

    // Размер экрана
    public MobilePhonePage filterByScreenSizeCheckBoxes(String... args) {
        WebElement size = this.findByCss(screenSizeCssLocator);
        this.clickAllCheckBoxesInBlockFilter(size, args);
        return this;
    }

    public MobilePhonePage filterByScreenSizeInterval(String from, String to) {
        WebElement size = this.findByCss(screenSizeCssLocator);
        this.selectElementsFromTo(size, from, to);
        return this;
    }

    //Разрешение экрана
    public MobilePhonePage filterByScreenResolutionCheckBoxes(String... args) {
        WebElement size = this.findByCss(screenResolutionCssLocator);
        this.clickAllCheckBoxesInBlockFilter(size, args);
        return this;
    }

    public MobilePhonePage filterByScreenResolutionInterval(String from, String to) {
        WebElement size = this.findByCss(screenResolutionCssLocator);
        this.selectElementsFromTo(size, from, to);
        return this;
    }

    //Технология экрана
    public MobilePhonePage filterByScreenTechnology(String... args) {
        WebElement shop = this.findByCss(screenTechnologyCssLocator);
        this.clickAllCheckBoxesInBlockFilter(shop, args);
        return this;
    }

    //Платформа
    public MobilePhonePage filterByPlatform(String... args) {
        WebElement operatingSystem = this.findByCss(platformCssLocator);
        this.clickAllCheckBoxesInBlockFilter(operatingSystem, filterMore, args);
        return this;
    }

    //Оперативная память
    public MobilePhonePage filterByRAMCheckBoxes(String... args) {
        WebElement size = this.findByCss(ramCssLocator);
        this.clickAllCheckBoxesInBlockFilter(size, args);
        return this;
    }

    public MobilePhonePage filterByRAMInterval(String from, String to) {
        WebElement size = this.findByCss(ramCssLocator);
        this.selectElementsFromTo(size, from, to);
        return this;
    }

    //Флэш память
    public MobilePhonePage filterByFlashCheckBoxes(String... args) {
        WebElement size = this.findByCss(flashCssLocator);
        this.clickAllCheckBoxesInBlockFilter(size, args);
        return this;
    }

    public MobilePhonePage filterByFlashInterval(String from, String to) {
        WebElement size = this.findByCss(flashCssLocator);
        this.selectElementsFromTo(size, from, to);
        return this;
    }

    //Поддержка карт памяти
    public MobilePhonePage filterByMemoryCard(String input) {
        WebElement memoryCard = this.findByCss(memoryCardCssLocator);
        this.clickYesOrNo(memoryCard, input);
        return this;
    }

    //Камера, Мп
    public MobilePhonePage filterByCameraCheckBox(String... args) {
        WebElement camera = this.findByCss(cameraCssLocator);
        this.clickAllCheckBoxesInBlockFilter(camera, args);
        return this;
    }

    public MobilePhonePage filterByCameraInterval(String from, String to) {
        WebElement camera = this.findByCss(cameraCssLocator);
        String attributeInputPlaceHolderFrom = "0.08";
        String attributeInputPlaceHolderTo = "23";
        this.sendKeysInputsFromTo(camera, attributeInputPlaceHolderFrom, attributeInputPlaceHolderTo, from, to);
        return this;
    }

    //Количество SIM-карт
    public MobilePhonePage filterByQuantitySim(String... args) {
        WebElement quantitySim = this.findByCss(quantitySimCssLocator);
        this.clickAllCheckBoxesInBlockFilter(quantitySim, args);
        return this;
    }

    //Формат SIM-карты
    public MobilePhonePage filterByFormatSim(String... args) {
        WebElement formatSim = this.findByCss(formatSimCssLocator);
        this.clickAllCheckBoxesInBlockFilter(formatSim, args);
        return this;
    }

    //LTE
    public MobilePhonePage filterByLTE() {
        WebElement lte = this.findByCss(lteCssLocator);
        this.oneClickCheckBox(lte);
        return this;
    }

    //Цвет корпуса
    public MobilePhonePage filterByBodyColor(String... args) {
        WebElement bodyColor = this.findByCss(bodyColorCssLocator);
        this.clickAllCheckBoxesInBlockFilter(bodyColor, filterMore, args);
        return this;
    }

    //Пыле- и влагозащита
    public MobilePhonePage filterByDustMoistureProtection() {
        WebElement dustMoistureProtection = this.findByCss(dustMoistureProtectionCssLocator);
        this.oneClickCheckBox(dustMoistureProtection);
        return this;
    }

    //Емкость аккумулятора, мАч
    public MobilePhonePage filterByBatteryCapacityCheckBox(String... args) {
        WebElement batteryCapacity = this.findByCss(batteryCapacityCssLocator);
        this.clickAllCheckBoxesInBlockFilter(batteryCapacity, args);
        return this;
    }

    public MobilePhonePage filterByBatteryCapacityInterval(String from, String to) {
        WebElement batteryCapacity = this.findByCss(batteryCapacityCssLocator);
        String attributeInputPlaceHolderFrom = "220";
        String attributeInputPlaceHolderTo = "12000";
        this.sendKeysInputsFromTo(batteryCapacity, attributeInputPlaceHolderFrom, attributeInputPlaceHolderTo, from, to);
        return this;
    }

}
