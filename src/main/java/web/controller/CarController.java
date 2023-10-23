package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarServiceImpl carServiceImpl;

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false, defaultValue = "0") Integer count, ModelMap model) {


        List<String> carMessage = new ArrayList<>();

        List<Car> resultCars = carServiceImpl.getAllCars(count);
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