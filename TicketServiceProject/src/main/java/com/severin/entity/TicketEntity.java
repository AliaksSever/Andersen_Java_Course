package com.severin.entity;

import com.severin.enums.TicketType;

import java.sql.Timestamp;

@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class TicketEntity {
    private int id;
    private TicketType ticketType;
    private int userId;
    private Timestamp creationTime;

    public TicketEntity(){}

    @Override
    public String toString() {
        return "Ticket {" +
                "id="+id+"\t"+
                "ticketType="+ticketType+"\t"+
                "userId="+userId+"\t"+
                "creationTime"+creationTime+"\t"+
                "}";
    }
}
