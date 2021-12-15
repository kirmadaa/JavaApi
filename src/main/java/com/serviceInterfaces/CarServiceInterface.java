package com.serviceInterfaces;

import com.model.Car;

public interface CarServiceInterface {
    public Car saveCar(Car car);
    public Iterable<Car> getAllCars();
    public Car getCarById(int id);
    public void deleteCar(int id);
    public void updateCar(Car car, int id);
}
