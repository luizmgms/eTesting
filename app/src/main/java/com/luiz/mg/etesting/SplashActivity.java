package com.luiz.mg.etesting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        //Verificar se está logado
        handler.postDelayed(this::verifyLogon, 2000);
    }

    private void verifyLogon(){
       SharedPreferences sharedPreferences =
               getSharedPreferences(getResources()
                       .getString(R.string.preferences), Context.MODE_PRIVATE);

       String logon = sharedPreferences
               .getString(getResources().getString(R.string.logon), "");

       Intent intent;

       if (logon.equals("")) {
           //Não está logado
           intent = new Intent(SplashActivity.this, LoginActivity.class);
       } else {
           //Está logado
           intent = new Intent(SplashActivity.this, TestsActivity.class);
       }

       //Abrir Activity
        openActivity(intent);

    }

    private void openActivity (Intent intent) {
        startActivity(intent);
        finish();
    }
}

