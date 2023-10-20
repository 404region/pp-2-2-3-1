package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Nissan", "Mx", 1999));
        cars.add(new Car("FF", "999", 1999));
        cars.add(new Car("XX", "888", 1999));
        cars.add(new Car("Ferrari", "777", 1999));
        cars.add(new Car("X-Trail", "Rthx", 1999));
        cars.add(new Car("BMW", "L", 1999));

        if(count == null || count > cars.size()){
            count = cars.size();
        }

        List<String> carMessage = new ArrayList<>();
        CarService carService = new CarServiceImpl();

        List<Car> resultCars = carService.getAllCars(cars, count);
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