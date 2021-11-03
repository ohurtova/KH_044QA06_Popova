package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void endDriver() {
        driver.quit();
    }

    By searchField = By.xpath(".//div//input");
    By filterLink = By.xpath("(.//ul/li[3]//span[@class='categories-filter__link-title ng-star-inserted'])[1]");
    By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
    By buttonBuy = By.cssSelector("app-buy-button.toOrder.ng-star-inserted");
}
