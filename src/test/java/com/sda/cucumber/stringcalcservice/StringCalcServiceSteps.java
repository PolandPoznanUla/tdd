package com.sda.cucumber.stringcalcservice;

import com.sda.service.StringCalcService;
import com.sda.service.WriteService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Szymon on 2017-08-29.
 */
public class StringCalcServiceSteps {

    private StringCalcService stringCalcService;

    private String givenString;

    @Given("^I create new string calc service$")
    public void I_create_new_string_calc_service() {
        stringCalcService = new StringCalcService();
    }

    @When("^i pass (.*)$")
    public void i_pass_example_string(String exampleString) {
        givenString = exampleString;
    }

    @Then("^sum for (.*) is (.*)$")
    public void sum_is_correct(String exampleString, int expectedSum) {
        Assert.assertEquals("Expected value should be different", expectedSum, stringCalcService.calc(givenString));
    }


}
