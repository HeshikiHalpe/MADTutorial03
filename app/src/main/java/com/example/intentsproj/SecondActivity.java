package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText etxtNum1;
    EditText etxtNum2;

    String number1;
    String number2;

    int n1,n2;

    TextView displayCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //enable back button on action bar to navigate back to main activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etxtNum1 = findViewById(R.id.editTextNumber1);
        etxtNum2 = findViewById(R.id.editTextNumber2);

        displayCalc = findViewById(R.id.displayCalc);

        //get values passed by the main activity
        Intent intent = getIntent();

        number1 = intent.getStringExtra("n1");
        number2 = intent.getStringExtra("n2");

        //set the retrieved strings in the edit text views
        etxtNum1.setText(number1);
        etxtNum2.setText(number2);

        //creating arithmetic operations
        //set string values to integer values
        n1 = Integer.parseInt(number1);
        n2 = Integer.parseInt(number2);

    }

    public void add(View view) {
        displayCalc.setText(number1+ " + " +number2+ " = " +(n1+n2));
    }

    public void subtract(View view) {
        displayCalc.setText(number1+ " - " +number2+ " = " +(n1-n2));
    }

    public void multiply(View view) {
        displayCalc.setText(number1+ " x " +number2+ " = " +(n1*n2));
    }

    public void divide(View view) {
        displayCalc.setText(number1+ " / " +number2+ " = " +(n1/n2));
    }
}