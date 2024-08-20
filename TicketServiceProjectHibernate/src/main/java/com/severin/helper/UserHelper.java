package com.severin.helper;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import com.severin.entity.User;
import org.hibernate.SessionFactory;

public class UserHelper {

    public static List<User> getUsersList(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession();
        ) {
            List<User> userList = new ArrayList<User>();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> cq = cb.createQuery(User.class);

            Root<User> root = cq.from(User.class);
            cq.select(root);


            Query query = session.createQuery(cq);
            userList = query.getResultList();

            return userList;
        }
    }

    public static User getUserById(SessionFactory sessionFactory, int id) {
        try(
            Session session = sessionFactory.openSession();
        ) {
            return session.get(User.class, id);
        }
    }

    public static User saveUser(SessionFactory sessionFactory, String name) {
        try(Session session = sessionFactory.openSession();
        ) {
            User user = new User();
            user.setName(name);

            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();

            return user;
        }
    }

    public static boolean deleteUser(SessionFactory sessionFactory, int id) {
        User userToRemove = getUserById(sessionFactory, id);
        try(Session session = sessionFactory.openSession();
        ) {
            session.getTransaction().begin();
            session.remove(userToRemove);
            session.getTransaction().commit();
        }
        return getUserById(sessionFactory, id) == null;
    }

    public static User updateUser(SessionFactory sessionFactory, String userName, int id) {
        User user = getUserById(sessionFactory, id);
        try(Session session = sessionFactory.openSession();
        ) {
            User updatedUser = null;
            try {
                user.setName(userName);

                session.getTransaction().begin();
                updatedUser = session.merge(user);
                session.getTransaction().commit();

            } catch (NullPointerException e) {
                System.out.println("Object with id " +id+" does not exist.");
            }
            return updatedUser;
        }
    }

}
