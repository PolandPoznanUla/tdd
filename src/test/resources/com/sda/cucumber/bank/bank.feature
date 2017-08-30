Feature: Bank Account
    Scenario: Newly created user is visible in bank database
    Given I create new bank
    When I create new user
        And I add user to bank
    Then User is present in bank database

    Scenario: I can create user and account, and then they are present in bank database
    Given I create new bank
    When I create new user
        And I add user to bank
        And I create new account
        And I add user to account
        And I add account to bank
    Then User is present in bank database
        And Account is present in bank database
        And User is attached to account