import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        By iconCatalog = By.cssSelector("#fat-menu");
        By linkMonitor = By.xpath(".//a[@class='menu__link'][@href='https://hard.rozetka.com.ua/monitors/c80089/']");
        By checkboxFilter = By.xpath(".//input[@id='Rozetka']/..");
        By listMonitors = By.cssSelector("ul.catalog-grid");

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://rozetka.com.ua/");

            WebDriverWait wait = new WebDriverWait(driver, 4);
            wait.until(ExpectedConditions.elementToBeClickable(iconCatalog));

            WebElement catalog = driver.findElement(iconCatalog);
            catalog.click();

            wait.until(ExpectedConditions.elementToBeClickable(linkMonitor));

            WebElement monitor = driver.findElement(linkMonitor);
            monitor.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(checkboxFilter));

            WebElement filter = driver.findElement(checkboxFilter);
            filter.isSelected();

            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listMonitors, 0));

            List<WebElement> list = driver.findElements(listMonitors);
            list.get(0).click();




        } finally {
            driver.quit();
        }
    }
}
