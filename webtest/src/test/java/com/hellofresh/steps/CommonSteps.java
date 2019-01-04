package com.hellofresh.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.PageManager;
import pages.WebPage;

import javax.jws.WebParam;

public class CommonSteps {

    @Given("^open page (?i)(HOME|NEW)$")
    public void openPage(String regexpForPages) throws Throwable {
        PageManager.openPage(regexpForPages);
    }

}
