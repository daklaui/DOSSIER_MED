package com.example.dell.Data;

import java.util.Date;

public class Analyse {
    int id;
    String libelleAnalyse;
    Date date_analyse;
    String résultatAnalyse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleAnalyse() {
        return libelleAnalyse;
    }

    public void setLibelleAnalyse(String libelleAnalyse) {
        this.libelleAnalyse = libelleAnalyse;
    }

    public Date getDate_analyse() {
        return date_analyse;
    }

    public void setDate_analyse(Date date_analyse) {
        this.date_analyse = date_analyse;
    }

    public String getRésultatAnalyse() {
        return résultatAnalyse;
    }

    public void setRésultatAnalyse(String résultatAnalyse) {
        this.résultatAnalyse = résultatAnalyse;
    }

    public Analyse(int id, String libelleAnalyse, Date date_analyse, String résultatAnalyse) {
        this.id = id;
        this.libelleAnalyse = libelleAnalyse;
        this.date_analyse = date_analyse;
        this.résultatAnalyse = résultatAnalyse;
    }
}

