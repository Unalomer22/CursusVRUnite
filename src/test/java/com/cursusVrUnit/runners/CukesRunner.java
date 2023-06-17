package com.cursusVrUnit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com/cursusVrUnit/stepdefinitions",
        //dryRun = true, //oldugunda sadece eksik senaryoyu calistiriyor.
        dryRun = false// oldugunda bütün senaryoyu calistiriyor. Default
        ,tags = "@wip"
// Before version 4 --> {"@Smoke" and "@Wip"} ---> and
// Before version 5 --> "@Smoke ,@Wip" ---> or
// Before version 5 --> {"@Login" , "~@Wip"} ---> and not
)
public class CukesRunner {

}