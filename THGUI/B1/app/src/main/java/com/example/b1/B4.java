package com.example.b1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class B4 extends AppCompatActivity {


    EditText txtName,txtHeight, txtWeight,txtbmi,txtrs;
    Button btnTinh;

    public void initControl(){
        txtName = findViewById(R.id.txtname);
        txtHeight = findViewById(R.id.txtheight);
        txtWeight = findViewById(R.id.txtweight);
        txtbmi=findViewById(R.id.txtbmi);
        txtrs=findViewById(R.id.txtrs);
        btnTinh = findViewById(R.id.btnbmi);
    }
    public void btntinhBMI(View arg0){
        initControl();
        double H = Double.parseDouble(txtHeight.getText()+"");
        double W =Double.parseDouble(txtWeight.getText()+"");
        double BMI =W/Math.pow(H,2);
        String chandoan ="";
        if(BMI<18){
            chandoan="Bạn gầy!";

        }
        else if(BMI<24.9){
            chandoan="Bạn bình thường!";

        }
        else if(BMI<=29.9){
            chandoan="Bạn béo phì độ 1!";
        }
        else if(BMI<=34.9){
            chandoan="Bạn béo phì độ 2";
        }
        else {
            chandoan="Bạn béo phì độ 3!";
        }

        DecimalFormat dcf = new DecimalFormat("#.0");
        txtbmi.setText(dcf.format(BMI));
        txtrs.setText(chandoan);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_b4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}