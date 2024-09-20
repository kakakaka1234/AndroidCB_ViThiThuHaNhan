package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Integer so1 = 0;
    Integer so2 = 0;
    Character dau = null;
    boolean isSecondNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        final TextView txtkq = (TextView) findViewById(R.id.kq);

        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                String num = btn.getText().toString();
                String currentText = txtkq.getText().toString();

                txtkq.setText(currentText + num);

                if (!isSecondNumber) {
                    so1 = Integer.parseInt(txtkq.getText().toString());
                } else {
                    so2 = Integer.parseInt(txtkq.getText().toString());
                }
            }
        };

        findViewById(R.id.so0).setOnClickListener(numberClickListener);
        findViewById(R.id.so1).setOnClickListener(numberClickListener);
        findViewById(R.id.so2).setOnClickListener(numberClickListener);
        findViewById(R.id.so3).setOnClickListener(numberClickListener);
        findViewById(R.id.so4).setOnClickListener(numberClickListener);
        findViewById(R.id.so5).setOnClickListener(numberClickListener);
        findViewById(R.id.so6).setOnClickListener(numberClickListener);
        findViewById(R.id.so7).setOnClickListener(numberClickListener);
        findViewById(R.id.so8).setOnClickListener(numberClickListener);
        findViewById(R.id.so9).setOnClickListener(numberClickListener);

        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                dau = btn.getText().charAt(0);
                isSecondNumber = true;
                txtkq.setText("");
            }
        };

        findViewById(R.id.cong).setOnClickListener(operatorClickListener);
        findViewById(R.id.tru).setOnClickListener(operatorClickListener);
        findViewById(R.id.nhan).setOnClickListener(operatorClickListener);
        findViewById(R.id.chia).setOnClickListener(operatorClickListener);

        Button Bang = (Button) findViewById(R.id.bang);
        Bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dau != null) {
                    Double KQ = 0.0;

                    switch (dau) {
                        case '+':
                            KQ = so1 + so2 * 1.0;
                            break;
                        case '-':
                            KQ = so1 - so2 * 1.0;
                            break;
                        case 'X':
                            KQ = so1 * so2 * 1.0;
                            break;
                        case '/':
                            if (so2 == 0) {
                                txtkq.setText("Lỗi: Chia 0");
                                return;
                            } else {
                                KQ = so1 / (double) so2;
                            }
                            break;
                    }

                    txtkq.setText(String.valueOf(KQ));
                    so1 = KQ.intValue();
                    so2 = 0;
                    dau = null;
                    isSecondNumber = false;
                }
            }
        });

        Button Xoa = (Button) findViewById(R.id.xoa);
        Xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so1 = 0;
                so2 = 0;
                dau = null;
                isSecondNumber = false;
                txtkq.setText("");
            }
        });
    }
}
