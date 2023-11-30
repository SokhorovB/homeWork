import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {
//        Configuration.holdBrowserOpen = true;
        Configuration.browser = "firefox";
        String url = "https://www.google.com/";

        open(url);
        $("[name=q]").setValue("selenide").pressEnter();
        $("#search").shouldHave(text("https://ru.selenide.org"));
    }

//    @Test
//    void loginLK(){
////        Configuration.holdBrowserOpen = true;
////        Configuration.browser = "firefox";
//
//        open("https://qa.guru/cms/system/login");
//        $("[name=email]").setValue("basang.sokhorov@rt.ru");
//        $("[name=password]").setValue("Enopeg-51");
//        $(".btn-success").click();
//        $(".main-header__login").click();
//        $(".logined-form").shouldHave(text("Басанг"));
//
//
//    }
//
//    @Test
//    void wrongLoginLK(){
////        Configuration.holdBrowserOpen = true;
////        Configuration.browser = "firefox";
//
//        open("https://qa.guru/cms/system/login");
//        $("[name=email]").setValue("basang.sokhorov@rt.ru");
//        $("[name=password]").setValue("123456");
//        $(".btn-success").click();
//        $(".logined-form").shouldHave(text("Неверный пароль"));
//
//
//    }
}
