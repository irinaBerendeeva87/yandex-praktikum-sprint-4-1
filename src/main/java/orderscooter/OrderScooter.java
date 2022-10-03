package orderscooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderScooter {
    private final WebDriver driver;
    //  локатор для кнопки заказать в хедере
    private final By orderButtonHeader = By.className("Button_Button__ra12g");
    //  локатор для кнопки заказать в разделе "Как это работает"
    private final By orderButtonMiddle = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    // локатор для input Имя
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    // локатор для input Фамилия
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    // локатор для input Адрес
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор для input метро
    private final By metroField = By.xpath("//input[@class='select-search__input']");
    // локатор для input телефон
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //  локатор для кнопки далее
    private final By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    //  локатор для даты доставки
    private final By deliveryDateField = By.xpath("//div[@class = 'react-datepicker__input-container']/input");
    //  локатор для dropdown срок аренды
    private final By durationOrderField = By.xpath("//div[@class='Dropdown-root']");
    //  локатор для кнопки заказать
    private final By orderScooterButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[2]");
    //локатор на диалог
    private final By yesInDialog = By.xpath("//div[@class = 'Order_Modal__YZ-d3']");
    private final By confirmationDialog = By.className("Order_Modal__YZ-d3");
    //конструктор OrderScooter
    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }
    // метод клика на кнопку order
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }
    public void confirmCookies() {
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    public void scrollToMiddleButton() {
        WebElement element = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    // метод клика на кнопку order в разделе "Как это работает"
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }
    //метод  ввода именни в поле имя
    public void setUserName(String username) {
        driver.findElement(nameField).sendKeys(username);
    }
    //метод  ввода фамилии в поле Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
    //метод  ввода адреса в поле Адрес
    public void setAdress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //метод клика и  выбора метро в поле Метро
    public void setMetro() {
        driver.findElement(metroField).click();
        driver.findElement(By.xpath("//div[@class='select-search__select']/ul/li/button")).click();
    }
    //метод  ввода  номера телефона в поле телефон
    public void setPhoneNumber(String phonenumber) {
        driver.findElement(phoneField).sendKeys(phonenumber);
    }
    //метод клика на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //метод ввода даты доставки самоката
    public void setDeliveryDate() {
        driver.findElement(deliveryDateField).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__week'][2]/div[1]")).click();
    }
    //метод выбора продолжительности заказа
    public void setDurationOrder() {
        driver.findElement(durationOrderField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div")).click();
    }
    //метод клика на кнопку подтвержения заказа самоката
    public void clickOrderScooterButton() {
        driver.findElement(orderScooterButton).click();
    }
    public void clickYesInDialog() {
        driver.findElement(yesInDialog).click();
    }
    public Boolean isPanelVisible() {
        return driver.findElement(confirmationDialog).isDisplayed();
    }
}