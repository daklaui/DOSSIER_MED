package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.Data.Dossier_Medical;
import com.example.dell.DataBaseCode.DB_CODE;

public class Bienvenu extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    private DB_CODE dbManager;int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenu);
        dbManager= new DB_CODE(this);
        dbManager.open();
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        id= sharedpreferences.getInt("id",-1);
    }

    public void profile_menu(View view) {

        startActivity(new Intent(getApplicationContext(),Profile.class));
    }

    public void dossier_medical(View view) {
        Dossier_Medical med;
        try
        {med = dbManager.GetDossier_Med(id);}
        catch (Exception e){med=null;};
        if(med==null){startActivity(new Intent(getApplicationContext(),Dossier_Med.class));}
       else if(med!=null){startActivity(new Intent(getApplicationContext(),Detaille_Dossier_Med.class));}

    }

    public void etat_sante(View view) {
        startActivity(new Intent(getApplicationContext(),Etat_Sante.class));
    }

    public void analyse(View view) {
        startActivity(new Intent(getApplicationContext(),Liste_Des_Analyse.class));
    }

    public void churigie(View view) {
        startActivity(new Intent(getApplicationContext(),ListeDesChirugies.class));
    }

    public void medicament(View view) {
       // startActivity(new Intent(getApplicationContext(),Dossier_Med.class));
    }
}
