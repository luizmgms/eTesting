package com.luiz.mg.etesting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.luiz.mg.etesting.adapter.AdapterTest;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);

        //CollapseToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapseToolbarId);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);

        ArrayList<String> listTests = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listTests.add("Teste "+i);
        }
        Log.d("list", listTests.toString());

        //ReclycerView
        RecyclerView recyclerView = findViewById(R.id.listViewId);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        //Adapter do RecyclerView
        AdapterTest adapter = new AdapterTest(listTests);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menuAboutId)
            Toast.makeText(getApplicationContext(), "Sobre!", Toast.LENGTH_SHORT).show();
        else if (id == R.id.menuLogoutId)
            logout();

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        SharedPreferences sharedPreferences =
                getSharedPreferences(getResources()
                        .getString(R.string.preferences), Context.MODE_PRIVATE);

        sharedPreferences.edit().remove(getResources().getString(R.string.logon)).apply();

        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}