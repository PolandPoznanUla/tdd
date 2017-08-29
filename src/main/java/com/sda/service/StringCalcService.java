package com.sda.service;

/**
 * Created by RENT on 2017-08-29.
 */
public class StringCalcService {

    public int calc(String value) {
        String[] split = value.split(";");
        int sum = 0;
        for (int i = 0; i < split.length ; i++) {
            sum += Integer.parseInt(split[i]);
        }
        return sum;
    }
}
