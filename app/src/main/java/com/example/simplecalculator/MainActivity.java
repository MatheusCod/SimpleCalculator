package com.example.simplecalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String num1 = "";
    private String num2 = "";
    private String res = "";
    private String operation = "";
    private Boolean aux = false;
    private TextView results;

    private void addNumber(String num){
        if(!aux){
            if(num1.length()<9) {
                results.setText("");
                num1 += num;
                results.setText(num1);
            }
            else{
                results.setText(num1);
            }
        }
        else{
            if(num2.length()<9) {
                results.setText("");
                num2 += num;
                results.setText(num2);
            }
            else{
                results.setText(num2);
            }
        }
    }

    private void allCancel(){
        num1 = "";
        num2 = "";
        operation = "";
        results.setText("");
        aux = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        results = (TextView) findViewById(R.id.result_field);
        results.setText("");

        Button equals = findViewById(R.id.equals);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!num1.equals("") && !num2.equals("")) {
                    if (operation.equals("+")) {
                        res = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
                    } else if (operation.equals("-")) {
                        res = Integer.toString(Integer.parseInt(num1) - Integer.parseInt(num2));
                    } else if (operation.equals("*")) {
                        res = Integer.toString(Integer.parseInt(num1) * Integer.parseInt(num2));
                    } else if (operation.equals("/")) {
                        if (num2.equals("0")) {
                            results.setText("Math Error");
                            return;
                        } else {
                            res = Integer.toString(Integer.parseInt(num1) / Integer.parseInt(num2));
                        }
                    }
                    if(res.length()>9){
                        allCancel();
                        results.setText("TooLargeN");
                    }
                    else{
                        results.setText(res);
                    }
                    num1 = res;
                    num2 = "";
                    aux = false;
                }
            }
        });

        Button addiction = findViewById(R.id.addiction);
        addiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                operation = "+";
                aux = true;
            }
        });

        Button subtraction = findViewById(R.id.subtraction);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                operation = "-";
                aux = true;
            }
        });

        Button multiplication = findViewById(R.id.multiplication);
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                operation = "*";
                aux = true;
            }
        });
        Button division = findViewById(R.id.division);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                operation = "/";
                aux = true;
            }
        });

        Button all_cancel = findViewById(R.id.all_cancel);
        all_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                allCancel();
            }
        });

        Button zero = findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("0");
            }
        });

        Button one = findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("1");
            }
        });

        Button two = findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("2");
            }
        });

        Button three = findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("3");
            }
        });

        Button four = findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("4");
            }
        });

        Button five = findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("5");
            }
        });

        Button six = findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("6");
            }
        });

        Button seven = findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("7");
            }
        });

        Button eight = findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("8");
            }
        });

        Button nine = findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                addNumber("9");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
