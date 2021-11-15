package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.List;

public class DeleteFromCart extends BasePage {

    @Test
    public void delete() {

        By iconCatalog = By.cssSelector("#fat-menu");
        By linkMonitor = By.xpath(".//a[@class='menu__link'][@href='https://hard.rozetka.com.ua/monitors/c80089/']");
        By listMonitors = By.cssSelector("ul.catalog-grid");
        By buttonBuy = By.cssSelector("app-buy-button.toOrder.ng-star-inserted");

        WebElement catalog = driver.findElement(iconCatalog);
        catalog.click();

        WebElement monitor = driver.findElement(linkMonitor);
        monitor.click();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(listMonitors, 0));
        List<WebElement> list = driver.findElements(listMonitors);
        list.get(0).click();

        WebElement button1 = driver.findElement(buttonBuy);
        button1.click();

        WebElement dots = driver.findElement(By.cssSelector("#cartProductActions0"));
        dots.click();

        WebElement trashButton = driver.findElement(By.xpath(".//rz-trash-icon/button"));
        trashButton.click();

        //первая идея проверки
//        List<WebElement> productsInCart = driver.findElements(By.cssSelector("div[class*='modal__content']"));
//        assertTrue(productsInCart.isEmpty());

        //вторая идея проверки
//            String actual = driver.findElement(By.cssSelector("h4.cart-dummy__heading")).getAttribute("value");
//            String expected= "корзина пуста";
//            if (actual.equals(expected)) {
//                System.out.println("TRUE");

        //третья идея проверки
        WebElement image = driver.findElement(By.cssSelector("img.cart-dummy__illustration"));
        image.isDisplayed();
        System.out.println("TRUE");
    }
}
