package HWCheckbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

    public class CheckboxHW {
        private String baseUrl = "http://www.leafground.com/pages/checkbox.html";
        private WebDriver driver;


       private By selectLanguageCheckboxLocator = By.xpath("//div[@class='example'][1]//input[@type='checkbox'][1]");
       private By seleniumCheckboxLocator = By.xpath("//div[@class='example'][2]//input[@type='checkbox'][1]");
       private By deselectOnlyCheckedLocator = By.xpath("//div[@class='example'][3]//input[@type='checkbox'][2]");
       private By selectAllCheckBoxLocator= By.xpath("//div[@class='example']/label[@for='java'][text()='Select all below checkboxes']/following-sibling::input");


        private WebElement selectLanguageCheckbox;
        private WebElement seleniumCheckbox;
       private WebElement deselectOnlyChecked;
        private List  selectAllCheckBox;

        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
            System.setProperty("selenium.chrome.driver", "chromedriver.exe");
         driver.get(baseUrl);

            selectLanguageCheckbox = driver.findElement(selectLanguageCheckboxLocator);
            seleniumCheckbox= driver.findElement( seleniumCheckboxLocator);
            deselectOnlyChecked = driver.findElement(deselectOnlyCheckedLocator);
            selectAllCheckBox =  driver.findElements(selectAllCheckBoxLocator);
        }

        @Test
        public void languagetest() {
            selectLanguageCheckbox.click();
           Assert.assertTrue(selectLanguageCheckbox.isSelected());

        }

        @Test
        public void confirmlanguagetest() {
            Assert.assertTrue(seleniumCheckbox.isSelected());
        }

        @Test
        public void deselectedtest() {
            deselectOnlyChecked.click();
            Assert.assertFalse( deselectOnlyChecked.isSelected());
        }

        @Test
        public void selectalltest() {
            List<WebElement> checkboxesList = selectAllCheckBox;
            for (WebElement checkbox : checkboxesList) {
                checkbox.click();
            }
            for (WebElement checkbox : checkboxesList) {
                checkbox.isSelected();
            }
        }
        @AfterClass
        public void tearDown() {
            driver.close();

        }
    }
