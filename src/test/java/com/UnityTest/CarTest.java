package com.UnityTest;

import com.model.Car;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    Car temp = new Car();

    @org.junit.Test
    public void getId() {
        temp.setSpeed(200);
        assertEquals(200, temp.getSpeed());
    }

    @org.junit.Test
    public void setId() {
        temp.setId(1000);
        assertEquals(1000, temp.getId());
    }

    @org.junit.Test
    public void getSpeed() {
        temp.setSpeed(200);
        assertEquals(200, temp.getSpeed());
    }

    @org.junit.Test
    public void setSpeed() {
        temp.setSpeed(300);
        assertEquals(300, temp.getSpeed());
    }
}