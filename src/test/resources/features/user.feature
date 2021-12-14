Feature: Testing the user

    Scenario: Test the name of the user
        Given Name the user as "Kyle"
        When I will check the user name
        Then The user name is "Kyle"