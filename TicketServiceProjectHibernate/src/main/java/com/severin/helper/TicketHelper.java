package com.severin.helper;

import java.util.List;

import com.severin.entity.Ticket;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class TicketHelper {

    public static List<Ticket> getTicketList(SessionFactory sessionFactory) {
        try(Session session = sessionFactory.openSession();
        ) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
            Root<Ticket> root = cq.from(Ticket.class);
            cq.select(root);

            Query query = session.createQuery(cq);

            return query.getResultList();
        }
    }

    public static Ticket getTicketByID(SessionFactory sessionFactory, int id) {
        try(Session session = sessionFactory.openSession();
        ) {
            return session.get(Ticket.class, id);
        }
    }

    public static Ticket saveTicket(SessionFactory sessionFactory, Ticket ticket) {
        try(Session session = sessionFactory.openSession();
        ) {
            session.getTransaction().begin();
            Ticket savedTicket = session.merge(ticket);
            session.getTransaction().commit();

            return savedTicket;
        }
    }

    public static boolean deleteTicket(SessionFactory sessionFactory, int id) {
        Ticket ticketToRemove = getTicketByID(sessionFactory, id);
        if (ticketToRemove == null) {
            return false;
        }
        try(Session session = sessionFactory.openSession();
        ) {
            session.getTransaction().begin();
            session.remove(ticketToRemove);
            session.getTransaction().commit();

            return true;
        }
    }
}
