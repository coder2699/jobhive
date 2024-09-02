package com.personal.jobhive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.jobhive.entities.User;
import com.personal.jobhive.forms.UserForm;
import com.personal.jobhive.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("name", "Pranshu Pandey");
        model.addAttribute("githubRepo", "https://github.com/coder2699/");
        return "home";
    }

    // about route
    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("isLogin", true);
        System.out.println("About page loading");
        return "about";
    }

    // services
    @GetMapping("/services")
    public String servicesPage() {
        System.out.println("services page loading");
        return "services";
    }

    // job
    @GetMapping("/job")
    public String jobPage() {
        System.out.println("job page loading");
        return "job";
    }

    // login
    @GetMapping("/login")
    public String loginPage() {
        return new String("login");
    }

    // register
    @GetMapping("/register")
    public String registerPage(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        return "register";
    }

    // processing register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        System.out.println("Processing registration");

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setProfilePic("https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg");
        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        return "redirect:/register";
    }

}