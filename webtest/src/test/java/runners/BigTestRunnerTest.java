package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import helpers.ConfigurationManager;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber-report/smoketest", "json:target/cucumber.json"},
        features = "src/test/java/features",
        glue = "steps",
        tags = "@big")

public class BigTestRunnerTest {

    @BeforeClass
    static public void setupTimeout() {
        ConfigurationManager.setup();
        Configuration.timeout = 100000;
    }


}
