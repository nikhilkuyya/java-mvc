package me.nikhilkuyya.learn.controller;

import java.util.Date;
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
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        List<Post> posts = this.postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("/post/newPost")
    public String getCreatePostView() {
        return "create-post";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String createPost(Post post) {
        post.setCreatedDate(new Date());
        this.postService.addPost(post);
        return "redirect:/posts";
    }

}