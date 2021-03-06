package com.sda.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-08-30.
 */
public class Bank {
    private String name;
    private List<Account> accounts;
    private List<User> users;

    public void adUser(User user) {
        this.users.add(user);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public List<Account> getAccountsByUser(Integer userId) {
        return this.accounts.stream()
                .filter(e -> e.getOwnerId().equals(userId))
                .collect(Collectors.toList());
    }

    public void depositFor(Integer amount, Integer accountId) {
        Account givenAccount =getAccount(accountId);
        givenAccount.setBalance(givenAccount.getBalance() + amount);
    }

    public Account getAccount(Integer id) {
       Account account = null;
        if (id < accounts.size() && id >=0) {
            account = accounts.get(id);
        }
            return account;
    }

    public User getUser(Integer id) {
        User user = null;
        if (id < users.size() && id >=0) {
            user = users.get(id);
        }
        return user;

    }

    public List<User> getSortedUsersByBalance() {
        return users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.users = new ArrayList<>();
    }
}
