package Rozetka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static java.lang.String.valueOf;


public class AddMethod extends BaseMethod {

    @Test
    public void addToCart() {
        String input = "робот пылесос Xiaomi";
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

        //если 2 одинаковых товара
        WebElement plus = driver.findElement(By.xpath("//button[@class='button button_color_white button_size_medium cart-counter__button'][2]"));
        plus.click();

        List<WebElement> quantityInCart = driver.findElements(By.cssSelector("div.modal__content"));
        String quantity = valueOf(quantityInCart.size());

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
