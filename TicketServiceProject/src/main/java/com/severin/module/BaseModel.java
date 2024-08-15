package com.severin.module;

public abstract class BaseModel {

    private static int IdCounter = 0;

    private int ID;

    public int getID() {
        return this.ID;
    };

    public void setID() {
        IdCounter+=1;
        this.ID = IdCounter;
    };

}
