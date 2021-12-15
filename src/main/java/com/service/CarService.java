package com.service;

import com.model.Car;
import com.repository.CarRepository;
import com.serviceInterfaces.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService implements CarServiceInterface {

    @Autowired
    CarRepository carRepository;
    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }
    @Override
    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }
    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
    @Override
    public void updateCar(Car car, int id) {
        Car tempCar = carRepository.findById(id).orElse(null);
        if(tempCar == null)return;
        tempCar.setSpeed(car.getSpeed());
        carRepository.save(tempCar);
    }
}
