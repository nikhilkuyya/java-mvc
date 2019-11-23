package me.nikhilkuyya.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.nikhilkuyya.learn.model.User;

@Controller
public class UserController {

    @RequestMapping("users/login")
    public String login() {
        System.out.println("Get the login");
        return "users/login";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String login(User user) {
        System.out.println("Post the login" + user.getUserName() + " " + user.getPassword());
        return "redirect:/posts";
    }

    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }

    @RequestMapping(value = "posts", method = RequestMethod.POST)
    public String redirectLogout() {
        return "redirect:/";
    }

}