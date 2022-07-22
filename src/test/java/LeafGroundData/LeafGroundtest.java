package LeafGroundData;

import LeafGroundPages.AppearsElement;
import LeafGroundPages.DissapearsElements;
import LeafGroundPages.TextAppears;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeafGroundtest {

private WebDriver driver;

@BeforeClass
    public void SetUp(){
    System.setProperty("selenium.chrome.driver", "chromedriver.exe");
    driver = new ChromeDriver();
}

@Test
    public void WaitIntilDissapearsElement()
{
    DissapearsElements dissapearsElements = new DissapearsElements(driver);
    dissapearsElements.navigate();
    dissapearsElements.waitUntilButtonDisappear();
}
@Test
    public void WaitUntilAppearsElement(){
    AppearsElement appearsElement = new AppearsElement(driver);
    appearsElement.navigate();
    appearsElement.waitUntilElementAppears();
}

@Test
    public void WaitUntilTextAppears() {
    TextAppears textAppears = new TextAppears(driver);
    textAppears.navigate();
    textAppears.waitUntilTextIsChanged();

}
}



