package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private String[] carToStringArray(Car car){
        String[] carInfo = {car.getMake(),car.getModel(), String.valueOf(car.getYear())};
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){

        Car car1 = new Car("Toyota","Fortuner",2019);
        Car car2 = new Car("Toyota","Fortuner",2019);
        Car actual = new Car("Hyundai","Creta",2018);

        String[] expected = {"Hyundai","Creta","2018"};

        assertArrayEquals(carToStringArray(car1),carToStringArray(car2));
        assertArrayEquals(expected,carToStringArray(actual));
    }

}