package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWorkThree {

    public static void main(String[] args) throws RuntimeException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        //Логин в систему

        WebElement hwFirst = driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        hwFirst.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"user\"]"));
        userName.sendKeys("TestingOneTV");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement userPassword = driver.findElement(By.xpath("//input[@id=\"lj_loginwidget_password\"]"));
        userPassword.sendKeys("JustForTest1987");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement checkBox = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        checkBox.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement enterButton = driver.findElement(By.xpath("//button[@name='action:login' and 'Войти']"));
        enterButton.click();

        //Тест работы ссылок

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://testingonetv.livejournal.com/pics/catalog");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://testingonetv.livejournal.com/video");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://www.livejournal.com/inbox/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://www.livejournal.com/for-authors/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Логаут из системы
        String head = ".s-header-item--user";

        WebElement headerClickExit = driver.findElement(By.cssSelector(head));
        headerClickExit.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://www.livejournal.com/logout.bml?ret=1&user=testingonetv&sessid=93");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement exitButton = driver.findElement(By.xpath("//button[contains(text(),'Выход')]"));
        exitButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }



}
