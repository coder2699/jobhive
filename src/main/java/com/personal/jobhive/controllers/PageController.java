package com.personal.jobhive.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {
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
        System.out.println("login page loading");
        return "login";
    }

    // register
    @GetMapping("/register")
    public String registerPage() {
        System.out.println("register page loading");
        return "register";
    }
}
