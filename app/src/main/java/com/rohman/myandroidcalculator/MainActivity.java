package com.rohman.myandroidcalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tv_hasil;
    Button btn_pilih_operasi;
    Button btn_reset;
    EditText edt_bil1;
    EditText edt_bil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_hasil = findViewById(R.id.tv_hasil);
        btn_pilih_operasi = findViewById(R.id.btn_pilih_operasi);
        btn_reset = findViewById(R.id.btn_reset);
        edt_bil1 = findViewById(R.id.edt_bil1);
        edt_bil2 = findViewById(R.id.edt_bil2);


        btn_pilih_operasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edt_bil1.getText())) {
                    edt_bil1.setError("Bilangan 1 Diperlukan");
                } else if (TextUtils.isEmpty(edt_bil2.getText())) {
                    edt_bil2.setError("Bilangan 2 Diperlukan");
                } else {
                    Intent intent = new Intent(MainActivity.this, Operasi.class);
                    startActivityForResult(intent, 1);
                }


            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt_bil1.setText("");
                edt_bil2.setText("");
                tv_hasil.setText("");
            }
        });
    }

    private Double kalkulasi(Double bil1, Double bil2, String operasi) {
        Double hasil = null;

        switch (operasi) {
            case "+":
                hasil = bil1 + bil2;
                break;
            case "-":
                hasil = bil1 - bil2;
                break;
            case "/":
                hasil = bil1 / bil2;
                break;
            case "x":
                hasil = bil1 * bil2;
                break;
        }

        return hasil;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {

                Double bil1Value = Double.valueOf(edt_bil1.getText().toString());
                Double bil2Value = Double.valueOf(edt_bil2.getText().toString());
                String operasi = data.getStringExtra("operasi");
                Double hasil = kalkulasi(bil1Value, bil2Value, operasi);
                DecimalFormat format = new DecimalFormat("0.#");
                String res = format.format(bil1Value) + " " + operasi + " " + format.format(bil2Value) + " = " + format.format(hasil);
                tv_hasil.setText(res);
            }
        }

    }
}
