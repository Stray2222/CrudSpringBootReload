package com.crud.bim.Controllers;


import com.crud.bim.Service.UserServiceImpl;
import com.crud.bim.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String users(Model model) {
        model.addAttribute("User", userService.getAllUsers());
        return "/index";
    }


    @GetMapping("/new")
    public String addUser(@ModelAttribute("User") User user) {
        return "new";
    }

    @PostMapping()
    public String add(@ModelAttribute("User") @Valid User user,
                      BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return "new";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("User", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return "edit";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
