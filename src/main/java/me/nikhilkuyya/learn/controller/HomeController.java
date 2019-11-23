package me.nikhilkuyya.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.nikhilkuyya.learn.model.Post;
import me.nikhilkuyya.learn.service.PostService;

@Controller
public class HomeController {

    public HomeController() {
        System.out.println("*** HomeController ***");
    }

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        List<Post> posts = this.postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}