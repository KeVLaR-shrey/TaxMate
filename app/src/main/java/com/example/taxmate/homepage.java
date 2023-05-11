package com.example.taxmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Button b= (Button) findViewById(R.id.button_reg);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), regno_page.class);
                startActivity(intent);
            }

        });

        Button c= (Button) findViewById(R.id.idBtnRegister);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(view.getContext(), dashboardnav.class);
                startActivity(intent);
            }

        });
    }
}
