package edu.springboot.SpringBootApp.controller;




import edu.springboot.SpringBootApp.model.User;
import edu.springboot.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("add")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users/";
    }

    @GetMapping(value = "/{id}/update")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "update";
    }

    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(id, user);
        return "redirect:/users/";
    }

    @DeleteMapping(value = "/users/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users/";
    }

}
