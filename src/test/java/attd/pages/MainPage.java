package attd.pages;


import attd.pages.catalog.CatalogPage;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        open("https://www.onliner.by/");
        return this;
    }

    public CatalogPage openCatalog() {
        clickLink("Каталог");
        return new CatalogPage(driver);
    }
    /*
    public AvtoBaraholkaPage openAvtoBaraholka() {
        clickLink("Автобарахолка");
        return new AvtoBaraholkaPage(driver);
    }

    public HousesAndRoomsPage openHousesAndRooms() {
        clickLink("Дома и квартиры");
        return new HousesAndRoomsPage(driver);
    }

    public Services openServices() {
        clickPartLink("Услуги");
        return new Services(driver);
    }

    public BaraholkaPage openBaraholka() {
        clickLink("Барахолка");
        return new BaraholkaPage(driver);
    }
    */



}
