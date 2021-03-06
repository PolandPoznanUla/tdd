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


        Scenario: I can list all accounts attached to given user
            Given I create new bank
            When I create new user with firstName Ula and lastName Radon and add it to bank
                And I create new user with firstName Adam and lastName Mickiewicz and add it to bank
                And I create new account for user 0 and add it to bank
                And I create new account for user 0 and add it to bank
                And I create new account for user 1 and add it to bank
            Then User with id 0 is present in bank database
                And User with id 0 has 2 accounts

        Scenario: I can create deposit for account
            Given I create new bank
            When I create new account
                And I add ammount of money to account
                And I add account to bank
            Then Account is present in bank
                And ammount of money is visible in account

        Scenario: I can deposit multiple to same account
            Given I create new bank
            When I create new account
                And I add account to bank
                And I add 100 units of money to account
                And I add 20 units of money to account
                And I add -40 units of money to account
            Then Account is present in bank
                And 80 units of money is present on account

        Scenario: I get list of users sorted by balance
            Given I create new bank
            When I create new user with firstName Adam and lastName Kowalski and add it to bank
                And I create new user with firstName Awa and lastName Farna and add it to bank
                And I create account for user with id 0 and add it to bank
                And I create account for user with id 0 and add it to bank
                And I create account for user with id 1 and add it to bank
                And I add 1000 units of money to account with id 0
                And I add 20 units of money to account with id 0
                And I add -40 units of money to account with id 0
                And I add 20 units of money to account with id 1
                And I add -50 units of money to account with id 2
                And I list users sorted by balance
            Then User with id 1 is on top of the list

