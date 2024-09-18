package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Integer so1 =0;
    Integer so2 =0;
    Character dau = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final TextView txtkq = (TextView)findViewById(R.id.kq);
        Button So0 = (Button)findViewById(R.id.so0);So0.setOnClickListener(new View.OnClickListener(){@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if(dau==null){so1 = Integer.parseInt(txtkq.getText().toString());} else{so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So1 = (Button)findViewById(R.id.so1);So1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So2 = (Button)findViewById(R.id.so2);So2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So3 = (Button)findViewById(R.id.so3);So3.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So4 = (Button)findViewById(R.id.so4);So4.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So5 = (Button)findViewById(R.id.so5);So5.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So6 = (Button)findViewById(R.id.so6);So6.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So7 = (Button)findViewById(R.id.so7);So7.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So8 = (Button)findViewById(R.id.so8);So8.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});
        Button So9 = (Button)findViewById(R.id.so9);So9.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {txtkq.setText(txtkq.getText().toString());if (dau == null) {so1 = Integer.parseInt(txtkq.getText().toString());} else {so2 = Integer.parseInt(txtkq.getText().toString());}}});

        Button Cong = (Button)findViewById(R.id.cong);
        Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dau = '+';
                txtkq.setText("");
            }
        });
        Button Tru = (Button)findViewById(R.id.tru);
        Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dau = '-';
                txtkq.setText("");
            }
        });
        Button Nhan = (Button)findViewById(R.id.nhan);
        Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dau = '*';
                txtkq.setText("");
            }
        });
        Button Chia = (Button)findViewById(R.id.chia);
        Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dau = '/';
                txtkq.setText("");
            }
        });

        Button Bang = (Button)findViewById(R.id.bang);
        Bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dau==null){
                    Integer KQ = 0;
                    switch (dau){
                        case '+': KQ = so1 + so2;break;
                        case '-': KQ = so1 = so2;break;
                        case '*': KQ = so1 * so2;break;
                        case '/': KQ = so1 / so2;break;

                    }
                    txtkq.setText(KQ.toString());
                    so1 =KQ;
                    dau = null;
                }
            }
        });

        Button Xoa = (Button)findViewById(R.id.xoa);
        Xoa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                so1 = null;
                so2 = null;
                dau = null;
                txtkq.setText("");
            }
        });
    }
}