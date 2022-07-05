
package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Loginpage;
import pages.MailinatorPage;
import testdata.User;

import static pages.Loginpage.login;

public class UkrNetTest {

    private WebDriver driver;
    private String senderEmail = "testselenium1@ukr.net";
    private String senderEmailPassword = "test1234";
    private String receiverMailinatorEmail = "testselenium1@ukr.net";
    private String mailText = "test body";
    private String mailSubject = "test1234";

    @BeforeClass
    public void setUp() {
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User(senderEmail, senderEmailPassword);
        Loginpage loginPage = new Loginpage(driver) {
            @Override
            protected String pageUrl() {
                return null;
            }
        };
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
        MailinatorPage mailinatorPage = new MailinatorPage(driver) {
            @Override
            protected String pageUrl() {
                return null;
            }
        };

        homePage.clickWriteLetter();
        homePage.writeLetter(receiverMailinatorEmail, mailSubject, mailText);
        homePage.sendLetter();
        Assert.assertTrue(homePage.getTextLetterIsSend("Ваш лист надіслано"));
        mailinatorPage.navigate();
        mailinatorPage.goToInbox("testselenium1");
        mailinatorPage.inputMailinatorEmail();
        mailinatorPage.clickGoButton();
        mailinatorPage.clickOnLastReceivedLetter();

    }
}

