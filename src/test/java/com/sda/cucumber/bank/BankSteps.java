package com.sda.cucumber.bank;

import com.sda.bank.*;
import cucumber.api.java.After;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import javax.jws.soap.SOAPBinding;

/**
 * Created by RENT on 2017-08-30.
 */
public class BankSteps {

    private Bank bank;
    private User user;
    private Account account;
    private Integer ownerId;

    @Given("^I create new bank$")
    public void i_create_new_bank() {
        this.bank = new Bank("SDA");
    }

    @When("^I create new user$")
    public void i_create_new_user() {
        this.user = UserFactory.createNewUser("Ula", "Radoń");
    }

    @And("^I add user to bank$")
    public void i_add_user_to_bank() {
        this.bank.adUser(user);
    }

    @And("^I create new account$")
    public void i_create_new_account() {
        this.account = AccountFactory.createAccount();
    }

    @And("^I add user to account$")
    public void i_add_user_to_account() {
       this.account.setOwnerId(user.getId());
    }

    @And("^I add account to bank$")
    public void i_add_account_to_bank() {
        bank.addAccount(account);
    }

    @Then("User is present in bank database^$")
    public void user_is_present_in_bank_database() {
        boolean result = this.bank.getUsers().contains(user);

        Assert.assertTrue("User is not present in Bank", result);
    }

    @And("^Account is present in bank database$")
    public void account_is_present_in_bank_database() {
        boolean result = this.bank.getAccounts().contains(account);
        
        Assert.assertTrue("Account is not present in Bank", result);
    }

    @And("^User is attached to account in bank database$")
    public void user_is_attached_to_account_in_bank_database() {
        Account accountFromDatabase = bank.getAccount(this.account.getId());
        User userFromDatabase = bank.getUser(this.user.getId());
        boolean result = accountFromDatabase.getOwnerId().equals(userFromDatabase.getId());

        Assert.assertTrue("Account is not attached do user", result);
    }

    @After
    public  void clearFactories() {
        UserFactory.clearIndex();
        AccountFactory.clearIndex();
    }
}
