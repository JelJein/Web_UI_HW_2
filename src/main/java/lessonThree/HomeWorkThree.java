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

        WebElement headerToExit = driver.findElement(By.cssSelector(".s-header-item--user"));
        headerToExit.click();

        driver.navigate().to("https://www.livejournal.com/logout.bml?ret=1&user=testingonetv&sessid=93");

        WebElement exitButton = driver.findElement(By.xpath("//button[contains(text(),'Выход')]"));
        exitButton.click();

        driver.quit();
    }



}
