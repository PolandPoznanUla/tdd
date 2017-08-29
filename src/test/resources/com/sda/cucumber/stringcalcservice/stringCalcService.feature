Feature: WriteService

  Scenario Outline: Test pass for given numbers
    Given I create new string calc service
    When i pass <givenString>
    Then  sum for <givenString> is <expectedSum>
    Examples:
    | givenString | expectedSum |
    | 5;3 | 8 |
    



