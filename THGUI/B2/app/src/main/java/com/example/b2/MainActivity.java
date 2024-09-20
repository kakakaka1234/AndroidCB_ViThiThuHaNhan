package com.example.b2;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText txtF, txtC;
    Button btntoC, btntoF, btnClear;

    public void initControl() {
        txtC = findViewById(R.id.C);
        txtF = findViewById(R.id.F);
        btntoF = findViewById(R.id.toF);
        btntoC = findViewById(R.id.toC);
        btnClear = findViewById(R.id.clear);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        initControl();

        btntoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editF = txtF.getText().toString();
                if (!TextUtils.isEmpty(editF)) {
                    try {
                        double F = Double.parseDouble(editF);
                        double C = (F - 32) * 5 / 9;
                        txtC.setText(String.format("%.2f", C));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid Fahrenheit value", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a F value", Toast.LENGTH_LONG).show();
                }
            }
        });

        btntoF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editC = txtC.getText().toString();
                if (!TextUtils.isEmpty(editC)) {
                    try {
                        double C = Double.parseDouble(editC);
                        double F = (C * 9 / 5) + 32;
                        txtF.setText(String.format("%.2f", F));
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid Celsius value", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a C value", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                txtC.setText("");
                txtF.setText("");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
