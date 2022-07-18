package Cucumber.glue.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TheInternetLoginPageStepDefs
{

    @Given(value = "user open the Internet login page")
    public void userOpensLoginPage()
    {
        System.out.println("Hello world!");
    }

        @When("^user enters '(.*)' in login field and '(.*})' in password$")
        public void userEntersCredentials(String login, String password);
        System.out.println(login + " " + password);
    }
    }


    

