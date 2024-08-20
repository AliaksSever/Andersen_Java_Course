package com.severin.helper;

import java.util.List;

import com.severin.entity.Ticket;

import com.severin.entity.User;
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
}
