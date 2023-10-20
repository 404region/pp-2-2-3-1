package web.service;

import web.model.Car;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getAllCars(List<Car> cars, int count) {
        List<Car> sublist = cars.subList(0, count);
        return  sublist;
    }
}
