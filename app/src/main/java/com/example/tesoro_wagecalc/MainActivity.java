package com.example.tesoro_wagecalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText hourlyRate;
    private EditText hoursWorked;
    private Button btnCal;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hourlyRate= findViewById(R.id.hourlyRate);
        hoursWorked = findViewById(R.id.hoursWorked);
        btnCal = findViewById(R.id.btnCal);
        result = findViewById(R.id.result);
        btnCal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCal) {
            calculateWage();
        }
    }

    private void calculateWage() {
        String hourlyRateStr = hourlyRate.getText().toString().trim();
        String hoursWorkedStr = hoursWorked.getText().toString().trim();

        if (hourlyRateStr.isEmpty() || hoursWorkedStr.isEmpty()) {
            result.setText("Please enter the required details. Thank you!");
            return;
        }
        double hourlyRate = Double.parseDouble(hourlyRateStr);
        double hoursWorked = Double.parseDouble(hoursWorkedStr);
        double wage = hourlyRate * hoursWorked;
        result.setText("Result: $" + wage);
    }
}
