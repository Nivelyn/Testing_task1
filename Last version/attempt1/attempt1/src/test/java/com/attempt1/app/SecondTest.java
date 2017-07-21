package com.attempt1.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondTest {

    WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/koss/attempt1/attempt1/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void secondTest(){
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//*[@id=\"5300\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"5300\"]/div/div[2]/div/ul[2]/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[2]/h4/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content-inner-block\"]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div[1]/div[1]/div[1]/div/h3/a")).click();
        WebElement min_enter = driver.findElement(By.xpath("//*[@id=\"price[min]\"]"));
        WebElement max_enter = driver.findElement(By.xpath("//*[@id=\"price[max]\"]"));
        Actions builder = new Actions(driver);
        Actions seriesOfActions1 = builder.moveToElement(min_enter).click().sendKeys(min_enter, "100");
        seriesOfActions1.perform();
        Actions seriesOfActions2 = builder.moveToElement(max_enter).click().sendKeys(max_enter, "100");
        seriesOfActions2.perform();
        driver.findElement(By.xpath("//*[@id=\"submitprice\"]"));

        WebElement element1 = driver.findElement(By.xpath("/html/head/script[30]"));
        String text1 = element1.getAttribute("innerText");
        Pattern p = Pattern.compile("(?<=productName.).*?(?=..productID)");
        Matcher m1 = p.matcher(text1);

        driver.findElement(By.xpath("//*[@id=\"page2\"]/a")).click();
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"catalog_goods_block\"]/script[2]"));
        String text2 = element2.getAttribute("innerText");
        Matcher m2 = p.matcher(text2);

        driver.findElement(By.xpath("//*[@id=\"page3\"]/a")).click();
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"catalog_goods_block\"]/script[2]"));
        String text3 = element3.getAttribute("innerText");
        Matcher m3 = p.matcher(text3);

        while(m1.find()) {
            System.out.println(text1.substring(m1.start()+1, m1.end()));
        }
        while(m2.find()) {
            System.out.println(text2.substring(m2.start()+1, m2.end()));
        }
        while(m3.find()) {
            System.out.println(text3.substring(m3.start()+1, m3.end()));
        }

    }

}
