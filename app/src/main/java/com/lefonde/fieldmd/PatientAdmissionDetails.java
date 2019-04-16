package com.lefonde.fieldmd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class PatientAdmissionDetails extends AppCompatActivity {

    Button next;
    EditText editTimeOfInjury;
    EditText editTimeOfAdmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_admission_details);

        editTimeOfInjury = findViewById(R.id.editTimeOfInjury);
        editTimeOfAdmission = findViewById(R.id.editTimeOfAdmission);
        next = findViewById(R.id.button_load_patient_admission);

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientAdmissionDetails.this, Four_Way.class);
                intent.putExtra("editTimeOfInjury", editTimeOfInjury.getText().toString());
                intent.putExtra("editTimeOfAdmission", editTimeOfAdmission.getText().toString());
                startActivity(intent);
            }
        });

    }
}
