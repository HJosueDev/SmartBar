package com.hjdeveloper.smartbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button btnShowMyMixList;

    private Button btnShowAddMix;

    private Button btnShowPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        /*
        * Asignando los valores del Activity a los objetos
        */
        btnShowMyMixList=(Button)findViewById(R.id.btnMyMixList);

        btnShowAddMix=(Button)findViewById(R.id.btnAddMix);

        btnShowPreferences=(Button)findViewById(R.id.btnPreferences);

        /*
        * ====================================================
        * Asignando los eventos click a los objetos creados
        * ====================================================
        */

        btnShowMyMixList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyMixList();
            }
        });


        btnShowAddMix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddMix();
            }
        });


        btnShowPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPreferences();
            }
        });



    }




    public void showMyMixList(){
        startActivity(new Intent(MenuActivity.this,MyMixListActivity.class));
    }


    public void showAddMix(){
        startActivity(new Intent(MenuActivity.this,AddMixActivity.class));
    }


    public void showPreferences(){
        startActivity(new Intent(MenuActivity.this,PreferencesActivity.class));
    }

}
