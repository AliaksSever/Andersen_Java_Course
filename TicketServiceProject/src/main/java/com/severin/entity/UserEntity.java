package com.severin.entity;

import java.sql.Timestamp;

@lombok.Setter
@lombok.Getter
@lombok.AllArgsConstructor
public class UserEntity {
    private int id;
    private String name;
    private Timestamp creation_date;

    public UserEntity(){}

    @Override
    public String toString() {
        return "Users {" +
                "id="+id+"\t"+
                "name="+name+"\t"+
                "creation_date="+creation_date+"\t"+
                "}";
    }
}
