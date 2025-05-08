package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SummaryTableComponent {

    private final SelenideElement modalDialog = $(".table-responsive");

    public SummaryTableComponent checkFields(String key, String value) {
        modalDialog.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public SummaryTableComponent shouldAppear() {
        modalDialog.shouldBe(visible);
        return this;
    }

    public SummaryTableComponent shouldNotAppear() {
        modalDialog.shouldNotBe(visible);
        return this;
    }
}
