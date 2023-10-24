package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carServiceImpl;

    @GetMapping(value = "/cars")
    public String printWelcome(@RequestParam(value = "count", required = false, defaultValue = "0") Integer count, ModelMap model) {

        List<Car> carsList = carServiceImpl.getAllCars(count);
        model.addAttribute("carsList", carsList);
        return "cars";
    }
}