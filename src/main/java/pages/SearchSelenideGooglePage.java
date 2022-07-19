package pages;


import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SearchSelenideGooglePage {

    private static final By GOOGLE_SEARCH_FIELD = By.xpath("//input[@class='gLFyf gsfi']");
    private static final  By SELENIDE_ON_SEARCH_RESULT_PAGE = By.xpath("//h3[contains(text(),'Selenide')]");
    private static final By SELENIDE_WEBSITE_HEADER = By.xpath("//h1[text()='Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6']");
    private static final By SELENIDE_SITE_BLOG_BUTTON = By.xpath("//a[@href='/blog.html'] [text()='Blog']");
    private static final By  SELENIDE_BLOG_PAGE_HEADER = By.xpath("//h3[text()='Selenide blog']");


    public SearchSelenideGooglePage GoogleVisibility(){
        $(GOOGLE_SEARCH_FIELD).shouldBe(visible);
        return this;
    }
    public SearchSelenideGooglePage SetSearchText(String text) {
        $(GOOGLE_SEARCH_FIELD).setValue(text);
        return this;
    }

    public SearchSelenideGooglePage PressEnter() {
        $(GOOGLE_SEARCH_FIELD).pressEnter();
        return this;
    }

    public SearchSelenideGooglePage FoundSelenideValues() {
        $$(SELENIDE_ON_SEARCH_RESULT_PAGE).shouldHave(CollectionCondition.sizeGreaterThan(7));
        return this;
    }

    public SearchSelenideGooglePage ClickOnFirstLinkAfterSearch() {
        $$(SELENIDE_ON_SEARCH_RESULT_PAGE).shouldHave(CollectionCondition.sizeGreaterThan(7))
                .get(0)
                .click();
        return this;
    }

    public SearchSelenideGooglePage VerifyEnteringToTheFirstLink() {
        $(SELENIDE_WEBSITE_HEADER).shouldBe(visible);
        return this;
    }

    public SearchSelenideGooglePage ClickOnBlogButtonOnSelenideSitePage() {
        $(SELENIDE_SITE_BLOG_BUTTON)
                .shouldBe(visible)
                .click();
        return this;
    }

    public SearchSelenideGooglePage VerifyEnteringToBlogOnSelenideSite() {
        $(SELENIDE_BLOG_PAGE_HEADER)
                .shouldBe(visible);
        return this;
    }
}



