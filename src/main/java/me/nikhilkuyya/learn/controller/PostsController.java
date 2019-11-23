package me.nikhilkuyya.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import me.nikhilkuyya.learn.model.Post;
import me.nikhilkuyya.learn.service.PostService;

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        List<Post> posts = this.postService.getAllPosts().subList(0, 1);
        model.addAttribute("posts", posts);
        return "posts";
    }

}