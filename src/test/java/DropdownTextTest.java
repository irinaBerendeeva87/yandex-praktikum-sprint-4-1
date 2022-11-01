import dropdowntext.HomePageScooter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DropdownTextTest {
    HomePageScooter objHomePage;
    WebDriver driver;

    @Before
    public void before() {
        //драйвер для браузера Chrome
        //создание экземпляра драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Найди раздел «Вопросы о важном» и сделать скролл до неё
        WebElement element = driver.findElement(By.cssSelector(".Home_FAQ__3uVm4"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        // создай объект класса главной страницы приложения
        objHomePage = new HomePageScooter(driver);
    }

    @Test
    public void checkAccordion0() {
        objHomePage.clickPanel(0);
        Assert.assertTrue(objHomePage.isPanelVisible(0));
    }

    @Test
    public void checkAccordion1() {
        objHomePage.clickPanel(1);
        Assert.assertTrue(objHomePage.isPanelVisible(1));
    }

    @Test
    public void checkAccordion2() {
        objHomePage.clickPanel(2);
        Assert.assertTrue(objHomePage.isPanelVisible(2));
    }

    @Test
    public void checkAccordion3() {
        objHomePage.clickPanel(3);
        Assert.assertTrue(objHomePage.isPanelVisible(3));
    }

    @Test
    public void checkAccordion4() {
        objHomePage.clickPanel(4);
        Assert.assertTrue(objHomePage.isPanelVisible(4));
    }

    @Test
    public void checkAccordion5() {
        objHomePage.clickPanel(5);
        Assert.assertTrue(objHomePage.isPanelVisible(5));
    }

    @Test
    public void checkAccordion6() {
        objHomePage.clickPanel(6);
        Assert.assertTrue(objHomePage.isPanelVisible(6));
    }

    @Test
    public void checkAccordion7() {
        objHomePage.clickPanel(7);
        Assert.assertTrue(objHomePage.isPanelVisible(7));
    }

    @After
    public void after() {
        // Закрыть браузер
        driver.quit();
    }
}