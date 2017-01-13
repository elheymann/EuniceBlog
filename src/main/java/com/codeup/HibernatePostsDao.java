package com.codeup;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernatePostsDao implements Posts  {



    private Session session;



    public HibernatePostsDao(Session session) {

        this.session = session;

    }



    @Override

    public List<Post> all() {

        return session.createQuery("from Post").list();

    }



    @Override

    public void insert(Post post) {

        Transaction tx = session.beginTransaction();

        session.save(post);

        tx.commit();

    }



    @Override

    public Post singlePost(int postId) {

        Query query = session.createQuery("from Post where id = :id ");

        query.setParameter("id", postId);

        return (Post) query.getSingleResult();

    }



    @Override

    public void updatePost(Post editedPost) {

        Post existingPost = singlePost(editedPost.getId());

        existingPost.setTitle(editedPost.getTitle());

    existingPost.setDescription(editedPost.getDescription()); //

        Transaction tx = session.beginTransaction();

        session.update(existingPost);

        tx.commit();

    }



    @Override

    public void deletePost(int id) {
        Post post = singlePost(id);

        Transaction tx = session.beginTransaction();

        session.delete(post);

        tx.commit();

    }

}