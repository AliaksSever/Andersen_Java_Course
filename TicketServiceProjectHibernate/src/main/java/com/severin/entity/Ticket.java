package com.severin.entity;

import com.severin.enums.TicketType;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;

import java.sql.Timestamp;

@Entity
@Table(name = "tickets", schema = "public", catalog = "postgres")
@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="ticket_type")
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::ticket_type")
    private TicketType ticketType;

    @Column(name="user_id")
    private int userId;

    @Column(name="creation_date")
    private final Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @Override
    public String toString() {
        return "Ticket ["+
                "id="+this.id+" "+
                "type="+this.ticketType+" "+
                "userId="+this.userId+" "+
                "creationDate="+this.creationDate+
                "]";
    }
}
