package com.example.b1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class B1 extends AppCompatActivity {

    EditText txtA, txtB;
    TextView txtvresult;
    Button btnPlus, btnSubtract, btnMulty, btnDivide, btnUcln, btnOut;

    private void initControl() {
        txtA = findViewById(R.id.A);
        txtB = findViewById(R.id.B);
        txtvresult = findViewById(R.id.rs);
        btnPlus = findViewById(R.id.btnPlus);
        btnSubtract = findViewById(R.id.btnsubtract);
        btnMulty = findViewById(R.id.btnmulty);
        btnDivide = findViewById(R.id.btndivide);
        btnUcln = findViewById(R.id.btucln);
        btnOut = findViewById(R.id.btnout);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double result = a + b;
                txtvresult.setText(String.valueOf(result));
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double result = a - b;
                txtvresult.setText(String.valueOf(result));
            }
        });

        btnMulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                double result = a * b;
                txtvresult.setText(String.valueOf(result));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(txtA.getText().toString());
                double b = Double.parseDouble(txtB.getText().toString());
                if (b != 0) {
                    double result = a / b;
                    txtvresult.setText(String.valueOf(result));
                } else {
                    txtvresult.setText("Cannot divide by zero");
                }
            }
        });

        btnUcln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(txtA.getText().toString());
                int b = Integer.parseInt(txtB.getText().toString());
                int result = ucln(a, b);
                txtvresult.setText(String.valueOf(result));
            }
        });

        btnOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b1);
        initControl();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
