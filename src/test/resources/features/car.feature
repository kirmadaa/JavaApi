Feature: Testing the car

    Scenario: Test the speed of the car
        Given Set the speed of the car to 100
        When I will check the speed of the car
        Then The speed of the car is 100