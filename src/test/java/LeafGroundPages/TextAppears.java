package LeafGroundPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextAppears extends LeafGroundBasePage{
    public TextAppears(WebDriver driver)
    {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/TextChange.html";
        PageFactory.initElements(driver,this);

    }

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

    @FindBy(xpath = "//button[@id='btn']")
    private WebElement changeElementText;

    public void navigate(){
        driver.get(pageUrl);
    }
 public void waitUntilTextIsChanged(){
    webDriverWait.until(ExpectedConditions.textToBePresentInElement(changeElementText, "Click ME"));

 }


}

