package com.example.dell.Data;

import java.util.Date;

public class Chirugie {
    int id;
    String discriptionChirugie;
    Date dateChirugie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscriptionChirugie() {
        return discriptionChirugie;
    }

    public void setDiscriptionChirugie(String discriptionChirugie) {
        this.discriptionChirugie = discriptionChirugie;
    }

    public Date getDateChirugie() {
        return dateChirugie;
    }

    public void setDateChirugie(Date dateChirugie) {
        this.dateChirugie = dateChirugie;
    }

    public Chirugie(int id, String discriptionChirugie, Date dateChirugie) {
        this.id = id;
        this.discriptionChirugie = discriptionChirugie;
        this.dateChirugie = dateChirugie;
    }
}
