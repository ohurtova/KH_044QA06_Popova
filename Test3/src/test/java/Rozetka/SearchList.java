package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchList extends BasePage {

    @DataProvider(name = "productNames")
    public Object[][] createData1() {
        return new Object[][]{
                {"робот пылесос Xiaomi"},
                {"телевизор Samsung"},
        };
    }

    @Test(dataProvider = "productNames")
    public void search(String input) {
        By searchElem = By.xpath(".//div//input");
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchElem));
        WebElement searchField = driver.findElement(searchElem);
        searchField.clear();
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.ENTER);
    }

}
