package com.sda.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by RENT on 2017-08-28.
 */
public class MyStringUtils {
    public static boolean isUpperCase(String value) {
        return StringUtils.isNotBlank(value) && value.equals(value.toUpperCase());
    }
}

