package com.hjdeveloper.smartbar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hjdeveloper.smartbar.ClassUtilitary.Datos;

import java.util.ArrayList;

public class MyMixListActivity extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapterListMix;

    private ListView listViewMix;
    private ArrayList arrayList;
    Datos datos=new Datos();

    String positionItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayList= new ArrayList(datos.getArrayListKey());
        setContentView(R.layout.activity_my_mix_list);

        arrayAdapterListMix=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listViewMix=(ListView)findViewById(R.id.listViewMix);
        listViewMix.setAdapter(arrayAdapterListMix);



        listViewMix.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionItem=(String) parent.getItemAtPosition(position);

                Intent intent = new Intent(MyMixListActivity.this, DetailsMixActivity.class);
                intent.putExtra("parametro", positionItem);
                startActivity(intent);
            }
        });


    }


}