package dropdowntext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    private final WebDriver driver;
    private int index;
    //  локатор для dropdown
    private final By locator = By.id("accordion__panel-" + index);
    //  локатор для панели
    private final By panel = By.id("accordion__heading-" + index);
    // метод отображения аккордиона после к клика
    public Boolean isPanelVisible(int index) {
        return driver.findElement(locator).isDisplayed();
    }

    // метод клика на стрелку
    public void clickPanel(int index) {
        driver.findElement(locator).click();
    }

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }
}