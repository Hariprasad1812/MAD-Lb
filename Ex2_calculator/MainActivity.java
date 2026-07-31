package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        tvResult = findViewById(R.id.tvResult);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate('+');

            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate('-');

            }
        });


        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate('*');

            }
        });


        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculate('/');

            }
        });

    }



    public void calculate(char operator) {


        String number1 = etNum1.getText().toString();
        String number2 = etNum2.getText().toString();


        if(number1.isEmpty() || number2.isEmpty()){

            tvResult.setText("Enter both numbers");

            return;
        }


        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);

        double result = 0;


        switch(operator){

            case '+':
                result = num1 + num2;
                break;


            case '-':
                result = num1 - num2;
                break;


            case '*':
                result = num1 * num2;
                break;


            case '/':

                if(num2 != 0)
                    result = num1 / num2;

                else{

                    tvResult.setText("Cannot divide by zero");
                    return;

                }

                break;

        }


        tvResult.setText("Result : " + result);

    }

}
