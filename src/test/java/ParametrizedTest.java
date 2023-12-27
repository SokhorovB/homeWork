import com.codeborne.selenide.Configuration;
import data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedTest {

    @BeforeEach
    void setUp(){
        Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }


    @ValueSource(strings = {
            "selenide", "junit 5"
    })

    @ParameterizedTest
    @Tag("ValueSource")
    @DisplayName("ValueSource")
    public void valueSource(String searchQuery){
        open("https://duckduckgo.com/");
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid='mainline'] li[data-layout='organic']")
                .shouldBe(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Selenide , https://selenide.org",
            "JUnint 5 , https://junit.org"
    })
    @ParameterizedTest
    @Tag("CsvSource")
    @DisplayName("CsvSource")
    public void CsvSource(String searchQuery, String expectedLink){
        open("https://duckduckgo.com/");
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }


    @EnumSource(Language.class)
    @ParameterizedTest
    @Tag("EnumSource")
    @DisplayName("EnumSource")
    public void EnumSource(Language language){

        open("https://ru.selenide.org/");
        $$("#languages a").find(text(language.name())).click();
        $("h3").shouldHave(text(language.description));
    }



    static Stream<Arguments> MethodStream(){
        return Stream.of(
                Arguments.of(Language.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Language.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }
    @MethodSource()
    @ParameterizedTest
    @Tag("MethodSource")
    @DisplayName("MethodSource")
    void MethodStream(Language language, List<String> expectedButtons){
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(language.name())).click();
        $$(".main-menu-pages a").filter(visible).shouldHave(texts(expectedButtons));
    }
}
