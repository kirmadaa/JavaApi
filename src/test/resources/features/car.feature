Feature: Testing the car

    Scenario: Test the speed of the car
        Given Set the speed of the car to 100
        When I will check the speed of the car
        Then The speed of the car is 100

    Scenario: Test the car api
        Given a new car and set the speed to 412
        When i get all cars and check the last on the list
        Then its speed is 412

    Scenario: Update the car speed
        Given the last car on the list
        When i update its speed to 322
        Then speed of the last car in db is 322

    Scenario: Delete the last car on the list
        Given the number of cars
        When i delete the last car
        Then its total number is less by one

    Scenario: Update the car which doesn't exist in db
        Given the car with id which doesn't exist in db
        When i update its speed
        Then the methods returns