package com.example.dell;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.DataBaseCode.DB_CODE;

import java.util.Calendar;

public class Inscription extends AppCompatActivity {
    private DB_CODE dbManager;
EditText date_naiss;
EditText nomp,prenom,Tel,Email,Mdp,Adresse;
CheckBox Homme;
    CheckBox Femme;
Button Enregistrer;

    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        date_naiss=(EditText)findViewById(R.id.date_naisse);
        nomp=(EditText)findViewById(R.id.Nom);
        prenom=(EditText)findViewById(R.id.Prenom);
        Tel=(EditText)findViewById(R.id.tele);
        Email=(EditText)findViewById(R.id.Email);
        Mdp=(EditText)findViewById(R.id.password);
        Adresse=(EditText)findViewById(R.id.Adresse);
        Homme=(CheckBox) findViewById(R.id.H);
        Femme=(CheckBox) findViewById(R.id.F);
        Enregistrer=(Button) findViewById(R.id.Save_Patient);
        dbManager= new DB_CODE(this);
        dbManager.open();
        date_naiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Inscription.this,
                        new DatePickerDialog.OnDateSetListener(){

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date_naiss.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        Enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nom=nomp.getText().toString();
                final String prenom_p=prenom.getText().toString();
                final String Tel_p=Tel.getText().toString();
                final String Email_p=Email.getText().toString();
                final String Adresse_p=Adresse.getText().toString();
                final String Mdp_p=Mdp.getText().toString();

                final String date_naissp=date_naiss.getText().toString();
                 String sexe="";
                if(Homme.isChecked()){sexe="H";}
               else if(Femme.isChecked()){sexe="F";}
             //   Toast.makeText(getApplicationContext(), date_naissp, Toast.LENGTH_SHORT).show();
              long insertRow=  dbManager.insert_patient(nom,prenom_p,sexe,Tel_p,Email_p,Mdp_p,Adresse_p,date_naissp);
Toast.makeText(getApplicationContext(),"votre profile a été bien enregistrer",Toast.LENGTH_LONG).show();
startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });

    }
}
