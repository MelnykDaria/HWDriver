package Leafground.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppearsElement extends LeafGroundBasePage {
    @FindBy(xpath = "//button[@id='btn']//b")
    private WebElement appearsElement;

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public AppearsElement(WebDriver driver) {
        super(driver);
        pageUrl = "http://www.leafground.com/pages/appear.html";
        PageFactory.initElements(driver, this);
    }

    public static void waitUntilElementAppear() {
    }


    public void navigate() {
        driver.get(pageUrl);
    }

    public void waitUntilAppearsElement() {
        webDriverWait.until(ExpectedConditions.visibilityOf(appearsElement));
    }
}
