
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
        Loginpage loginpage = new Loginpage(driver);
        loginpage.navigate();
        loginpage.login(user);
        HomePage homePage = new HomePage(driver);
        HomePage.waitUntilLoaded();
        MailinatorPage mailinatorPage = new MailinatorPage(driver);
        homePage.clickWriteLetter();
        homePage.writeLetter(receiverMailinatorEmail, mailSubject, mailText);
        homePage.sendLetter();
        mailinatorPage.navigate();
        mailinatorPage.goToInbox("testselenium1");
        mailinatorPage.inputMailinatorEmail();
        mailinatorPage.clickGoButton();
        mailinatorPage.clickOnLastReceivedLetter();
        Assert.assertEquals(mailSubject, mailinatorPage.getMailSubjectText());
        Assert.assertEquals(senderEmail, mailinatorPage.getSenderEmail());
        Assert.assertEquals(mailText, mailinatorPage.getTextFromReceivedMailOnMailinator());
            }
        }


