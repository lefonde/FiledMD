package com.lefonde.fieldmd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Monitor4 extends AppCompatActivity {

    DatabaseHelper myDb;
    LinearLayout monitorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDb = new DatabaseHelper(this);
        monitorList = this.findViewById(R.id.monitor_list);

        //if previous activity returned data -> insert
        if (getIntent().hasExtra("editTimeOfAdmission")) {
            String editTimeOfInjury = getIntent().getExtras().getString("editTimeOfAdmission");
            String editTimeOfAdmission = getIntent().getExtras().getString("editTimeOfAdmission");
            String editID = getIntent().getExtras().getString("editID");
            String editFirstName = getIntent().getExtras().getString("editFirstName");
            String editLastName = getIntent().getExtras().getString("editLastName");
            String editAge = getIntent().getExtras().getString("editAge");

            myDb.insertData(editID,
                    editFirstName,
                    editLastName,
                    editAge,
                    editTimeOfInjury,
                    editTimeOfAdmission);

            LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            TextView tv = new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText("test");
            this.monitorList.addView(tv);

        }

        /*LinearLayout myRoot = findViewById(R.id.monitor_list);
        LinearLayout a = new LinearLayout(this);
        a.setOrientation(LinearLayout.HORIZONTAL);

        myRoot.addView(a);*/

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Monitor4.this, PatientAdmission.class);
                startActivity(intent);
            }
        });

    }
}
