package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class HwThreeTest {

    public static void main(String[] args) throws RuntimeException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com/");

        WebElement hwFirst = driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        hwFirst.click();

        Integer fast = 250;
        Integer slow = 3000;

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"user\"]"));
        userName.sendKeys("TestingOneTV");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement userPassword = driver.findElement(By.xpath("//input[@id=\"lj_loginwidget_password\"]"));
        userPassword.sendKeys("JustForTest1987");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement checkBox = driver.findElement(By.cssSelector(".b-loginform-checkbox__control"));
        checkBox.click();

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement enterButton = driver.findElement(By.xpath("//button[@name='action:login' and 'Войти']"));
        enterButton.click();

        //Тест работы ссылок

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://testingonetv.livejournal.com/pics/catalog");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://testingonetv.livejournal.com/video");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://www.livejournal.com/inbox/");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.navigate().to("https://www.livejournal.com/for-authors/");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Заполняем профиль

        driver.navigate().to("https://www.livejournal.com/manage/profile/?authas=");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement genderFemale = driver.findElement(By.xpath("//select[@name='gender']"));
        genderFemale.click();
        genderFemale.sendKeys("Женский");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement genderMale = driver.findElement(By.xpath("//select[@name='gender']"));
        genderMale.click();
        genderMale.sendKeys("Мужской");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement day = driver.findElement(By.xpath("//select[@name='day']"));
        day.sendKeys("25");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement month = driver.findElement(By.xpath("//select[@name='month']"));
        month.sendKeys("Май");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement year = driver.findElement(By.xpath("//select[@name='year']"));
        year.sendKeys("1987");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement whoShareBDay = driver.findElement(By.xpath("//select[@name='opt_sharebday']"));
        whoShareBDay.sendKeys("Всем");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement howShareBDay = driver.findElement(By.xpath("//select[@name='opt_showbday']"));
        howShareBDay.sendKeys("месяц, день и год");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Логаут из системы

        driver.navigate().to("https://www.livejournal.com/logout.bml?ret=1&user=testingonetv&sessid=93");

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement exitButton = driver.findElement(By.xpath("//button[contains(text(),'Выход')]"));
        exitButton.click();

        try {
            Thread.sleep(fast);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
