package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SummaryTableComponent;
import utils.FakerTestData;

import java.util.Locale;

import static io.qameta.allure.Allure.step;
import static java.lang.Thread.sleep;

public class RegistrationFormWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    SummaryTableComponent summaryTable = new SummaryTableComponent();
    FakerTestData fakerTestData = new FakerTestData();

    @Test
    @Tag("demoqa")
        //Проверка формы регистрации с заполнением всех полей
    void successRegistrationAllFilldsTest() {
        step("Открыть форму", () -> {
            registrationPage.openPage()
                    .bannersRemove();
        });
        step("Заполнить поля формы", () -> {
            registrationPage.setFirstName(fakerTestData.firstName)
                    .setLastName(fakerTestData.lastName)
                    .setGender(fakerTestData.gender)
                    .setEmail(fakerTestData.email)
                    .setPhoneNumber(fakerTestData.phoneNumber)
                    .setDateOfBirth(fakerTestData.yearOfBirth, fakerTestData.monthOfBirth, fakerTestData.dayOfBirth)
                    .setSubjects(fakerTestData.subjects)
                    .setHobbies(fakerTestData.hobbies)
                    .setPicture(fakerTestData.picture)
                    .setCurrentAddress(fakerTestData.currentAddress)
                    .setState(fakerTestData.state)
                    .setCity(fakerTestData.city);
        });
        step("Отправить форму", () -> {
            registrationPage.buttonClick();
        });
        step("Проверить результат", () -> {
            summaryTable.shouldAppear()
                    .checkFields("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
                    .checkFields("Student Email", fakerTestData.email)
                    .checkFields("Gender", fakerTestData.gender)
                    .checkFields("Mobile", fakerTestData.phoneNumber)
                    .checkFields("Date of Birth", fakerTestData.dayOfBirth + " " + fakerTestData.monthOfBirth + ","
                            + fakerTestData.yearOfBirth)
                    .checkFields("Subjects", fakerTestData.subjects)
                    .checkFields("Hobbies", fakerTestData.hobbies)
                    .checkFields("Picture", fakerTestData.picture)
                    .checkFields("Address", fakerTestData.currentAddress)
                    .checkFields("State and City", fakerTestData.state + " " + fakerTestData.city);
        });
    }

        @Test
        @Tag("demoqa")
        //Проверка формы регистрации с заполнением только обязательных полей
        void successRegistrationRequiredFilldsTest(){
            registrationPage
                    .openPage()
                    .bannersRemove()
                    .setFirstName(fakerTestData.firstName)
                    .setLastName(fakerTestData.lastName)
                    .setGender(fakerTestData.gender)
                    .setPhoneNumber(fakerTestData.phoneNumber)
                    .buttonClick();


            summaryTable.shouldAppear()
                    .checkFields("Student Name", fakerTestData.firstName + " " + fakerTestData.lastName)
                    .checkFields("Gender", fakerTestData.gender)
                    .checkFields("Mobile", fakerTestData.phoneNumber);

        }

        @Test
        @Tag("demoqa")
        //Проверка на то, что форма регистрации не отправляется если не заполнены обязательные поля
        void negativeRegistrationTest () {
            registrationPage
                    .openPage()
                    .bannersRemove()
                    .buttonClick();

            summaryTable.shouldNotAppear();
        }
    }
