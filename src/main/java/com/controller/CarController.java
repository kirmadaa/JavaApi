package com.controller;

import com.model.Car;
import com.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public String add(@RequestBody Car car){
        carService.saveCar(car);
        return "New car has been added";
    }

    @GetMapping("/getAllCars")
    public Iterable<Car> getAllCarsFrom() {
        return carService.getAllCars();
        }

    @GetMapping("/getById/{id}")
    public Car getCar(@PathVariable("id") int id){
        return carService.getCarById(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void delete(@PathVariable("id") int id){
        carService.deleteCar(id);
    }

    @PutMapping("/update/{id}")
    public String updateCar(@RequestBody Car car, @PathVariable("id") int id){
        carService.updateCar(car, id);
        return "car updated";
    }
}
