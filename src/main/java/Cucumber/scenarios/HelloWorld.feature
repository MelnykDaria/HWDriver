
Feature: login
As a nin logged user
I want to Login
So I can use the Internet connection

Scenario: Valid Login test

    Given user open the Internet login page
    When  user enters 'tomsmith' in login field and 'SuoerSecretPassword' in password
    And clicks 'login' button
    Then user is logged in

    Scenario Outline: Negative test
        Given user open the Internet login page
        When  user enters 'tomsmith' in login field and 'SuoerSecretPassword' in password
        And clicks 'login' button
        Then user sees error message

        Examples:
        |login|password|
        |qweqwe|SuperSecretPassword|
        |tomsmith|qweqwe|
        |qweqweqwe|qweqwe|

