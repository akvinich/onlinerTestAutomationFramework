package attd.pages.catalog;

import attd.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends AbstractPage {

    public CatalogPage(WebDriver driver){
        super(driver);
    }

    public CatalogPage open() {
        open("https://catalog.onliner.by/");
        return this;
    }


/*
    public BaraholkaPage openBaraholka() {
        clickLink("Барахолка");
        return new BaraholkaPage(driver);
    }
*/
}
