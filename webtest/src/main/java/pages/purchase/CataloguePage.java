package pages.purchase;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CataloguePage {

    public ProductViewPage getCatalogItem(String itemTitle){
        $(By.linkText(itemTitle)).click();
        return page(ProductViewPage.class);
    }
}
