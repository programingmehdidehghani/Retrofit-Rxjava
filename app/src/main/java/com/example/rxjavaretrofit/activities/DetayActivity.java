package com.example.rxjavaretrofit.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjavaretrofit.R;

public class DetayActivity extends AppCompatActivity {

    ImageView imgKapakDetay;
    TextView txtBaslik;
    TextView txtDetay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);
    }

    private void init(){
        
    }
}
