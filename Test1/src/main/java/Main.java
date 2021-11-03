import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            WebElement searchField = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
            searchField.clear();
            searchField.sendKeys("rozetka ua");
            searchField.sendKeys(Keys.ENTER);

            WebElement firstLink = driver.findElement(By.xpath(".//div[@class='cfxYMc JfZTW c4Djg MUxGbd v0nnCb']/span"));
            firstLink.click();

            WebElement searchField2 = driver.findElement(By.xpath("//input[@class='search-form__input ng-untouched ng-pristine ng-valid']"));
            searchField2.clear();
            searchField2.sendKeys("робот пылесос Xiaomi");

            WebElement buttonSearch = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
            buttonSearch.click();

            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<WebElement> products = driver.findElements(By.cssSelector("ul.catalog-grid.ng-star-inserted"));
            //System.out.println(products.size());

            products.get(0).click();

            WebElement buttonBuy = driver.findElement(By.cssSelector("app-buy-button.toOrder.ng-star-inserted"));
            buttonBuy.click();

            /*WebElement buttonClose = driver.findElement(By.xpath(".//button[@class='modal__close ng-star-inserted']"));
            buttonClose.click();

            WebElement cart = driver.findElement(By.cssSelector("span.counter.counter--green.ng-star-inserted"));
            cart.click();*/

        } finally {
            driver.quit();
        }
    }
}