package com.example.dell;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.Data.Patient;
import com.example.dell.DataBaseCode.DB_CODE;

public class MainActivity extends AppCompatActivity {
    EditText login,password;
    TextView inscription_patient;
    Button btnconnect;
    private SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "prefs";
    private DB_CODE dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        login=(EditText)findViewById(R.id.Login_User);
        password=(EditText)findViewById(R.id.MDP_user);
        btnconnect=(Button)findViewById(R.id.ConnectBtn);
        inscription_patient=(TextView)findViewById(R.id.Inscr);
        dbManager= new DB_CODE(this);
        dbManager.open();

        btnconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFields();
            }
        });


    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private void checkFields() {
        String email = login.getText().toString();
        String pass = password.getText().toString();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Merci d'entrer votre email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Merci d'entrer un email valide", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pass) || pass.length() < 6) {
            Toast.makeText(this, "Votre mot de passe doit contenir plus que 6 caractères", Toast.LENGTH_SHORT).show();
            return;
        }
        connect(email, pass);
    }

    private void connect(String email, String pass) {
        Patient p;
        try{
            p=dbManager.Connecter(email,pass);
        }
        catch (Exception e){p=null;}


         if(p!=null)
         {
             SharedPreferences.Editor editor = sharedpreferences.edit();
             editor.putString("login", p.getNom()+" "+p.getPrenom());
             editor.putInt("id", p.getId());
             editor.commit();

             Intent in = new Intent(getApplicationContext(),Bienvenu.class);
             startActivity(in);
         }

         else
         {

             Toast.makeText(this, "merci de verifier votre login ou mot de passe", Toast.LENGTH_SHORT).show();
         }
    }

    public void ActivityInscript(View view) {
        startActivity(new Intent(getApplicationContext(),Inscription.class));
    }
}
