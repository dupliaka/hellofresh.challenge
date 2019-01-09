package steps;

import cucumber.api.java.en.And;
import pages.purchase.CataloguePage;

import static com.codeborne.selenide.Selenide.page;

public class CatalogueSteps {
    CataloguePage cataloguePage = page(CataloguePage.class);

    @And("^choose catalog item (.*)$")
    public void getItem(String catalogueItem) {
        cataloguePage.getCatalogItem(catalogueItem);
    }
}
