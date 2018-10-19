package com.qa;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features=Constants.Path_FeatureFile+Constants.FileName_FeatureFile, glue="com.qa")
public class Runner {
	
}
