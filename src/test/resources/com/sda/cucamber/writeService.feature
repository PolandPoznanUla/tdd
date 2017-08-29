Feature: WriteService

    Scenario: Test pass for example name
        Given I create new write service
        When I pass example name
        Then result is correct