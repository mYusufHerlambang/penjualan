package com.wings.penjualan.controller;

import com.wings.penjualan.dto.user.UserRegisterDTO;
import com.wings.penjualan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerForm")
    public String insertAdminForm(Model model){

        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();

        model.addAttribute("user", userRegisterDTO);

        return "user/register-form";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserRegisterDTO userRegisterDTO,
                              BindingResult bindingResult,
                              Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("type", "insert");
            model.addAttribute("breadCrumbs", "Super Admin ");

            return "user/register-form";
        } else {

            userService.registerUser(userRegisterDTO);

            return "redirect:/login/login-page";
        }
    }
}
