package Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Filtration extends BasePage {

    @Test
    public void checkTitles() {

        By searchElem = By.xpath(".//div//input");
        By filterLink = By.xpath("(.//ul/li[3]//span[@class='categories-filter__link-title ng-star-inserted'])[1]");
        By products = By.cssSelector("ul.catalog-grid.ng-star-inserted");
        String titleContains = "теннисная ракетка";

        WebElement searchField = driver.findElement(searchElem);
        searchField.clear();
        searchField.sendKeys("Babolat");
        searchField.sendKeys(Keys.ENTER);

        WebElement chooseFilter = driver.findElement(filterLink);
        chooseFilter.click();

        Select select = new Select(driver.findElement(By.xpath("//select[1]")));
        select.selectByIndex(1);

        List<WebElement> productsList = driver.findElements(products);
        for (WebElement product : productsList) {
            WebElement title = product.findElement(By.xpath("(.//span[@class='goods-tile__title'])[1]"));
            String textTitle = title.getText();
            if (textTitle.toLowerCase().contains(titleContains)) {
                System.out.println("[TRUE]" + textTitle);
            } else {
                System.out.println("[FALSE]" + textTitle);
            }
        }
    }
}

