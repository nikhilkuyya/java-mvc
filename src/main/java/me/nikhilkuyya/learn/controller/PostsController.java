package me.nikhilkuyya.learn.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "post/index";
    }

    @RequestMapping("/post/newPost")
    public String getCreatePostView() {
        return "post/create";
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String createPost(Post post) {
        post.setCreatedDate(new Date());
        this.postService.addPost(post);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/post/edit", method = RequestMethod.GET)
    public String editPost(@RequestParam("postId") Integer postId, Model model) {
        Post editPost = this.postService.getPost(postId);
        model.addAttribute("post", editPost);
        return "post/edit";
    }

    @RequestMapping(value = "/post/update", method = RequestMethod.POST)
    public String updatePost(@RequestParam("postId") Integer postId, Post updatedPost) {
        updatedPost.setId(postId);
        updatedPost.setCreatedDate(new Date());
        this.postService.updatePost(updatedPost);
        System.out.println(updatedPost.getTitle());
        return "redirect:/posts";
    }

}