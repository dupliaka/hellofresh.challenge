package pages;

import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;


@Log4j
public class PageManager {
    private static final HomePage homePage = page(HomePage.class);

    private static Map<String, WebPage> relativePaths = new HashMap<String, WebPage>() {{
        put("HOME", homePage);
    }};


    public static void openPage(String page) {
        WebPage pageToOpen = relativePaths.get(page);
        if (pageToOpen == null) {
            throw new IllegalArgumentException("Page with name: " + page + "is not supported");
        }
        pageToOpen.open();
    }

}
