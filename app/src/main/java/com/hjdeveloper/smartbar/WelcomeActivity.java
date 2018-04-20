package com.hjdeveloper.smartbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    ImageView imgLogo;
    TextView nameAppWelcome;
            
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imgLogo = (ImageView) findViewById(R.id.imageView);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Si se hace un clik en en la imagen 
                showMenu();
            }
        });


        nameAppWelcome=(TextView)findViewById(R.id.nameAppWelcome);
        nameAppWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Si se hace un clik en en la imagen
                showMenu();
            }
        });
    }

    public void showMenu(){
        startActivity(new Intent(WelcomeActivity.this,MenuActivity.class));
    }


}


