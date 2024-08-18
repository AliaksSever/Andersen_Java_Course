package com.severin.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = initSessionFactory();

    private static SessionFactory initSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure();

        try {
            return configuration.buildSessionFactory();
        }
        catch (Throwable err) {
            System.out.println("Initial SessionFactory creation failed" + err.getMessage());
            throw new RuntimeException(err);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }

}
