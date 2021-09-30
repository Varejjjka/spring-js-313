package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.security.Principal;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    //27-05 Principal возвращает залогиненного пользователя
    @GetMapping("/user")
    public String show(Principal principal, Model model) {
        User username = userService.findByName(principal.getName());
        model.addAttribute("user", username);
        return "show";
    }

    @GetMapping("/userpage")
    public String showUser(Principal principal, Model model) {
        User username = userService.findByName(principal.getName());
        model.addAttribute("user", username);
        return "showuser";
    }

    @GetMapping("/user/test123")
    public String show2(Principal principal, Model model) {
        User username = userService.findByName(principal.getName());
        model.addAttribute("user", username);
        return "showtest2";
    }
}