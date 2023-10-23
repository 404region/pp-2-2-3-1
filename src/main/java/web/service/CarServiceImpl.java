package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    @Autowired
    public CarServiceImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public List<Car> getAllCars(int count) {
        if (count < 1 || count > cars.size()) {
            count = cars.size();
        }
        return cars.subList(0, count);
    }
}
