package SelenideHW;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import pages.SearchSelenideGooglePage;
import static com.codeborne.selenide.Selenide.*;

public class SelenideHW {
    @BeforeClass
    public void SetUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5;

    }

    @Test
    public void SearchSelenideInGoogle() {
        open("https://google.com");
        SearchSelenideGooglePage searchSelenideTestGoogleHomePage = new SearchSelenideGooglePage();

        searchSelenideTestGoogleHomePage.GoogleVisibility();
        searchSelenideTestGoogleHomePage.SetSearchText("Selenide");
        searchSelenideTestGoogleHomePage.PressEnter();
        searchSelenideTestGoogleHomePage.FoundSelenideValues();
        searchSelenideTestGoogleHomePage.ClickOnFirstLinkAfterSearch();
        searchSelenideTestGoogleHomePage.VerifyEnteringToTheFirstLink();
        searchSelenideTestGoogleHomePage.ClickOnBlogButtonOnSelenideSitePage();
        searchSelenideTestGoogleHomePage.VerifyEnteringToBlogOnSelenideSite();

    }
}

