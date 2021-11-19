package com.luiz.mg.etesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText login, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.editTextLoginId);
        pass = findViewById(R.id.editTextPassId);

        Button btnIn = findViewById(R.id.buttonInId);

        btnIn.setOnClickListener(view -> {

            //Valida campos
            if(validFields()) {
                //Tudo certo
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.login_success),
                        Toast.LENGTH_SHORT).show();

                SharedPreferences preferences =
                        getSharedPreferences(getResources()
                                .getString(R.string.preferences), Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(getResources().getString(R.string.logon), login.getText().toString());
                editor.apply();

                savePreferences();

                Intent i = new Intent(LoginActivity.this, TestsActivity.class);
                startActivity(i);
                finish();
            }

        });

        TextView register = findViewById(R.id.textViewCadId);
        register.setOnClickListener(view -> {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        });
    }
    private boolean validFields() {
        if (login.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.miss_login),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.miss_pass),
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void savePreferences() {

    }
}