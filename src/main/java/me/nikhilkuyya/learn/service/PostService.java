package me.nikhilkuyya.learn.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.nikhilkuyya.learn.model.Post;
import me.nikhilkuyya.learn.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService() {
        System.out.println("*** PostService ***");
    }

    public List<Post> getAllPosts() {
        return this.postRepository.fetchPosts();
    }

    public void addPost(Post post) {
        this.postRepository.createPost(post);
    }

}