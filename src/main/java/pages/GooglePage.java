package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;

    public class GooglePage extends BasePage {

        private static final By SEARCH_FIELD = By.cssSelector("[name='q']");

        public GooglePage(WebDriver driver) {
            super(driver);
        }

        public GooglePage waitUntilSearchFieldDisplayed() {
            $(SEARCH_FIELD).shouldBe(visible);
            return this;
        }

        public GooglePage setSearchText(String text) {
            $(SEARCH_FIELD).setValue("Selenide");
            return this;
        }

        public GooglePage pressEnter() {
            $(SEARCH_FIELD).pressEnter();
            return this;
        }

    }

