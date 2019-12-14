package com.example.dell.Data;

public class Patient {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    int numero;

    String nom;
    String prenom;
    String sexe;
    String adresse;

    public String getDate_naiss() {
        return Date_naiss;
    }

    public void setDate_naiss(String date_naiss) {
        Date_naiss = date_naiss;
    }

    String Date_naiss;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String email,password;

    public Patient( String nom, String prenom,String date_naiss,String email, String sexe, String adresse,int Numero) {
        this.Date_naiss = date_naiss;
        this.email = email;
        this.numero = Numero;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
    }

    public Patient(int id,String nom, String prenom,String email,String password) {
this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }
}
