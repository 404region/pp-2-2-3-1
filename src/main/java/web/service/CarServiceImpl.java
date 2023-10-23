package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final List<Car> cars = Arrays.asList(
            new Car("Nissan", "Nnn1", 2003),
            new Car("FX", "123F", 2001),
            new Car("Mx", "73M", 1999),
            new Car("X-Trail", "777", 2000),
            new Car("BMV", "999", 2007)
    );

    @Override
    public List<Car> getAllCars(int count) {
        if (count < 1 || count > cars.size()) {
            count = cars.size();
        }
        return cars.subList(0, count);
    }
}
