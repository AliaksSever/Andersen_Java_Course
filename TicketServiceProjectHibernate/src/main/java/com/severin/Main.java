package com.severin;

import org.hibernate.Session;
import com.severin.util.HibernateUtil;

public class Main
{
    public static void main( String[] args )
    {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("Connection established");
            HibernateUtil.close();
        }
    }
}