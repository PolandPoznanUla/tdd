package com.sda.bank;

/**
 * Created by RENT on 2017-08-30.
 */
public class AccountFactory {

    private static Integer counter;

    public static Account createAccount(Integer userId) {
        return new Account(counter++, 0, userId);
    }

    public static Account createAccount() {
        return new Account(counter++, 0);
    }

    public static void clearIndex() {
        counter = 0;
    }
}
