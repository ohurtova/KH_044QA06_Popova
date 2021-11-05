import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        By searchField = By.xpath(".//div//input");
        By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
        By buttonBuy = By.cssSelector("app-buy-button.toOrder.ng-star-inserted");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://rozetka.com.ua/");

            WebDriverWait wait = new WebDriverWait(driver, 4);
            wait.until(ExpectedConditions.presenceOfElementLocated(searchField));// webElement?

            WebElement search = driver.findElement(searchField);
            search.clear();
            search.sendKeys("робот пылесос Xiaomi");
            search.sendKeys(Keys.ENTER);

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(products, 0));

            List<WebElement> productsList = driver.findElements(products);
            //System.out.println(productsList.size());
            productsList.get(0).click();

            wait.until(ExpectedConditions.elementToBeClickable(buttonBuy));

            WebElement button1 = driver.findElement(buttonBuy);
            button1.click();

        } finally {
            driver.quit();
        }
    }
}

