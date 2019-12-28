package me.nikhilkuyya.learn.service;

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

    public Post getPost(Integer postId) {
        return this.postRepository.getPost(postId);
    }

    public void updatePost(Post updatedPost) {
        this.postRepository.updatePost(updatedPost);
    }

}