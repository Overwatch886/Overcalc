package com.overcalc.app;

import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText etCalculation;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnFactorial, btnClear, btnSolve,
    btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
    TextView tvResult;
    CalculatorEngine engine;
    double firstNumber = 0;
    String currentOperation = "";
    boolean operationSelected = false;

    double result;
    double secondNumber;

    private void appendDigit(String digit){
        if (operationSelected){
            etCalculation.setText(digit);
            operationSelected = false;
        }
        else{
            etCalculation.append(digit);
        }
    }

    private void selectOperation(String operator){
        operationSelected = true;
        firstNumber = Double.parseDouble(etCalculation.getText().toString());
        currentOperation = operator;

        }

    private void clearScreen(){
        firstNumber = 0;
        currentOperation = "";
        operationSelected = false;
        etCalculation.setText("");
    }

    private void solve() {
        operationSelected = false;
        secondNumber = Double.parseDouble(etCalculation.getText().toString());
        switch (currentOperation) {
            case "+":
                result = engine.add(firstNumber, secondNumber);
                tvResult.setText(String.valueOf(result));
                break;
            case "-":
                result = engine.subtract(firstNumber, secondNumber);
                tvResult.setText(String.valueOf(result));
                break;
            case "/":
                try {
                    result = engine.divide(firstNumber, secondNumber);
                    if (Double.isNaN(result)) {
                        tvResult.setText("Division by zero is undefined!");
                    }
                    else {
                        tvResult.setText(String.valueOf(result));
                    }
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
                break;
            case "*":
                result = engine.multiply(firstNumber, secondNumber);
                tvResult.setText(String.valueOf(result));
                break;
            case "!":
                // Just remembered the layout wouldn't allow us input negatives in the first place
                try {
                    result = engine.factorial((int) firstNumber);
                    tvResult.setText(String.valueOf(result));
                }
                catch (NumberFormatException e){
                    tvResult.setText("Enter Valid Numbers!");
                }
                catch (IllegalArgumentException e){
                    tvResult.setText("Factorial of a Negative Number is Infinity");
                }
        }

        etCalculation.setText(firstNumber + " " + currentOperation + " " + secondNumber +" ="  );
        firstNumber = 0;
        currentOperation = "";
        secondNumber = 0;
        operationSelected = true;
        //TODO:Calculator needs to be relative more than just two inputs. If I give more than one input, it only works on the last two.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        engine = new CalculatorEngine();
        etCalculation = findViewById(R.id.etCalculation);

        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);

        btnAdd = findViewById(R.id.btnAdd);
        btnDivide = findViewById(R.id.btnDivide);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnFactorial = findViewById(R.id.btnFactorial);
        btnClear = findViewById(R.id.btnClear);
        btnSolve = findViewById(R.id.btnSolve);
        tvResult = findViewById(R.id.tvResult);



        btnNum0.setOnClickListener(v -> appendDigit("0"));
        btnNum1.setOnClickListener(v -> appendDigit("1"));
        btnNum2.setOnClickListener(v -> appendDigit("2"));
        btnNum3.setOnClickListener(v -> appendDigit("3"));
        btnNum4.setOnClickListener(v -> appendDigit("4"));
        btnNum5.setOnClickListener(v -> appendDigit("5"));
        btnNum6.setOnClickListener(v -> appendDigit("6"));
        btnNum7.setOnClickListener(v -> appendDigit("7"));
        btnNum8.setOnClickListener(v -> appendDigit("8"));
        btnNum9.setOnClickListener(v -> appendDigit("9"));

        btnAdd.setOnClickListener(v -> selectOperation("+"));
        btnSubtract.setOnClickListener(v -> selectOperation("-"));
        btnMultiply.setOnClickListener(v -> selectOperation("*"));
        btnDivide.setOnClickListener(v -> selectOperation("/"));
        btnFactorial.setOnClickListener(v -> selectOperation("!"));


        btnClear.setOnClickListener(v -> clearScreen());
        btnSolve.setOnClickListener(v -> solve());

}
}