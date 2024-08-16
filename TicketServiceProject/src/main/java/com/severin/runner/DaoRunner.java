package com.severin.runner;

import com.severin.dao.TicketDao;
import com.severin.entity.TicketEntity;
import com.severin.enums.TicketType;

import java.util.List;
import java.util.Optional;

import java.sql.Timestamp;

public class DaoRunner {

    private final static TicketDao ticketDao = TicketDao.getInstance();

    public static List<TicketEntity> testfindAll() {
        return ticketDao.findAll();
    }

    public static Optional<TicketEntity> testfindById(int id) {
        return ticketDao.findById(id);
    }

    public static void testUpdate() {
        TicketEntity ticket = buildTicketExample(2, TicketType.MONTH, 2);

        ticketDao.update(ticket);
    }

    public static TicketEntity TestSave() {
        TicketEntity ticket = buildTicketExample(2, TicketType.YEAR, 2);
        return ticketDao.save(ticket);
    }

    public static boolean testDelete() {
        TicketEntity ticket = buildTicketExample(6, TicketType.YEAR, 2);
        return ticketDao.delete(ticket.getId());
    }

    private static TicketEntity buildTicketExample(int id, TicketType ticketType, int user_id) {
        return new TicketEntity(
                id,
                ticketType,
                user_id,
                new Timestamp(System.currentTimeMillis())
        );
    }

}
