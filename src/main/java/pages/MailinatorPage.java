package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class MailinatorPage extends BasePage {

    private By lastLetter = By.xpath("//td[contains(text(), 'qwerty')]");
    private By inboxField = By.id("inbox_field");
    private By goButton = By.className("primary-btn");
    private By mailinatorSearchFieldLocator = By.xpath("//input[@id='search']");
    private By mailinatorGoButtonLocator = By.xpath("//button[text()='GO']");
    private By lastReceivedEmailLocator = By.xpath("//table[@class='table-striped jambo_table']//tbody//tr[1]");
    private By accessToEmailBodyLocator = By.id("html_msg_body");
    private By mailinatorLetterLocator = By.xpath("//span[@class='xfmc1']");
    private By mailSubjectLocator = By.xpath("//div[@class='fz-20 ff-futura-demi gray-color ng-binding']");
    private By emailSenderLocator = By.xpath("//div[@class='wrapper-info-title d-flex']//div[contains(text(),'testselenium1@ukr.net')]");

    public MailinatorPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/v4/public/inboxes.jsp";
    }

    public void clickLastLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastLetter));
        driver.findElement(lastLetter).click();
    }

    public void goToInbox(String inbox) {
        driver.findElement(inboxField).sendKeys(inbox);
        driver.findElement(goButton).click();
    }

    public void waitUntilLettersIsDisplayed() {
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
            try {
                if (driver.findElement(lastLetter).isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        throw new TimeoutException();
    }

    public void navigate() {
        driver.get(pageUrl);
        pageUrl = "https://www.mailinator.com/";
    }

    public void inputMailinatorEmail() {
        driver.findElement(mailinatorSearchFieldLocator).sendKeys("Qwerty");
    }

    public void clickGoButton() {
        driver.findElement(mailinatorGoButtonLocator).click();
    }

    public void clickOnLastReceivedLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(lastReceivedEmailLocator));
        driver.findElement(lastReceivedEmailLocator).click();
    }
    public String getSenderEmail() {
        return driver.findElement(emailSenderLocator).getText();
    }

    public String getTextFromReceivedMailOnMailinator()
    {
        try {
            driver.switchTo().frame(driver.findElement(accessToEmailBodyLocator));
            return driver.findElement(mailinatorLetterLocator).getText();
        }
        finally
        {
            driver.switchTo().parentFrame();
        }
    }
    public String getMailSubjectText() {
        return driver.findElement(mailSubjectLocator).getText();
    }
}

