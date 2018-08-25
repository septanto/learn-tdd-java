package com.septanto.tddtest.bdd.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:bdd/cucumber/features"},
//        format = {"pretty", "html:build/reports/cucumber-report"},
        glue = {"com.septanto.tddtest.bdd.steps"})
public class CucumberTest {
}
