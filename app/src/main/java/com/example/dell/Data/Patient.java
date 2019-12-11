package com.example.dell.Data;

public class Patient {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getContact_urgence() {
        return contact_urgence;
    }

    public void setContact_urgence(int contact_urgence) {
        this.contact_urgence = contact_urgence;
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

    int age;
    int numero;
    int contact_urgence;
    String nom,prenom,sexe,adresse;

    public Patient(int id, int age, int numero, int contact_urgence, String nom, String prenom, String sexe, String adresse) {
        this.id = id;
        this.age = age;
        this.numero = numero;
        this.contact_urgence = contact_urgence;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
    }
}
