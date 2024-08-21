package com.severin.enums;

public enum TicketSector {
    A ('A'),
    B ('B'),
    C ('C');

    private final char sector;

    TicketSector(char sector) {
        this.sector = sector;
    }

    public char getSector() {
        return sector;
    }

}
