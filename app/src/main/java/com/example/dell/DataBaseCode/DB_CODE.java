package com.example.dell.DataBaseCode;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class DB_CODE {
    private BD_Dossier_Medical dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DB_CODE(Context c) {
        context = c;
    }

    public DB_CODE open() throws SQLException {
        dbHelper = new BD_Dossier_Medical(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // insert persone
    public void insert_patient(String nom, String prenom, String sexe, int tel, String email, String mdp, String adresse, String date_naiss) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.NOM, nom);
        contentValue.put(BD_Dossier_Medical.PRENOM, prenom);
        contentValue.put(BD_Dossier_Medical.SEXE, sexe);
        contentValue.put(BD_Dossier_Medical.NUMERO, tel);
        contentValue.put(BD_Dossier_Medical.EMAIL, email);
        contentValue.put(BD_Dossier_Medical.PASSWORD, mdp);
        contentValue.put(BD_Dossier_Medical.ADRESSE, adresse);
        contentValue.put(BD_Dossier_Medical.DATENAIS, date_naiss);
        database.insert(BD_Dossier_Medical.TABLE_NAME_PATIENT, null, contentValue);
    }

    // insert analyse
    public void insert_analyse(String libelle, String date_analyes, String resultat) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.LIBELLEANALYSE, libelle);
        contentValue.put(BD_Dossier_Medical.DATEANALYSE, date_analyes);
        contentValue.put(BD_Dossier_Medical.RESULTATANALYSE, resultat);
        database.insert(BD_Dossier_Medical.TABLE_NAME_ANALYSE, null, contentValue);
    }


    // insert CHIRUGIE
    public void insert_CHIRUGIE(String discription, String date_CHIRUGIE) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.DISCRIPTIONCHIRUGIE, discription);
        contentValue.put(BD_Dossier_Medical.DATECHIRUGIE, date_CHIRUGIE);
        database.insert(BD_Dossier_Medical.TABLE_NAME_CHIRUGIE, null, contentValue);
    }

    // insert TABLE_NAME_MEDICAMENT
    public void insert_TABLE_NAME_MEDICAMENT(String NOMMEDICAMENT, String NBUTILISATION,String HEUREUTILISATION) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.NOMMEDICAMENT, NOMMEDICAMENT);
        contentValue.put(BD_Dossier_Medical.NBUTILISATION, NBUTILISATION);
        contentValue.put(BD_Dossier_Medical.HEUREUTILISATION, HEUREUTILISATION);
        database.insert(BD_Dossier_Medical.TABLE_NAME_MEDICAMENT, null, contentValue);
    }

}
