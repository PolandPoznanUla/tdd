package com.sda.service;

import com.sda.util.MyStringUtils;
import org.apache.commons.lang3.StringUtils;

public class WriteService {

    public String action(String name) {
        String prefix= initPrefix(name);
        String value= initName(name);
        String suffix= initSuffix(name);
        return prefix + name + suffix;
    }

    private String initPrefix(String name){
        return MyStringUtils.isUpperCase(name) ? "HELLO, " : "Hello, ";

    }

    private String initSuffix(String name) {
        return MyStringUtils.isUpperCase(name) ? " !" : "";
    }

    private String initName(String name) {

        return StringUtils.isBlank(name) ? "my friend" : name;
    }

}
