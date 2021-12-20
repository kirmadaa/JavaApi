Feature: Testing the user

    Scenario: Test the name of the user
        Given Name the user as "Kyle"
        When I will check the user name
        Then The user name is "Kyle"

    Scenario: Test the user api
        Given a new user and set the name to "Mark"
        When i get all users and check the last on the list
        Then its name is "Mark"

    Scenario: Update the user name
        Given the last user on the list
        When i update its name to "Lauren"
        Then name of the last user in db is "Lauren"

    Scenario: Delete the last user on the list
        Given the number of users
        When i delete the last user
        Then its users total number is less by one

    Scenario: Update the user which doesn't exist in db
        Given the user with id which doesn't exist in db
        When i update its name
        Then the user method returns