package lessonThree;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWorkThree {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        // Логин в систему
        WebElement hwFirst = driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        hwFirst.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"user\"]"));
        userName.sendKeys("TestingOneTV");

        WebElement userPassword = driver.findElement(By.xpath("//input[@id=\"lj_loginwidget_password\"]"));
        userPassword.sendKeys("JustForTest1987");

        WebElement checkBox = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        checkBox.click();

        WebElement enterButton = driver.findElement(By.xpath("//button[@name='action:login' and 'Войти']"));
        enterButton.click();

        // Тест перехода в Мои фотографии
        String head = ".s-header-item--user";

        //WebElement headerClickPhoto = driver.findElement(By.cssSelector(head));
        //headerClickPhoto.click();

        driver.navigate().to("https://testingonetv.livejournal.com/pics/catalog");

        //WebElement myPhoto = driver.findElement(By.xpath("//a[contains(text(),'Мои фотографии')]"));
        //myPhoto.click();

        // Тест перехода в Мои видео
        //WebElement headerClickVideo = driver.findElement(By.cssSelector(head));
        //headerClickVideo.click();

        driver.navigate().to("https://testingonetv.livejournal.com/video");

        //WebElement myVideo = driver.findElement(By.xpath("//a[contains(text(),'Мое видео')]"));
        //myVideo.click();













        // Логаут из системы
        WebElement headerClickExit = driver.findElement(By.cssSelector(head));
        headerClickExit.click();

        driver.navigate().to("https://www.livejournal.com/logout.bml?ret=1&user=testingonetv&sessid=93");

        WebElement exitButton = driver.findElement(By.xpath("//button[contains(text(),'Выход')]"));
        exitButton.click();

        driver.quit();
    }



}
