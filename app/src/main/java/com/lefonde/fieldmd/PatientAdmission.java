package com.lefonde.fieldmd;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class PatientAdmission extends AppCompatActivity {

    Button next;
    EditText editID;
    EditText editFirstName;
    EditText editLastName;
    EditText editAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_admission);

        editID = findViewById(R.id.editID);
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editAge = findViewById(R.id.editAge);
        next = findViewById(R.id.button_load_patient);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAdmission.this, PatientAdmissionDetails.class);
                intent.putExtra("editID", editID.getText().toString());
                intent.putExtra("editFirstName", editFirstName.getText().toString());
                intent.putExtra("editLastName", editLastName.getText().toString());
                intent.putExtra("editAge", editAge.getText().toString());
                startActivity(intent);
            }
        });

    }

}
