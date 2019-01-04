package com.hellofresh.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report/smokeTest", "json:build/cucumber.json"},
        features = "src/test/java/com/hellofresh/features",
        glue = "com/hellofish/steps",
        tags= "@big")
public class BigTest {

    //Todo webdriver factory
}
