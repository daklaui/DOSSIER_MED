package com.example.dell.DataBaseCode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.dell.Data.Analyse;
import com.example.dell.Data.Chirugie;
import com.example.dell.Data.Dossier_Medical;
import com.example.dell.Data.Patient;
import com.example.dell.Dossier_Med;

import java.util.ArrayList;
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
    public long insert_patient(String nom_p, String prenom_p, String sexe_p, String tel, String email_p, String mdp, String adr, String date_nai) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.NUMERO, tel);
        contentValue.put(BD_Dossier_Medical.PASSWORD, mdp);
        contentValue.put(BD_Dossier_Medical.EMAIL, email_p);
        contentValue.put(BD_Dossier_Medical.DATENAIS, date_nai);
        contentValue.put(BD_Dossier_Medical.NOM, nom_p);
        contentValue.put(BD_Dossier_Medical.PRENOM, prenom_p);
        contentValue.put(BD_Dossier_Medical.SEXE, sexe_p);
        contentValue.put(BD_Dossier_Medical.ADRESSE, adr);
      return (  database.insert(BD_Dossier_Medical.TABLE_NAME_PATIENT, null, contentValue));
    }

    public Patient fetch_patient(int id) {
       // String[] columns = new String[] { BD_Dossier_Medical.NUMERO, BD_Dossier_Medical.PASSWORD, BD_Dossier_Medical.EMAIL,BD_Dossier_Medical.DATENAIS,BD_Dossier_Medical.NOM,BD_Dossier_Medical.PRENOM,BD_Dossier_Medical.ADRESSE };
      Patient p =null;
        Cursor cursor = database.rawQuery("select "+BD_Dossier_Medical.NOM+","+BD_Dossier_Medical.PRENOM+","+BD_Dossier_Medical.DATENAIS+","+BD_Dossier_Medical.EMAIL+","+BD_Dossier_Medical.SEXE+","+BD_Dossier_Medical.ADRESSE+","+BD_Dossier_Medical.NUMERO+" from "+dbHelper.TABLE_NAME_PATIENT+" where "+BD_Dossier_Medical._ID+" = "+id,null);
        if (cursor != null) {
            cursor.moveToFirst();
            p=new Patient(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getInt(5));

        }
        return p;
    }


    public Patient Connecter(String email,String pass) {
        Patient p=null;
        // String[] columns = new String[] { BD_Dossier_Medical.NUMERO, BD_Dossier_Medical.PASSWORD, BD_Dossier_Medical.EMAIL,BD_Dossier_Medical.DATENAIS,BD_Dossier_Medical.NOM,BD_Dossier_Medical.PRENOM,BD_Dossier_Medical.ADRESSE };
        Cursor cursor = database.rawQuery("select "+BD_Dossier_Medical._ID+","+BD_Dossier_Medical.EMAIL+","+BD_Dossier_Medical.NOM +","+BD_Dossier_Medical.PRENOM+","+BD_Dossier_Medical.PASSWORD +" from "+dbHelper.TABLE_NAME_PATIENT+" where "+BD_Dossier_Medical.EMAIL+" = '"+email+"' and "+BD_Dossier_Medical.PASSWORD+" = '"+pass+"'",null);
        if (cursor != null) {
            cursor.moveToFirst();
            p = new Patient(cursor.getInt(0),cursor.getString(2),cursor.getString(3),cursor.getString(1),cursor.getString(4));
        }
        return p;
    }



    public Dossier_Medical GetDossier_Med(int id) {
        Dossier_Medical p=null;
        // String[] columns = new String[] { BD_Dossier_Medical.NUMERO, BD_Dossier_Medical.PASSWORD, BD_Dossier_Medical.EMAIL,BD_Dossier_Medical.DATENAIS,BD_Dossier_Medical.NOM,BD_Dossier_Medical.PRENOM,BD_Dossier_Medical.ADRESSE };
        Cursor cursor = database.rawQuery("select "+BD_Dossier_Medical._ID+","+BD_Dossier_Medical.POIDS+","+BD_Dossier_Medical.HAUTEUR +","+BD_Dossier_Medical.TYPESANGUIN+","+BD_Dossier_Medical.ALLERGIE +","+BD_Dossier_Medical.MALADIECHRONIQUE +","+BD_Dossier_Medical.GLYCEMIE +","+BD_Dossier_Medical.TENSIEN +" from "+dbHelper.TABLE_NAME_DOSSIER_MEDICAL+" where "+BD_Dossier_Medical.ID_PATIENT+" = "+id,null);
        if (cursor != null) {
            cursor.moveToFirst();
            p = new Dossier_Medical(cursor.getInt(0),cursor.getDouble(1),cursor.getDouble(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getDouble(6),cursor.getDouble(7));
        }
        return p;
    }

    public Dossier_Medical GetDossier_Med_Calcul(int id) {
        Dossier_Medical p=null;
        // String[] columns = new String[] { BD_Dossier_Medical.NUMERO, BD_Dossier_Medical.PASSWORD, BD_Dossier_Medical.EMAIL,BD_Dossier_Medical.DATENAIS,BD_Dossier_Medical.NOM,BD_Dossier_Medical.PRENOM,BD_Dossier_Medical.ADRESSE };
        Cursor cursor = database.rawQuery("select "+BD_Dossier_Medical.POIDS+","+BD_Dossier_Medical.HAUTEUR +","+BD_Dossier_Medical.GLYCEMIE +","+BD_Dossier_Medical.TENSIEN +" from "+dbHelper.TABLE_NAME_DOSSIER_MEDICAL+" where "+BD_Dossier_Medical.ID_PATIENT+" = "+id,null);
        if (cursor != null) {
            cursor.moveToFirst();
            p = new Dossier_Medical(cursor.getDouble(0),cursor.getDouble(1),cursor.getDouble(2),cursor.getDouble(3));
        }
        return p;
    }

    public int updateDossierMedical(int id,String poids, String hauteur, String type_sanguin, String allergie, String maladie_chronique, String glycemie, String tensien) {
        //SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.POIDS, poids);
        contentValue.put(BD_Dossier_Medical.HAUTEUR, hauteur);
        contentValue.put(BD_Dossier_Medical.TYPESANGUIN, type_sanguin);
        contentValue.put(BD_Dossier_Medical.ALLERGIE, allergie);
        contentValue.put(BD_Dossier_Medical.MALADIECHRONIQUE, maladie_chronique);
        contentValue.put(BD_Dossier_Medical.GLYCEMIE, glycemie);
        contentValue.put(BD_Dossier_Medical.TENSIEN, tensien);
        // updating row
        return database.update(BD_Dossier_Medical.TABLE_NAME_DOSSIER_MEDICAL, contentValue, BD_Dossier_Medical._ID + " = "+id,null);
    }


    // insert analyse
    public long insert_analyse(String libelle, String date_analyes, String resultat,int id) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.LIBELLEANALYSE, libelle);
        contentValue.put(BD_Dossier_Medical.DATEANALYSE, date_analyes);
        contentValue.put(BD_Dossier_Medical.ID_PATIENT, id);
        contentValue.put(BD_Dossier_Medical.RESULTATANALYSE, resultat);
        return (    database.insert(BD_Dossier_Medical.TABLE_NAME_ANALYSE, null, contentValue));
    }


    // insert CHIRUGIE
    public long insert_CHIRUGIE(String discription, String date_CHIRUGIE,int id) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.DISCRIPTIONCHIRUGIE, discription);
        contentValue.put(BD_Dossier_Medical.ID_PATIENT, id);
        contentValue.put(BD_Dossier_Medical.DATECHIRUGIE, date_CHIRUGIE);
     return (   database.insert(BD_Dossier_Medical.TABLE_NAME_CHIRUGIE, null, contentValue));
    }

    // insert TABLE_NAME_MEDICAMENT
    public void insert_TABLE_NAME_MEDICAMENT(String NOMMEDICAMENT, String NBUTILISATION,String HEUREUTILISATION) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.NOMMEDICAMENT, NOMMEDICAMENT);
        contentValue.put(BD_Dossier_Medical.NBUTILISATION, NBUTILISATION);
        contentValue.put(BD_Dossier_Medical.HEUREUTILISATION, HEUREUTILISATION);
        database.insert(BD_Dossier_Medical.TABLE_NAME_MEDICAMENT, null, contentValue);
    }


    // insert DOSSIER_MEDICAL
    public long insert_DOSSIER_MEDICAL(String poids, String hauteur, String type_sanguin, String allergie, String maladie_chronique, String glycemie, String tensien,int id_patient) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.POIDS, poids);
        contentValue.put(BD_Dossier_Medical.HAUTEUR, hauteur);
        contentValue.put(BD_Dossier_Medical.TYPESANGUIN, type_sanguin);
        contentValue.put(BD_Dossier_Medical.ALLERGIE, allergie);
        contentValue.put(BD_Dossier_Medical.MALADIECHRONIQUE, maladie_chronique);
        contentValue.put(BD_Dossier_Medical.GLYCEMIE, glycemie);
        contentValue.put(BD_Dossier_Medical.ID_PATIENT, id_patient);
        contentValue.put(BD_Dossier_Medical.TENSIEN, tensien);

      return (  database.insert(BD_Dossier_Medical.TABLE_NAME_DOSSIER_MEDICAL, null, contentValue));
    }

    // insert TABLE_NAME_ANALYSE
    public void insert_TABLE_NAME_ANALYSE(String libelleAnalyse, String date_analyse, String résultatAnalyse) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BD_Dossier_Medical.LIBELLEANALYSE, libelleAnalyse);
        contentValue.put(BD_Dossier_Medical.DATEANALYSE, date_analyse);
        contentValue.put(BD_Dossier_Medical.RESULTATANALYSE, résultatAnalyse);
        database.insert(BD_Dossier_Medical.TABLE_NAME_ANALYSE, null, contentValue);
    }


    public ArrayList<Analyse> getAllAnalyses(int id) {
        ArrayList<Analyse> Analyse_in = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+BD_Dossier_Medical.TABLE_NAME_ANALYSE+" where "+BD_Dossier_Medical.ID_PATIENT+" = "+id,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Analyse nt = new Analyse(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            Analyse_in.add(nt);
            //  Log.i(MainActivity.ACTIVITY_SERVICE, cursor.getString(1));
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return Analyse_in;
    }


    public ArrayList<Chirugie> getAllOp(int id) {
        ArrayList<Chirugie> chirugies = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM "+BD_Dossier_Medical.TABLE_NAME_CHIRUGIE+" where "+BD_Dossier_Medical.ID_PATIENT+" = "+id,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Chirugie nt = new Chirugie(cursor.getInt(0),cursor.getString(1),cursor.getString(3));
            chirugies.add(nt);
            //  Log.i(MainActivity.ACTIVITY_SERVICE, cursor.getString(1));
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return chirugies;
    }

}
