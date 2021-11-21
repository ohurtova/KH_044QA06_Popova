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

    @Test
    public void addToCart() {

        String input = "холодильник Samsung";
        By searchElem = By.xpath(".//div//input");
        By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
        By buttonElem = By.cssSelector("button.buy-button.button");
        By plusButton = By.xpath("(//div/button[@class='button button_color_white button_size_medium cart-counter__button'])[2]");
        By exitCross = By.xpath(".//button[@class='modal__close ng-star-inserted']");
        By circleQuantityInCart = By.cssSelector("span.counter.counter--green.ng-star-inserted");

        WebElement searchField = driver.findElement(searchElem);
        searchField.clear();
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(products, 0));

        List<WebElement> productsList = driver.findElements(products);
        productsList.get(0).click();

        try {
            Thread.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement buttonBuy = driver.findElement(buttonElem);
        buttonBuy.click();


        wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        WebElement plus = driver.findElement(plusButton);
        plus.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.cart-counter__input")));
        WebElement quantityInCart = driver.findElement(By.cssSelector("input.cart-counter__input"));
        String quantity = quantityInCart.getAttribute("value");

        wait.until(ExpectedConditions.elementToBeClickable(exitCross));
        WebElement buttonClose = driver.findElement(exitCross);
        buttonClose.click();

        WebElement cart = driver.findElement(circleQuantityInCart);
        String number = cart.getText();
        System.out.println(number);
        if (number.equals(quantity)) {
            System.out.println("[TRUE]" + number);
        } else {
            System.out.println("[FALSE]" + number);
        }

    }

}
