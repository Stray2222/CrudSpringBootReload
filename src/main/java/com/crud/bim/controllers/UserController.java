package com.crud.bim.controllers;


import com.crud.bim.exception.PaymentRequiredException;
import com.crud.bim.service.UserServiceImpl;
import com.crud.bim.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
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
                      BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("User", userService.getUserById(id));
        return "edit";
    }

    @ExceptionHandler()
    public ResponseEntity<String> handle(PaymentRequiredException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.PAYMENT_REQUIRED);
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
