package attd.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFilterPage extends AbstractPage{

    protected List<String> listStringProductLinks = new ArrayList<>();

    public AbstractFilterPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListStringProductLinks() {
        return listStringProductLinks;
    }

    public void setListStringProductLinks(){
        this.waitCompletedAllAjaxConnections();
        this.waitCompletedAllAjaxConnections();
        int countProduct;
        int countLink = this.findElementsByClassName("schema-pagination__pages-link").size();
        switch (countLink){
            case 0:
                System.out.println("Нет продуктов удовлетворяющих фильтрам!");
                break;
            case 1:
                this.waitCompletedAllAjaxConnections();
                countProduct = this.findElementsByClassName("schema-product__title").size();
                System.out.println(countProduct);
                if(countProduct != 0){
                    this.waitCompletedAllAjaxConnections();
                    List<WebElement> productLinks = this.findElementsByClassName("schema-product__title");
                    for(int i=0; i<countProduct; i++){
                        this.waitCompletedAllAjaxConnections();
                        listStringProductLinks.add(productLinks.get(i).findElement(By.tagName("a")).getAttribute("href"));
                        this.waitCompletedAllAjaxConnections();
                    }
                    this.waitCompletedAllAjaxConnections();
                }
                break;
            default:
                for(int j=0; j<countLink; j++){
                    this.waitCompletedAllAjaxConnections();
                    System.out.println(j+"__");
                    countProduct = this.findElementsByClassName("schema-product__title").size();
                    if(countProduct != 0){
                        this.waitCompletedAllAjaxConnections();
                        List<WebElement> productLinks = this.findElementsByClassName("schema-product__title");
                        int countProductLink = productLinks.size();
                        for(int i=0; i<countProductLink; i++){
                            this.waitCompletedAllAjaxConnections();
                            listStringProductLinks.add(productLinks.get(i).findElement(By.tagName("a")).getAttribute("href"));
                        }
                        if(j != countLink-1){
                            WebElement el = this.findById("schema-pagination");
                            if (el.isDisplayed()){
                                el.click();
                            }
                            this.waitCompletedAllAjaxConnections();
                        }
                    }
                }
                break;
        }


    }

    protected List<WebElement> findElementsByClassName(String className){
        return driver.findElements(By.className(className));
    }

    protected void oneClickCheckBox(WebElement mainBlock){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = mainBlock.findElement(By.cssSelector("input"));
        js.executeScript(script, element);
    }

    protected void clickYesOrNo(WebElement mainBlock, String input){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        List<WebElement> listElements = mainBlock.findElements(By.cssSelector("input"));
        if (listElements.size() == 2){
            switch (input.toUpperCase()){
                case "ДА":
                    js.executeScript(script, listElements.get(0));
                    break;
                case "НЕТ":
                    js.executeScript(script, listElements.get(1));
                    break;
                default:
                    throw new RuntimeException("Exception!");
            }
        }
    }

    protected void sendKeysInputsFromTo(WebElement mainBlock, String placeHolderFrom, String placeHolderTo, String from, String to){
        WebElement needElementFrom = mainBlock.findElement(By.cssSelector("input[placeholder='"+ placeHolderFrom +"']"));
        WebElement needElementTo = mainBlock.findElement(By.cssSelector("input[placeholder='"+ placeHolderTo +"']"));
        needElementFrom.clear();
        needElementFrom.sendKeys(from);
        needElementTo.clear();
        needElementTo.sendKeys(to);
    }

    protected void selectElementsFromTo(WebElement mainBlock, String from, String to){
        List<WebElement> listElements = mainBlock.findElements(By.cssSelector("select"));
        if (listElements.size() == 2){
            new Select(listElements.get(0)).selectByVisibleText(from);
            new Select(listElements.get(1)).selectByVisibleText(to);
        }
        else{
            throw new RuntimeException("Exception!");
        }
    }

    protected void clickAllCheckBoxesInBlockFilter(WebElement mainBlock, String allVariantsClassName,  String... args){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for(String entry:args) {
            WebElement needElement = mainBlock.findElement(By.xpath("descendant::span[. = '" + entry + "' ]"));
            if (needElement.isDisplayed()) {
                js.executeScript(script, needElement);
            } else {
                WebElement allVariants = mainBlock.findElement(By.className(allVariantsClassName));
                js.executeScript(script, allVariants);
                js.executeScript(script, needElement);
                js.executeScript(script, allVariants);
            }
        }

    }

    protected void clickAllCheckBoxesInBlockFilter(WebElement mainBlock,  String... args){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        for(String entry:args) {
            WebElement needElement = mainBlock.findElement(By.xpath("descendant::span[. = '" + entry + "' ]"));
            if (needElement.isDisplayed()) {
                js.executeScript(script, needElement);
            }
        }
    }





//==========================================================================================
    public class FilterPage<T extends AbstractFilterPage>{
        public T clickPsevdoElementBeforeXpath(T page, String... entry){
            for(String args:entry){
                page.clickPsevdoElementBeforeXpath("descendant::span[. = '"+ args +"' ]");
            }
            return page;
        }

        public T clickElementInElementByXpath(T page, WebElement mainBlock, String allVariantsClassName,  String... args){
            for(String entry:args){
                WebElement needElement = mainBlock.findElement(By.xpath("//span[. = '"+ entry +"' ]"));
                if(needElement.isDisplayed()){
                    ((JavascriptExecutor)driver).executeScript(script, needElement);
                }
                else {
                    WebElement allVariants = mainBlock.findElement(By.className(allVariantsClassName));
                    ((JavascriptExecutor)driver).executeScript(script, allVariants);
                    ((JavascriptExecutor)driver).executeScript(script, needElement);
                    ((JavascriptExecutor)driver).executeScript(script, allVariants);
                }
            }
            return page;
        }

    }
}
