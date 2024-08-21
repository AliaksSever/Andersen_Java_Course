package com.severin;

import com.severin.entity.Ticket;
import com.severin.enums.TicketType;
import com.severin.helper.TicketHelper;
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
            List<Ticket> ticketList = TicketHelper.getTicketList(sessionFactory);
            for (Ticket ticket: ticketList) {
                System.out.println(ticket);
            }
        }
    }
}