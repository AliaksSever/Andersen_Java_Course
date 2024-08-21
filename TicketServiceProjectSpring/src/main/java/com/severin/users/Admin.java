package com.severin.users;

import com.severin.module.Ticket;

public class Admin extends User{

    private final static Admin adminInstance =  new Admin();

    private Admin() {}

    public static Admin getAdminInstance() {
        return adminInstance;
    }

    @Override
    public void printRole() {
        System.out.println("This is Admin: " + getClass());
    }

    public boolean checkTicket(Ticket ticket, int id) {
        return ticket.getID() == id;
    }
}
