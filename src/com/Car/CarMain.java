package com.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarMain {
    public static void main(String[] args) {

    }
}

class Car{
    private String name;
    private String carName;
    private double  price;

    public Car(String name, String carName, double price) {
        this.name = name;
        this.carName = carName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class CarImplementation{
    public double sumOfPrices(List<Car> carList){
        double[] sum = {0};

        carList.forEach((number) -> {
            sum[0] += number.getPrice();
        });

        return sum[0];
    }
    public List<Car> printName(List<Car> carList){
        return carList.stream().filter((car)-> car.getPrice()>25000).collect(Collectors.toList());
    }
    public double maxPrice(List<Car> carList) {
        return carList.stream().max((x, y) -> Double.compare(x.getPrice(), y.getPrice())).get().getPrice();

    }
}