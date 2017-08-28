package com.sda.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

/**
 * Created by RENT on 2017-08-28.
 */
public class MyStringUtils {
    public static boolean isUpperCase(String value) {
        return StringUtils.isNotBlank(value) && value.equals(value.toUpperCase());
    }

    public static boolean isArray(String value) {
        return StringUtils.isNotBlank(value) && StringUtils.containsAny(value,",");
    }

    public static String convertToString(String[] array) {
        StrBuilder strBuilder = new StrBuilder();
        for (int i = 0; i < array.length; i++) {
            strBuilder.append(array[i]);
            if (isPenultimate(array, i)){
                strBuilder.append(" and ");
            } else if (!isLast(array, i)) {
                strBuilder.append(", ");
            }
        }
        return strBuilder.toString();
    }

    private static boolean isPenultimate(String[] array, int i) {
        return i == array.length - 2;
    }

    private static boolean isLast(String[] array, int i) {
        return i == array.length - 1;
    }

}

