package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private double firstNumber = 0;
    private String operator = "";
    private boolean isNewInput = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        String digit = button.getText().toString();

        if (isNewInput || display.getText().toString().equals("0")) {
            display.setText(digit);
        } else {
            display.append(digit);
        }
        isNewInput = false;
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();

        try {
            firstNumber = Double.parseDouble(display.getText().toString());
        } catch (NumberFormatException e) {
            firstNumber = 0;
        }

        isNewInput = true;
    }

    public void onEqualClick(View view) {
        double secondNumber;
        try {
            secondNumber = Double.parseDouble(display.getText().toString());
        } catch (NumberFormatException e) {
            display.setText("Error");
            return;
        }

        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    display.setText("Error");
                    return;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                display.setText("Error");
                return;
        }

        display.setText(String.valueOf(result));
        isNewInput = true;
    }

    public void onClearClick(View view) {
        display.setText("0");
        firstNumber = 0;
        operator = "";
        isNewInput = true;
    }
}


