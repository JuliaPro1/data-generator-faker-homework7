package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement selectYear = $(".react-datepicker__year-select");
    private final SelenideElement selectMonth = $(".react-datepicker__month-select");

    public void setDate(String year, String month, String day) {
        selectYear.selectOption(year);
        selectMonth.selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }
}
