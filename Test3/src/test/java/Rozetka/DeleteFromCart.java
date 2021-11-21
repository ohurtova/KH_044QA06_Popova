package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class DeleteFromCart extends BasePage {

    @Test
    public void delete() {
        By searchElem = By.xpath(".//div//input");
        By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
        By buttonElem = By.cssSelector("button.buy-button.button");
        By dots = By.cssSelector("#cartProductActions0");
        String input = "робот пылесос";

        WebElement searchField = driver.findElement(searchElem);
        searchField.clear();
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(products, 0));

        List<WebElement> productsList = driver.findElements(products);
        productsList.get(0).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(buttonElem));
        WebElement buttonBuy = driver.findElement(buttonElem);
        buttonBuy.click();

        WebElement dotsButton = driver.findElement(dots);
        dotsButton.click();

        WebElement trashButton = driver.findElement(By.cssSelector("rz-trash-icon .button"));
        trashButton.click();

        WebElement image = driver.findElement(By.cssSelector("img.cart-dummy__illustration"));
        if (image.isDisplayed()) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
