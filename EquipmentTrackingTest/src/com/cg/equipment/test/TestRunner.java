package com.cg.equipment.test;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Features"},
		glue= {"com.cg.equipment.stepDefinitions"},tags= {"@Tag"})
public class TestRunner {

}
