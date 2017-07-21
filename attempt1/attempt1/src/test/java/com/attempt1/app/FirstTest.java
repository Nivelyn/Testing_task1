package com.attempt1.app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstTest {

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
    public void firstTest(){
        driver.get("https://rozetka.com.ua/");
        driver.findElement(By.xpath("//*[@id=\"3361\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content-inner-block\"]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div[1]/div/h3/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[1]/div/a[1]")).click();
        WebElement element = driver.findElement(By.xpath("/html/head/script[27]"));

        String text = element.getAttribute("innerText");

        Pattern p = Pattern.compile("(?<=productName.).*?(?=..productID)");
        Matcher m = p.matcher(text);

        while(m.find()) {
            System.out.println(text.substring(m.start()+1, m.end()));
        }

    }

}
