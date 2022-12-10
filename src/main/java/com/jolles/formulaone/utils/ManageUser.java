package com.jolles.formulaone.utils;

import com.jolles.formulaone.model.UserModel;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManageUser {
    @Deprecated // DONT USE OUTSIDE FILE EXCEPT FOR CONFIGURATION
    public static SessionFactory factory = new Configuration().buildSessionFactory();

    /* Method to CREATE a user in the database */
    public Integer addUser(String name, String teamName, int number){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userId = null;

        try {
            tx = session.beginTransaction();
            UserModel user = new UserModel(name, teamName, number);
            userId = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return userId;
    }

    /* Method to  READ all the users */
    public List<UserModel> getUsers( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List users = new ArrayList<>();
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM UserModel").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return users;
    }

    /* Method to DELETE all users from the database */
    public void deleteUsers() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM UserModel");
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }
}