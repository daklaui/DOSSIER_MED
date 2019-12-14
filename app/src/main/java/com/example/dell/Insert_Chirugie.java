package com.example.dell;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.dell.DataBaseCode.DB_CODE;

import java.util.Calendar;

public class Insert_Chirugie extends AppCompatActivity {
EditText Lib,date;
FloatingActionButton floatingActionButton;
    SharedPreferences sharedpreferences;
    DatePickerDialog datePickerDialog;
    private DB_CODE dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert__chirugie);

        Lib=(EditText)findViewById(R.id.Lib_chirugie);
        date=(EditText)findViewById(R.id.date_chirugie);
        floatingActionButton=findViewById(R.id.Ajouter_chirugie);
        sharedpreferences= getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedpreferences.edit();
        final  int id= sharedpreferences.getInt("id",-1);
        dbManager= new DB_CODE(this);
        dbManager.open();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String libelle=Lib.getText().toString();
                final String date_chirugie=date.getText().toString();

                long insertRow=  dbManager.insert_CHIRUGIE(libelle,date_chirugie,id);
                if(insertRow!=-1)
                {
                    startActivity(new Intent(getApplicationContext(),ListeDesChirugies.class));
                }
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(Insert_Chirugie.this,
                        new DatePickerDialog.OnDateSetListener(){

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

    }
}
