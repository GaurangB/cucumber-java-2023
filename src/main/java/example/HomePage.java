package example;

import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private final By inventoryContainer = By.cssSelector("#inventory_container");

    public boolean isHomePageDisplayed(){
        return $(inventoryContainer).isEnabled();
    }
}
