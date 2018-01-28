package attd.pages.catalog.electronics.mobilephone;

import attd.pages.AbstractAnalysisPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MobilePhoneAnalysisPage extends AbstractAnalysisPage{

    //-------------------------------
    private final String productNameXpathLocator = "//*[@id=\"container\"]/div/div[2]/div/div/div[2]/div[1]/div/div[3]/h1";
    private final String priceXpathLocator = "//*[@id=\"product-prices-container\"]/div/div[1]/div[1]/a";
    //-------------------------------
    private final String date = "Дата выхода на рынок";
    private final String os = "Операционная система";
    private final String screenSize = "Размер экрана";
    private final String screenResolution = "Разрешение экрана";
    private final String screenTechnology = "Технология экрана";
    private final String platform = "Платформа";
    private final String ram = "Оперативная память";
    private final String flash = "Флэш-память";
    private final String memoryCard = "Поддержка карт памяти";
    private final String camera = "Количество точек матрицы";
    private final String quantitySim = "Количество SIM-карт";
    private final String formatSim = "Формат SIM-карты";
    private final String lte = "LTE";
    private final String bodyColor = "Цвет корпуса";
    private final String dustMoistureProtection = "Пыле- и влагозащита";
    private final String batteryCapacity = "Ёмкость аккумулятора";

    public MobilePhoneAnalysisPage(WebDriver driver) {
        super(driver);
    }


    public MobilePhoneAnalysisPage openPage(String str){
        this.open(str);
        WebElement table = this.findByClassName(tableProductClassName);
        mainList = table.findElements(By.tagName("td"));
        return this;
    }

    public void closePage(){
        driver.quit();
    }
//====================================
    public String getProductName() {
        String productName = this.findByXPath(productNameXpathLocator).getText();
        return productName;
    }

    public Double[] getPrice() {
        String parseResult = this.findByXPath(priceXpathLocator).getText().replace(',','.').replace(" ","");
        String[] array = this.findAndSplitString(parseResult,regNumberWithDot,regDividerMinus);
        return convertArrayStringToDouble(array);
    }

    public Integer getDate() {
        String parseResult = this.findNeedElementByText(date).getText();
        return Integer.parseInt(this.findInString(parseResult, regNumberWithDot));
    }

    public String getOs() {
        return this.findNeedElementByText(os).getText().trim();
    }

    public Double getScreenSize() {
        return Double.parseDouble(this.findNeedElementByText(screenSize).getText().replace('"',' ').trim());
    }

    public Integer[] getScreenResolution() {
        String parseResult = this.findNeedElementByText(screenResolution).getText().trim();
        String[] arrayString = this.findAndSplitString(parseResult,regNumberWithDot,regDividerX);
        return convertArrayStringToInt(arrayString);
    }

    public String getScreenTechnology() {
        return this.findNeedElementByText(screenTechnology).getText().trim();
    }

    public String getPlatform() {
        return this.findNeedElementByText(platform).getText().trim();
    }
    //------------------------
    public String getRam() { return ram;
    }
    //-----------------
    public String getFlash() {
        return flash;
    }
    //---------------------
    public String getMemoryCard() {
        return this.getYesOrNo(this.findNeedElementByText(memoryCard));
    }
    //----------------------
    public Double getCamera() {
        String parseResult = this.findNeedElementByText(camera).getText().trim();
        return Double.parseDouble(this.findInString(parseResult, regNumberWithDot));
    }

    public Integer getQuantitySim() {
        return Integer.parseInt(this.findNeedElementByText(quantitySim).getText().trim());
    }

    public String[] getFormatSim() {
        String parseResult = this.findNeedElementByText(formatSim).getText().replace(" ","");
        return this.splitString(parseResult, regDividerComma);
    }

    public String getLte() {
        return this.getYesOrNo(this.findNeedElementByText(lte));
    }

    public String getBodyColor() {
        return this.findNeedElementByText(bodyColor).getText().trim();
    }

    public String getDustMoistureProtection() {
        return this.getYesOrNo(this.findNeedElementByText(dustMoistureProtection));
    }

    public Double getBatteryCapacity() {
        String parseResult = this.findNeedElementByText(batteryCapacity).getText().replace(" ", "").replace(',','.');
        return Double.parseDouble(this.findInString(parseResult, regNumberWithDot));
    }


}
