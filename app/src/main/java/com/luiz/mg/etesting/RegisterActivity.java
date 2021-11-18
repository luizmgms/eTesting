package com.luiz.mg.etesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText login, pass1, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        login = findViewById(R.id.editTextLoginId);
        pass1 = findViewById(R.id.editTextPassId);
        pass2 = findViewById(R.id.editTextPassAgainId);

        Button register = findViewById(R.id.buttonRegisterId);
        register.setOnClickListener(view -> {
            //Validar campos
            if (validFields()) {
                //Tudo certo
                Toast.makeText(getApplicationContext(),
                        getResources().getString(R.string.register_sucess),
                        Toast.LENGTH_SHORT).show();
            }
        });

        TextView login = findViewById(R.id.textViewLoginId);
        login.setOnClickListener(view -> {
            onBackPressed();
            finish();
        });
    }

    private boolean validFields() {
        if (login.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.miss_login),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (pass1.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.miss_pass),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (!pass1.getText().toString().equals(pass2.getText().toString())) {
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.pass_dif),
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}