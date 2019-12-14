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
       public static final String NUMERO = "Numero_patient";
       public static final String NOM = "Nom_patient";
    public static final String EMAIL = "Email_patient";
    public static final String PASSWORD = "Password_patient";
       public static final String PRENOM = "Prenom_patient";
       public static final String SEXE = "Sexe_patient";
       public static final String ADRESSE = "Adresse_patient";
    public static final String DATENAIS = "Date_naissence_patient";
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
    public static final String ID_PATIENT = "id_patient";

    // Database Information
    static final String DB_NAME = "DOSSIERMEDICAL5.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query TABLE_NAME_PATIENT
    private static final String CREATE_TABLE_TABLE_NAME_PATIENT= "create table " + TABLE_NAME_PATIENT + "("
                                                                 + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                                 + NUMERO + " TEXT,"
                                                                 + PASSWORD + " TEXT,"
                                                                 + EMAIL + " TEXT,"
                                                                 + DATENAIS + " TEXT,"
                                                                 + NOM+" TEXT,"
                                                                 + PRENOM+" TEXT,"
                                                                 + SEXE+" TEXT,"
                                                                 + ADRESSE+" TEXT"+")";

    // Creating table query TABLE_NAME_ANALYSE
    private static final String CREATE_TABLE_TABLE_NAME_ANALYSE = "create table " + TABLE_NAME_ANALYSE + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + LIBELLEANALYSE + " TEXT, "
            + DATEANALYSE + " TEXT,"
            + ID_PATIENT+" INTEGER,"
            + RESULTATANALYSE + " TEXT);";

    // Creating table query TABLE_NAME_CHIRUGIE
    private static final String CREATE_TABLE_TABLE_NAME_CHIRUGIE = "create table " + TABLE_NAME_CHIRUGIE + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DISCRIPTIONCHIRUGIE + " TEXT, "
            + ID_PATIENT+" INTEGER,"
            + DATECHIRUGIE + " TEXT);";

    // Creating table query TABLE_NAME_MEDICAMENT
    private static final String CREATE_TABLE_TABLE_NAME_MEDICAMENT = "create table " + TABLE_NAME_MEDICAMENT + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOMMEDICAMENT + " TEXT, "
            + NBUTILISATION + " INTEGER,"
            + ID_PATIENT+" INTEGER,"
            + HEUREUTILISATION+"NUMERIC" + ");";



    // Creating table query TABLE_NAME_DOSSIER_MEDICAL
    private static final String TCREATE_TABLE_TABLE_NAME_DOSSIER_MEDICAL= "create table " + TABLE_NAME_DOSSIER_MEDICAL + "("
            + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + POIDS + " TEXT, "
            + HAUTEUR + " TEXT,"
            + TYPESANGUIN + " TEXT,"
            + ALLERGIE+" TEXT,"
            + MALADIECHRONIQUE+" TEXT,"
            + GLYCEMIE+" TEXT,"
            + ID_PATIENT+" INTEGER,"
            + TENSIEN+" TEXT);";


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
