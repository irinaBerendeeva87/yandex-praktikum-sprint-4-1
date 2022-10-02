import orderScooter.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    OrderScooter objOrderScooter;
    WebDriver driver;
    private final String username;
    private final String surname;
    private final String address;
    private final String phonenumber;

    public OrderScooterTest(String username, String surname, String address, String phonenumber) {
        this.username = username;
        this.surname = surname;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    @Parameterized.Parameters  // добавили аннотацию
    public static String[][] gerOrderData() {
        return new String[][]{
                {"Анна", "Виноградова", "винокурова-22", "89999999999"},
                {"Олег", "Егоров", "Москва", "89999999699"}
        };
    }

    @Before
    public void before() {
        //драйвер для браузера Chrome
        //создание экземпляра драйвера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru");
        // создай объект класса главной страницы приложения
        objOrderScooter = new OrderScooter(driver);
    }

    @Test
    public void orderPositive1() {
        objOrderScooter.clickOrderButtonHeader();
        createOrder();
    }

    @Test
    public void orderPositiveMiddleButton() {
        objOrderScooter.scrollToMiddleButton();
        objOrderScooter.clickOrderButtonMiddle();
        createOrder();
    }

    private void createOrder() {
        objOrderScooter.confirmCookies();
        objOrderScooter.setUserName(username);
        objOrderScooter.setSurname(surname);
        objOrderScooter.setAdress(address);
        objOrderScooter.setMetro();
        objOrderScooter.setPhoneNumber(phonenumber);
        objOrderScooter.clickNextButton();
        objOrderScooter.setDeliveryDate();
        objOrderScooter.setDurationOrder();
        objOrderScooter.clickOrderScooterButton();
        objOrderScooter.clickYesInDialog();
        objOrderScooter.isPanelVisible();
    }


    @After
    public void after() {
        // Закрыть браузер
        driver.quit();
    }

}