package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ok;
    EditText etxtNum1;
    EditText etxtNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //click ok button to open the second activity
        ok = (Button) findViewById(R.id.okButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });

        //setting text field values
        etxtNum1 = findViewById(R.id.editTextNumber1);
        etxtNum2 = findViewById(R.id.editTextNumber2);
    }

    public void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("n1",etxtNum1.getText().toString());
        intent.putExtra("n2",etxtNum2.getText().toString());

        //toast message
        //Toast.makeText(this, "Opening Calculator..", Toast.LENGTH_SHORT).show();

        //custom toast
        //Creating the LayoutInflater instance
        LayoutInflater li = getLayoutInflater();
        //Getting the View object as defined in the customtoast.xml file
        View layout = li.inflate(R.layout.custom_toast, (ViewGroup)
                findViewById(R.id.custom_toast_layout));
        //Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layout);//setting the view of custom toast layout
        toast.show();

        startActivity(intent);
    }
}