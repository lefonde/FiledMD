package com.lefonde.fieldmd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Four_Way extends AppCompatActivity {

    Button frontButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__way);

        frontButton = findViewById(R.id.button14);
        frontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Four_Way.this, FrontInjury.class);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.button15);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Four_Way.this, BackInjury.class);
                startActivity(intent);
            }
        });
    }
}
