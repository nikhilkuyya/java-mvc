package me.nikhilkuyya.learn.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import java.util.List;
import me.nikhilkuyya.learn.model.Post;

@Repository
public class PostRepository {

    @PersistenceUnit(unitName = "technical-blog")
    private EntityManagerFactory emf;

    public List<Post> fetchPosts() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        List<Post> posts = query.getResultList();
        return posts;
    }

}