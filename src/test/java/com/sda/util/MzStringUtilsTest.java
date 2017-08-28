package com.sda.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

/**
 * Created by RENT on 2017-08-28.
 */
public class MzStringUtilsTest {

    public void shouldReturnValueWithUpperCases() {
        String givenValue = "ALA MA KOTA";
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertTrue("Expected value contains lower cases", result);
    }

    public void shouldReturnValueWithLowerCases() {
        String givenValue = "Ala ma kota";
        boolean result = MyStringUtils.isUpperCase(givenValue);

        Assert.assertFalse("Result is true", result);
    }
}
