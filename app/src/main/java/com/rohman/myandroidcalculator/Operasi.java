package com.rohman.myandroidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Operasi extends AppCompatActivity {

    String operasi = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operasi);

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
