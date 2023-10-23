package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false, defaultValue = "0") Integer count, ModelMap model) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Nissan", "Mx", 1999));
        cars.add(new Car("FF", "999", 1999));
        cars.add(new Car("XX", "888", 1999));
        cars.add(new Car("Ferrari", "777", 1999));
        cars.add(new Car("X-Trail", "Rthx", 1999));
        cars.add(new Car("BMW", "L", 1999));

        CarService carService = new CarServiceImpl(cars);

        List<String> carMessage = new ArrayList<>();

        List<Car> resultCars = carService.getAllCars(count);
        carMessage.add("Cars: ");

        int idx = 0;
        for (Car car : resultCars) {
            carMessage.add("Car " + ++idx + " " +
                    car.getModel() + " " +
                    car.getSeries() + " " +
                    car.getYear());
        }
        model.addAttribute("messages", carMessage);
        return "index";
    }
}