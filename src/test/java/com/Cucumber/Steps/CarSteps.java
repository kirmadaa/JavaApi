package com.Cucumber.Steps;

import com.model.Car;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

@SpringBootTest
public class CarSteps {

    Car car = new Car();
    Integer testSpeed = 0;
    @Autowired
    CarService carService = new CarService();
    Iterable<Car> cars;
    List<Car> carList;
    int carId;
    int totalNrOfCars;

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

    //========================================================

    @Given("a new car and set the speed to {int}")
    public void a_new_car_and_set_the_speed_to(Integer int1) {
        car.setSpeed(int1);
        carService.saveCar(car);
    }
    @When("i get all cars and check the last on the list")
    public void i_get_all_cars_and_check_the_last_on_the_list() {
        cars = carService.getAllCars();
        carList = StreamSupport.stream(cars.spliterator(), false).collect(Collectors.toList());
        car = carList.get(carList.size() - 1);
        car = carService.getCarById(car.getId());
    }
    @Then("its speed is {int}")
    public void its_speed_is(Integer int1) {
        assertEquals((long)int1, car.getSpeed());
    }

    //===================================================

    @Given("the last car on the list")
    public void the_last_car_on_the_list() {
        cars = carService.getAllCars();
        carList = StreamSupport.stream(cars.spliterator(), false).collect(Collectors.toList());
        car = carList.get(carList.size() - 1);
    }
    @When("i update its speed to {int}")
    public void i_update_its_speed_to(Integer int1) {
        car.setSpeed(int1);
        carId = car.getId();
        carService.updateCar(car, carId);
    }
    @Then("speed of the last car in db is {int}")
    public void speed_of_the_last_car_in_db_is(Integer int1) {
        cars = carService.getAllCars();
        carList = StreamSupport.stream(cars.spliterator(), false).collect(Collectors.toList());
        car = carList.get(carList.size() - 1);
        assertEquals((long)int1, car.getSpeed());
    }

    //============================================

    @Given("the number of cars")
    public void the_number_of_cars() {
        cars = carService.getAllCars();
        carList = StreamSupport.stream(cars.spliterator(), false).collect(Collectors.toList());
        totalNrOfCars = carList.size();
        car = carList.get(totalNrOfCars - 1);
    }
    @When("i delete the last car")
    public void i_delete_the_last_car() {
        carService.deleteCar(car.getId());
    }
    @Then("its total number is less by one")
    public void its_total_number_is_less_by_one() {
        cars = carService.getAllCars();
        carList = StreamSupport.stream(cars.spliterator(), false).collect(Collectors.toList());
        assertEquals((long)totalNrOfCars - 1, carList.size());
    }
}
