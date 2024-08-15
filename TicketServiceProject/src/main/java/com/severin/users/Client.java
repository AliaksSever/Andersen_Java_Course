package com.severin.users;

import com.severin.module.Ticket;

public class Client extends User{

    private Ticket ticket;

    @Override
    public void printRole() {
        System.out.println("This is User: " + getClass());
    }

    public Ticket getTicket() {
        return ticket;
    }

}
