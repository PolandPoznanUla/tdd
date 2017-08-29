package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by RENT on 2017-08-29.
 */
public class StringCalcServiceTest {


     private StringCalcService stringCalcService;

     @Before
     public void init() {
         stringCalcService = new StringCalcService();
     }


    @Test
    public void shouldSumDigitsInGivenString() {
        String value = "5;3";
        int actualValue = StringCalcService.calc(value);
        int expectedValue = 8;

        Assert.assertEquals("Results are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldSumNumbersForGivenStrin() {
        String value = "23;333";
        int actualValue = StringCalcService.calc(value);
        int expectedValue = 356;

        Assert.assertEquals("Results are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldSumManyNumbersInGivenStrin() {
        String value = "22;32;2;6;8";
        int actualValue = StringCalcService.calc(value);
        int expectedValue = 70;

        Assert.assertEquals("Results are not the same", expectedValue, actualValue);
    }
}
