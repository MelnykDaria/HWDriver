package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;

    public abstract class Loginpage extends BasePage {

        private static By loginField = By.name("login");
        private static By passwordField = By.cssSelector("[name='password']");
        private static By submitButton = By.cssSelector("[type='submit']");

        public Loginpage(WebDriver driver) {
            super(driver);
            pageUrl="https://mail.ukr.net/";
        }
        public static void navigate()
        {
            driver.get(pageUrl);
        }

        public static void login(User user) {
            driver.findElement(loginField).sendKeys(user.getLogin());
            driver.findElement(passwordField).sendKeys(user.getPassword());
            driver.findElement(submitButton).click();
        }

        protected abstract String pageUrl();
    }

