package com.overcalc.app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText etNum1, etNum2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnFactorial;
    TextView tvResult;
    CalculatorEngine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        engine = new CalculatorEngine();
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnFactorial = (Button) findViewById(R.id.btnFactorial);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    double num1 = Double.parseDouble(etNum1.getText().toString());
                    double num2 = Double.parseDouble(etNum2.getText().toString());
                    double result = engine.add(num1, num2);
                    tvResult.setText(String.valueOf(result));
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    double num1 = Double.parseDouble(etNum1.getText().toString());
                    double num2 = Double.parseDouble(etNum2.getText().toString());
                    double result = engine.subtract(num1, num2);
                    tvResult.setText(String.valueOf(result));
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    double num1 = Double.parseDouble(etNum1.getText().toString());
                    double num2 = Double.parseDouble(etNum2.getText().toString());
                    double result = engine.multiply(num1, num2);
                    tvResult.setText(String.valueOf(result));
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    double num1 = Double.parseDouble(etNum1.getText().toString());
                    double num2 = Double.parseDouble(etNum2.getText().toString());
                    double result = engine.divide(num1, num2);
                    if (Double.isNaN(result)){
                        tvResult.setText("You can't divide by zero");
                    }
                    else{
                        tvResult.setText(String.valueOf(result));
                    }
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
            }
        });
        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    int num1 = Integer.parseInt(etNum1.getText().toString());
                    //if (num1<0)
                    long result = engine.factorial(num1);
                    tvResult.setText(String.valueOf(result));
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
                catch (IllegalArgumentException e){
                    tvResult.setText(e.getMessage());
                }
            }
        });

    }
}