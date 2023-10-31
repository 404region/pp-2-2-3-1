package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user-delete")
    public String deleteUser(@RequestParam(value = "id", required = false, defaultValue = "0") Long idVar) {
        System.out.println("id" + idVar);
        userService.deleteById(idVar);
        return "redirect:/";
    }

    @GetMapping("/user-update")
    public String updateUserForm(@RequestParam(value = "id", required = false, defaultValue = "0") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("user-update")
    public String updateUser(User user) {
        System.out.println(user.toString());
        userService.saveUser(user);
        return "redirect:/";
    }
}

