package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckingTitles extends BaseTest {


    @Test
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.presenceOfElementLocated(searchField));

        WebElement search = driver.findElement(searchField);
        search.clear();
        search.sendKeys("Babolat");
        search.sendKeys(Keys.ENTER);

        WebElement chooseFilter = driver.findElement(filterLink);
        chooseFilter.click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//select/option[1]")));
        Select select = new Select(driver.findElement(By.xpath("//select[1]")));
        select.selectByIndex(1);

        String expected = "ракетка";
        //Thread.sleep(10);
        List<WebElement> productsList = driver.findElements(products);
        String textTitle = productsList.get(0).getText();
        Assert.assertEquals(textTitle, expected);

        /*
        for (WebElement product : productsList) {
            WebElement title = product.findElement(By.xpath("(//img[@class='ng-lazyloaded'])[1]"));
            String textTitle = title.getText();
            if (textTitle.toLowerCase().contains(query)) {
                System.out.println("[TRUE]" + textTitle);
            } else {
                System.out.println("[FALSE]" + textTitle);
            }

            WebElement button1 = driver.findElement(buttonBuy);
            button1.click();*/
    }
}

