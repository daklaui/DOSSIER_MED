package com.example.dell;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dell.Data.Dossier_Medical;
import com.example.dell.DataBaseCode.DB_CODE;

public class Etat_Sante extends AppCompatActivity {
    private DB_CODE dbManager;
    TextView valeurIMC,messageIMC,ValeurTension,messageTesion,valeurglyc,messageGlyc;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etat__sante);
        valeurIMC=(TextView)findViewById(R.id.IMC);
        messageIMC=(TextView)findViewById(R.id.messgaeIMC);
        ValeurTension=(TextView)findViewById(R.id.Tesion);
        messageTesion=(TextView)findViewById(R.id.messgaeTension);
        valeurglyc=(TextView)findViewById(R.id.gly);
        messageGlyc=(TextView)findViewById(R.id.messgaeGlycémie);
        dbManager= new DB_CODE(this);
        dbManager.open();
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        int id= sharedpreferences.getInt("id",-1);
        Dossier_Medical med ;
        try {
            med=dbManager.GetDossier_Med_Calcul(id);
        }
        catch (Exception e){med=null;}

 if(med!=null)
 {
     /***Traitement IMC **/
     double poid=med.getPoids();
     double hauteur=med.getHauteur();
     double imc=poid/hauteur;
     String text="";
     if(imc< 18.5){text="Insuffisance pondérale (maigreur)";}
     else  if(imc> 18.5 && imc<25){text="Corpulence normale";}
     else  if(imc> 25 && imc<30){text="Surpoids";}
     else  if(imc> 30 && imc<35){text="Obésité modérée";}
     else  if(imc> 35 && imc<40){text="Obésité sévère";}
     else{text="Obésité morbide ou massive";}
     valeurIMC.setText(String.valueOf(imc));
     messageIMC.setText(text);
/**************************************************************************************/

/******* Traitement glyc **/
double glyc=med.getGlycemie();
     if(glyc==0.7){text="hypoglycémie";}
     else  if(glyc>0.7 && glyc<1.1){text="glycémie";}
     else  {text="hyperglycémie";}
     valeurglyc.setText(String.valueOf(glyc));
     messageGlyc.setText(text);

     /****************************************************************/


     /******* Traitement glyc **/
     double tens=med.getTensien();
     if(tens<10.8){text="hypotension artérielle ";}
     else  if(tens>10.8 && tens<15){text="tension artérielle normale";}
     else  {text="hypertension artérielle ";}
     ValeurTension.setText(String.valueOf(tens));
     messageTesion.setText(text);

     /****************************************************************/
 }
    }


}
