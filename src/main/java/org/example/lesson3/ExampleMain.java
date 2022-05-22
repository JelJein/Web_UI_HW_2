package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleMain {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless"); - не запуская браузер
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");

        WebElement webElement1 = driver.findElement(By.name("q"));
        WebElement webElement2 = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='q']"));

        try {
            WebElement webElementError = driver.findElement(By.name("error"));
        } catch (NoSuchElementException e){  // скорее всего неверный локатор
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.name("error"));
        if(webElements.size()>1){
            //todo
        }

        webElement1.click();
        webElement2.sendKeys("Поиск");


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("google"));

        driver.navigate().to("https://google.com");

        try {
            webElement3.sendKeys("Привет");
        } catch (StaleElementReferenceException e){ // элемент нашли, но нашли его слишком рано что бы взаимодействовать.
                                                    // К нынешней DOM структуре не имеет отношения.
            System.out.println(e.getSupportUrl());
        }

        try {
            driver.findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){ // пытаемся взаимодействовать с элементами, с которыми НЕВОЗМОЖНО
                                                     // именно сейчас взаимодействовать. Например: подождать
            System.out.println(e.getSupportUrl());
        }

        //Thread.sleep(10000l);
        //Завершаем работу с ресурсом
        driver.quit();
    }
}
