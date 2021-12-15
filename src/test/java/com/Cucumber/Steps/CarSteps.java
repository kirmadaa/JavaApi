package com.Cucumber.Steps;

import com.model.Car;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

@SpringBootTest
public class CarSteps {

    Car car = new Car();
    Integer testSpeed = 0;

    @Given("Set the speed of the car to {int}")
    public void set_the_speed_of_the_car_to(Integer int1) {
        car.setSpeed(int1);
    }
    @When("I will check the speed of the car")
    public void i_will_check_the_speed_of_the_car() {
        testSpeed = (int)car.getSpeed();
    }
    @Then("The speed of the car is {int}")
    public void the_speed_of_the_car_is(Integer int1) {
        assertEquals(int1, testSpeed);
    }
}
