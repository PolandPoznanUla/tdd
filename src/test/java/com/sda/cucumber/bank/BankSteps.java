package com.sda.cucumber.bank;

import com.sda.bank.*;
import cucumber.api.java.After;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;


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

    @When("^I create new user with firstName (.*) and lastName (.*) and add it to bank*")
    public void i_create_new_user_with_firstname_ula_and_lastname_radon_and_add_it_to_bank
            (String firstName, String lastName) {
        this.user = UserFactory.createNewUser(firstName, lastName);
        i_add_user_to_bank();
    }

    @And("^And I create new account for user (.*) and add it to bank$")
    public void and_i_create_new_account_for_user_0_and_add_it_to_bank(Integer id) {
//        i_create_new_account();
//        account.setOwnerId(id);
        this.account = AccountFactory.createAccount(id);
        i_add_account_to_bank();
    }

    @Then("^User with id (.*) is present in bank database$")
    public void user_with_id_$id_is_present_in_bank_database(Integer id) {
        boolean result = bank.getUser(id) != null;

        Assert.assertEquals("User with id " + id + "is not present in database", result);
    }

    @And("^User with id (\\d+) has (.*) accounts$")
    public void user_with_id_$id_has_$number_accounts(Integer id, Integer expectedSize) {
        List<Account> accountsByUser = bank.getAccountsByUser(id);
        Assert.assertEquals("User should have: " + expectedSize + " accounts", expectedSize, Integer.valueOf(accountsByUser.size()));
    }


    @And("^I add (-?.*) amount to account$")
    public void i_add_$amount_to_account(Integer amount){
        bank.depositFor(amount, this.account.getId());
    }

    @And("^I add (-?.*) amount to account with (.*) id $")
    public void i_add_$amount_to_account_with_$id(Integer amount, Integer id){
        bank.depositFor(amount, id);
    }

    @And("^I list users sorted by balance$")
    public void i_list_users_sorted_by_balance(){
        Arrays.asList(new Account()).stream()
    }

    @Then("^ammount of money is visible in account$")
    public void ammount_of_money_is_visible_in_account( Integer amount) {
        Account accountFromBank = bank.getAccount(this.account.getId());
        Assert.assertEquals("Ballance is not correct", amount, this.account.getBalance());
    }

    @After
    public  void clearFactories() {
        UserFactory.clearIndex();
        AccountFactory.clearIndex();
    }

}

