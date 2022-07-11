package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailinatorPage extends BasePage {

    @FindBy(xpath = "//td[contains(text(), 'qwerty')]")
   private WebElement lastLetter;

    @FindBy(id = "inbox_field")
    private WebElement inboxField;

    @FindBy(xpath ="primary-btn")
    private WebElement goButton;

    @FindBy(xpath ="//input[@id='search']")
    private WebElement mailinatorSearchFieldLocator;

    @FindBy(xpath = "//button[text()='GO']")
    private WebElement mailinatorGoButtonLocator;

    @FindBy(xpath = "//table[@class='table-striped jambo_table']//tbody//tr[1]")
    private WebElement lastReceivedEmailLocator;

    @FindBy(id ="html_msg_body")
    private WebElement accessToEmailBodyLocator;

    @FindBy(xpath ="//span[@class='xfmc1']" )
    private WebElement mailinatorLetterLocator;

    @FindBy(xpath ="//div[@class='fz-20 ff-futura-demi gray-color ng-binding']")
    private WebElement mailSubjectLocator;

    @FindBy(xpath = "//div[@class='wrapper-info-title d-flex']//div[contains(text(),'testselenium1@ukr.net')]")
    private WebElement emailSenderLocator;

    public MailinatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
        PageFactory.initElements(driver,this);
    }

    public void clickLastLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(lastReceivedEmailLocator));
        lastReceivedEmailLocator.click();
    }

    public void goToInbox(String inbox) {
     inboxField.sendKeys(inbox);
        goButton.click();
    }

    public void navigate() {
        driver.get(pageUrl);
        pageUrl = "https://www.mailinator.com/";
    }

    public void inputMailinatorEmail() {
       mailinatorSearchFieldLocator.sendKeys("testselenium1");
    }

    public void clickGoButton() {
   mailinatorGoButtonLocator.click();
    }

    public void clickOnLastReceivedLetter()
    {
        webDriverWait.until(ExpectedConditions.visibilityOf(lastReceivedEmailLocator));
        lastReceivedEmailLocator.click();
    }
    public String getSenderEmail() {
    return emailSenderLocator.getText();
    }

    public String getTextFromReceivedMailOnMailinator()
    {
        try {
            driver.switchTo().frame(accessToEmailBodyLocator);
            return mailinatorLetterLocator.getText();
        }
        finally
        {
            driver.switchTo().parentFrame();
        }
    }
    public String getMailSubjectText() {
   return mailSubjectLocator.getText();
    }
}

