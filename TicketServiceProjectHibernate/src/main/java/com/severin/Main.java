package com.severin;

import org.hibernate.Session;
import com.severin.util.HibernateUtil;

import com.severin.entity.User;

import java.sql.Timestamp;

public class Main
{
    public static void main( String[] args )
    {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.getTransaction().begin(); // open transaction


            User user = new User();
            user.setName("Alex3");


            session.persist(user); //save changes in object
            session.getTransaction().commit(); //commit changes and close transactions

            HibernateUtil.close(); // close SessionFactory
        }
    }
}