package me.nikhilkuyya.learn.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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

    public Post createPost(Post newPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newPost);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return newPost;
    }

    public Post updatePost(Post updatedPost) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(updatedPost);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return updatedPost;
    }

    public Post getPost(Integer postId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Post.class, postId);
    }
}