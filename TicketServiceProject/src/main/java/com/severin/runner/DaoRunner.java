package com.severin.runner;

import com.severin.dao.TicketDao;
import com.severin.dao.UserDao;
import com.severin.entity.TicketEntity;
import com.severin.entity.UserEntity;
import com.severin.enums.TicketType;

import java.util.List;
import java.util.Optional;

import java.sql.Timestamp;

public class DaoRunner {

    private final static TicketDao ticketDao = TicketDao.getInstance();
    private final static UserDao userDao = UserDao.getInstance();

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

//    SAVE
    public static TicketEntity testSaveTicket() {
        TicketEntity ticket = buildTicketExample(2, TicketType.YEAR, 2);
        return ticketDao.save(ticket);
    }

    public static UserEntity testSaveUser() {
        UserEntity user = buildUserExample(1, "Sergey");
        return userDao.save(user);
    }


//    DELETE

    public static boolean testDeleteTicket() {
        TicketEntity ticket = buildTicketExample(6, TicketType.YEAR, 2);
        return ticketDao.delete(ticket.getId());
    }

    public static boolean testDeleteUser() {
        return userDao.delete(2);
    }


//    BUILD TICKET/USER
    private static TicketEntity buildTicketExample(int id, TicketType ticketType, int user_id) {
        return new TicketEntity(
                id,
                ticketType,
                user_id,
                new Timestamp(System.currentTimeMillis())
        );
    }

    private static UserEntity buildUserExample(int id, String name) {
        return new UserEntity(
                id,
                name,
                new Timestamp(System.currentTimeMillis())
        );
    }

}
