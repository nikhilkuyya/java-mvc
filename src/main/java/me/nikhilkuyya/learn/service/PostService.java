package me.nikhilkuyya.learn.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import me.nikhilkuyya.learn.model.Post;

@Service
public class PostService {
    public PostService() {
        System.out.println("*** PostService ***");
    }

    public List<Post> getAllPosts() {
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
        return posts;
    }
}