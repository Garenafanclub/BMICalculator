package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit_Weight , edit_HeightFT , edit_HeightIN;
        TextView txt_Result;
        Button btn_Cal;
        LinearLayout llMain;

        edit_Weight = findViewById(R.id.edit_Weight);  // it goes to particular path
        edit_HeightFT = findViewById(R.id.edit_HeightFT);
        edit_HeightIN = findViewById(R.id.edit_HeightIN);
        txt_Result = findViewById(R.id.txt_Result);
        btn_Cal = findViewById(R.id.btn_Cal);
        llMain = findViewById(R.id.llMain);

        btn_Cal.setOnClickListener(v -> {

                    int wt = Integer.parseInt(edit_Weight.getText().toString());
                    int ft = Integer.parseInt(edit_HeightFT.getText().toString());
                    int in = Integer.parseInt(edit_HeightIN.getText().toString());

                    int totalIn = ft * 12 + in;
                    double totalCm = totalIn * 2.53;
                    double totalM = totalCm/100;

                    double bmi = wt / (totalM * totalM);
                    if (bmi > 25) {
                        txt_Result.setText("You're OverWeight");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                    } else if (bmi < 18.5) {
                        txt_Result.setText("You're UnderWeight");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                    } else {
                        txt_Result.setText("You're Healthy");
                        llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                    }
        });   // Anonymous Class.  // lambda expression.
    }
}