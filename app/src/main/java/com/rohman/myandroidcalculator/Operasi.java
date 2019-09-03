package com.rohman.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Operasi extends AppCompatActivity {

    String operasi = "";
    Button btn_plus;
    Button btn_minus;
    Button btn_kali;
    Button btn_bagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operasi);

        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_kali = (Button) findViewById(R.id.btn_bagi);
        btn_bagi = (Button) findViewById(R.id.btn_kali);

    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                operasi = "+";
                break;
            case R.id.btn_minus:
                operasi = "-";
                break;
            case R.id.btn_kali:
                operasi = "x";
                break;
            case R.id.btn_bagi:
                operasi = "/";
                break;
        }
        returnIntent();
    }

    public void returnIntent() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("operasi", operasi);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
