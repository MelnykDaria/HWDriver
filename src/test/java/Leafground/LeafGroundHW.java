package Leafground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import Leafground.pages.AppearsElement;
import Leafground.pages.ElementDissapears;
import Leafground.pages.TextAppears;
import org.testng.annotations.Test;

public class LeafGroundHW {
    private WebDriver driver;

@BeforeClass
public void setUp() {
    System.setProperty("selenium.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
}
    @Test
    public void WaitUntilElementDisappear(){
        ElementDissapears elementDissapears = new ElementDissapears(driver);
        ElementDissapears.navigate();

        ElementDissapears.waitUntilButtonDissapear();
    }

    @Test
    public void WaitUntilElementAppears(){
        AppearsElement appearsElement = new AppearsElement(driver);
       AppearsElement.navigate();

        AppearsElement.waitUntilElementAppear();
    }

    @Test
    public void WaitUntilTextIsChanged(){
        TextAppears textAppears = new TextAppears(driver);
        textAppears.navigate();

        textAppears.waitUntilTextIsChanged();
    }

}
