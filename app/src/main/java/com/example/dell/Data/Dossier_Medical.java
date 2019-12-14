package com.example.dell.Data;

public class Dossier_Medical {
    int id;
    double poids;
    double hauteur;
    String type_sanguin;
    String  allergie;
    String maladie_chronique;
    double glycemie;
    double tensien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public String getType_sanguin() {
        return type_sanguin;
    }

    public void setType_sanguin(String type_sanguin) {
        this.type_sanguin = type_sanguin;
    }

    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getMaladie_chronique() {
        return maladie_chronique;
    }

    public void setMaladie_chronique(String maladie_chronique) {
        this.maladie_chronique = maladie_chronique;
    }

    public double getGlycemie() {
        return glycemie;
    }

    public void setGlycemie(double glycemie) {
        this.glycemie = glycemie;
    }

    public double getTensien() {
        return tensien;
    }

    public void setTensien(double tensien) {
        this.tensien = tensien;
    }

    public Dossier_Medical(int id, double poids, double hauteur, String type_sanguin, String allergie, String maladie_chronique, double glycemie, double tensien) {
        this.id = id;
        this.poids = poids;
        this.hauteur = hauteur;
        this.type_sanguin = type_sanguin;
        this.allergie = allergie;
        this.maladie_chronique = maladie_chronique;
        this.glycemie = glycemie;
        this.tensien = tensien;
    }

    public Dossier_Medical(double poids, double hauteur, String type_sanguin, String allergie, String maladie_chronique, double glycemie, double tensien) {
        this.poids = poids;
        this.hauteur = hauteur;
        this.type_sanguin = type_sanguin;
        this.allergie = allergie;
        this.maladie_chronique = maladie_chronique;
        this.glycemie = glycemie;
        this.tensien = tensien;
    }

    public Dossier_Medical(double poids, double hauteur,double glycemie, double tensien) {
        this.poids = poids;
        this.hauteur = hauteur;
        this.glycemie = glycemie;
        this.tensien = tensien;
    }
}
