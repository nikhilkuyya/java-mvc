package me.nikhilkuyya.learn.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

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

    public List<Post> getAllPostsWithoutJPI() {

        List<Post> posts = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/technical-blog",
                    "postgres", "nikhilKuyya");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from post");
            while (resultSet.next()) {
                Post post1 = new Post();
                post1.setTitle(resultSet.getString("title"));
                post1.setBody(resultSet.getString("body"));
                post1.setId(resultSet.getString("id"));
                post1.setCreatedDate(new Date());
                posts.add(post1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

}