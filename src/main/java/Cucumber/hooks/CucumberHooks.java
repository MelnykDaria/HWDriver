package Cucumber.hooks;

import io.cucumber.java.Before;

public class CucumberHooks {
    @Before(order = 0)
    public void beforeMethod(){
        System.out.println("First before");

    }

    @Before(order = 1)
    public void secondBefore(){
        System.out.println("Second before");
    }
}

