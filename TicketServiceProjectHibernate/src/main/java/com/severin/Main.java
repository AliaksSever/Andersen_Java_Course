package com.severin;

import com.severin.helper.UserHelper;
import com.severin.util.HibernateUtil;

import com.severin.entity.User;
import org.hibernate.SessionFactory;
import java.util.List;

public class Main
{
    public static void main( String[] args )
    {
        try(SessionFactory sessionFactory =  HibernateUtil.getSessionFactory()
        ) {
            List<User> userList = UserHelper.getUsersList(sessionFactory);
            for (User user: userList) {
                System.out.println(user);
            }
        }
    }
}