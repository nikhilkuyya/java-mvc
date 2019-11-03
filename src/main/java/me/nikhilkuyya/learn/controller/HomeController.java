package me.nikhilkuyya.learn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import me.nikhilkuyya.learn.model.Post;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        List<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("Title 1");
        post1.setBody("Body 1");
        post1.setId("1");
        post1.setCreatedDate(new Date());
        posts.add(post1);

        Post post2 = new Post();
        post2.setTitle("Title 2");
        post2.setBody("Body 2");
        post2.setId("2");
        post2.setCreatedDate(new Date());
        posts.add(post2);

        Post post3 = new Post();
        post3.setTitle("Title 3");
        post3.setBody("Body 3");
        post3.setId("3");
        post3.setCreatedDate(new Date());

        posts.add(post3);

        model.addAttribute("posts", posts);
        return "index";
    }
}