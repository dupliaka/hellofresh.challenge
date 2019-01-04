package pages;

import com.codeborne.selenide.Selenide;

public class HomePage implements WebPage {


    public void open(){
        Selenide.open("/index.php");
    }

}
