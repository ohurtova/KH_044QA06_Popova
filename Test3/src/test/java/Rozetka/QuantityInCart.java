package Rozetka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QuantityInCart extends BasePage {

    @DataProvider(name = "productNames")
    public Object[][] createData1() {
        return new Object[][]{
                {"робот пылесос Xiaomi"},
                {"телевизор Samsung"},
        };
    }

    @Test(dataProvider = "productNames")
    public void addToCart(String input) {

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        By searchElem = By.xpath(".//div//input");
        By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
        By buttonElem = By.cssSelector("button.buy-button.button");

        WebElement searchField = driver.findElement(searchElem);
        searchField.clear();
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(products, 0));

        List<WebElement> productsList = driver.findElements(products);
        productsList.get(0).click();

        WebElement buttonBuy = driver.findElement(buttonElem);
        buttonBuy.click();

        WebElement plus = driver.findElement(By.xpath("(//div/button[@class='button button_color_white button_size_medium cart-counter__button'])[2]"));
        plus.click();

        WebElement quantityInCart = driver.findElement(By.cssSelector("input.cart-counter__input"));
        String quantity = quantityInCart.getAttribute("value");

        WebElement buttonClose = driver.findElement(By.xpath(".//button[@class='modal__close ng-star-inserted']"));
        buttonClose.click();

        WebElement cart = driver.findElement(By.cssSelector("span.counter.counter--green.ng-star-inserted"));
        String number = cart.getText();

        if (number.equals(quantity)) {
            System.out.println("[TRUE]" + number);
        } else {
            System.out.println("[FALSE]" + number);
        }

    }

}
