package com.josebeap.bmi_calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView lblHeight = null;
    private TextView lblWeight = null;
    private TextView heightInput = null;
    private TextView weightInput = null;
    private Button btnCalculate = null;
    private Button btnInfo;


    private Calculator calculator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        initViews();
        initEvents();

    }

    public void initViews() {

        lblHeight = findViewById(R.id.lbl_height);
        lblWeight = findViewById(R.id.lbl_weight);
        btnCalculate = findViewById(R.id.btnCalculate);
        heightInput = findViewById(R.id.height_Input);
        weightInput = findViewById(R.id.weight_Input);
        btnInfo = findViewById(R.id.btnInfo);

    }

    public void initEvents() {

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int aux = 0;

                if (heightInput.getText().toString().equals("") || heightInput.getText().toString().equals("0")) {
                    aux = 1;

                } else {

                    double height = Double.parseDouble(heightInput.getText().toString());
                    calculator.setHeight(height);

                }
                if (weightInput.getText().toString().equals("")  || weightInput.getText().toString().equals("0")) {
                    aux = aux + 2;

                } else {

                    double weight = Double.parseDouble(weightInput.getText().toString());
                    calculator.setWeight(weight);

                }

                if (aux == 0) {
                    showBMI();
                } else {

                    showHeightWeightAlert(aux);
                }
                aux = 0;

            }
        });


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                showInfo();
            }
        });


    }

    public void showBMI() {

        DecimalFormat df =  new DecimalFormat("#.##");
        double BMI = Double.valueOf(df.format(calculator.calculateBMI()));


        StringBuilder text = new StringBuilder();

        text.append(getString(R.string.Your_BMI, String.valueOf(BMI)));


        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setMessage(text);
        alert.setPositiveButton("Thank you!", null);
        alert.show();
    }

    public void showHeightWeightAlert(int aux) {


        StringBuilder text = new StringBuilder();
        text.append(getString(R.string.boxEmpty));

        if (aux == 1) {
            text.append("\n");
            text.append(getString(R.string.height));
        } else if (aux == 2) {
            text.append("\n");
            text.append(getString(R.string.weight));
        } else {
            text.append("\n");
            text.append(getString(R.string.height));
            text.append("\n");
            text.append(getString(R.string.weight));

        }

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(text);
        alert.setPositiveButton("Thank you!", null);
        alert.show();

    }

    public void showInfo() {


        StringBuilder textInfo = new StringBuilder();

        textInfo.append(getString(R.string.information));
        textInfo.append(": ");
        textInfo.append("\n");

        textInfo.append(getString(R.string.low_weight));
        textInfo.append(": ");
        textInfo.append(getString(R.string.low_weight1));

        textInfo.append("\n");

        textInfo.append(getString(R.string.normal_weight));
        textInfo.append(": ");
        textInfo.append(getString(R.string.normal_weight2));

        textInfo.append("\n");

        textInfo.append(getString(R.string.overweight));
        textInfo.append(": ");
        textInfo.append(getString(R.string.overweight3));

        textInfo.append("\n");

        textInfo.append(getString(R.string.obesity));
        textInfo.append(": ");
        textInfo.append(getString(R.string.obesity4));

        AlertDialog.Builder alert = new AlertDialog.Builder(this);


        alert.setMessage(textInfo);
        alert.setPositiveButton("Thank you!", null);
        alert.show();

    }

}