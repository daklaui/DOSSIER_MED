package com.example.dell.DataBaseCode;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BD_Dossier_Medical extends SQLiteOpenHelper {

    //Les Tables bd
    public static final String TABLE_NAME_PATIENT = "PATIENT";
    public static final String TABLE_NAME_ANALYSE = "ANALYSE";
    public static final String TABLE_NAME_CHIRUGIE = "CHIRUGIE";
    public static final String TABLE_NAME_DOSSIER_MEDICAL = "DOSSIER_MEDICAL";
    public static final String TABLE_NAME_MEDICAMENT = "MEDICAMENT";

    //  Table TABLE_NAME_PATIENT columns
       public static final String _ID = "id";
       public static final String AGE = "age";
       public static final String NUMERO = "numero";
       public static final String CONTACT_URGENCE = "contact_urgence";
       public static final String NOM = "nom";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
       public static final String PRENOM = "prenom";
       public static final String SEXE = "sexe";
       public static final String ADRESSE = "adresse";
    public static final String DATENAIS = "date_naissence";
       //public static final String _ID_PATIENT = "id_patient";
    //  Table TABLE_NAME_ANALYSE columns
    public static final String LIBELLEANALYSE = "libelleAnalyse";
    public static final String DATEANALYSE = "date_analyse";
    public static final String RESULTATANALYSE = "résultatAnalyse";

    //  Table TABLE_NAME_CHIRUGIE columns
    public static final String DISCRIPTIONCHIRUGIE = "discriptionChirugie";
    public static final String DATECHIRUGIE = "dateChirugie";

    //  Table TABLE_NAME_MEDICAMENT columns
    public static final String NOMMEDICAMENT = "nomMédicament";
    public static final String NBUTILISATION = "nbUtilisation";
    public static final String HEUREUTILISATION = "heureUtilisation";

    //  Table TABLE_NAME_DOSSIER_MEDICAL columns
    public static final String POIDS = "poids";
    public static final String HAUTEUR = "hauteur";
    public static final String TYPESANGUIN = "type_sanguin";
    public static final String ALLERGIE = "allergie";
    public static final String MALADIECHRONIQUE = "maladie_chronique";
    public static final String GLYCEMIE = "glycemie";
    public static final String TENSIEN = "tensien";

    // Database Information
    static final String DB_NAME = "DOSSIERMEDICAL.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query TABLE_NAME_PATIENT
    private static final String CREATE_TABLE_TABLE_NAME_PATIENT= "create table " + TABLE_NAME_PATIENT + "("
                                                               + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                               + AGE + " INTEGER, "
                                                               + NUMERO + " INTEGER,"
            + PASSWORD + " TEXT,"
            + EMAIL + " TEXT,"
            + DATENAIS + " TEXT,"

                                                               + CONTACT_URGENCE + " INTEGER,"
                                                               + NOM+"TEXT,"
                                                               + PRENOM+"TEXT,"
                                                               + SEXE+"TEXT,"
                                                               + ADRESSE+"TEXT);";

    // Creating table query TABLE_NAME_ANALYSE
    private static final String CREATE_TABLE_TABLE_NAME_ANALYSE = "create table " + TABLE_NAME_ANALYSE + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + LIBELLEANALYSE + " TEXT, "
            + DATEANALYSE + " TEXT,"
            + RESULTATANALYSE + " TEXT);";

    // Creating table query TABLE_NAME_CHIRUGIE
    private static final String CREATE_TABLE_TABLE_NAME_CHIRUGIE = "create table " + TABLE_NAME_CHIRUGIE + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DISCRIPTIONCHIRUGIE + " TEXT, "
            + DATECHIRUGIE + " TEXT);";

    // Creating table query TABLE_NAME_MEDICAMENT
    private static final String CREATE_TABLE_TABLE_NAME_MEDICAMENT = "create table " + TABLE_NAME_MEDICAMENT + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOMMEDICAMENT + " TEXT, "
            + NBUTILISATION + " INTEGER,"
            + HEUREUTILISATION+"NUMERIC" + ");";



    // Creating table query TABLE_NAME_DOSSIER_MEDICAL
    private static final String TCREATE_TABLE_TABLE_NAME_DOSSIER_MEDICAL= "create table " + TABLE_NAME_DOSSIER_MEDICAL + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + POIDS + " REAL, "
            + HAUTEUR + " REAL,"
            + TYPESANGUIN + " TEXT,"
            + ALLERGIE+"TEXT,"
            + MALADIECHRONIQUE+"TEXT,"
            + GLYCEMIE+"REAL,"
            + TENSIEN+"REAL);";


    public BD_Dossier_Medical(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TABLE_NAME_PATIENT);
        db.execSQL(CREATE_TABLE_TABLE_NAME_ANALYSE);
        db.execSQL(CREATE_TABLE_TABLE_NAME_CHIRUGIE);
        db.execSQL(CREATE_TABLE_TABLE_NAME_MEDICAMENT);
        db.execSQL(TCREATE_TABLE_TABLE_NAME_DOSSIER_MEDICAL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PATIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ANALYSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CHIRUGIE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DOSSIER_MEDICAL);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MEDICAMENT);
        onCreate(db);
    }
}
