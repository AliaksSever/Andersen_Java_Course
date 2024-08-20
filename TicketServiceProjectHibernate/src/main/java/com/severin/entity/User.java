package com.severin.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "creation_date")
    private final Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    @Override
    public String toString() {
        return "User ["+
                "id="+this.id+" "+
                "name="+this.name+" "+
                "creation_date="+this.creationDate+
                "]";
    }

}
