package com.example.rxjavaretrofit.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.model.BilimKadiniModel;
import com.example.rxjavaretrofit.utils.Constants;
import com.example.rxjavaretrofit.utils.ObjectUtil;

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
        String tasinanBilimKadiniString = getIntent().getStringExtra(Constants.TIKLANAN_BILIM_KADINI_TASINANIN_BASLIGI);
        BilimKadiniModel bilimKadiniModel = ObjectUtil.jsonStringToBilimKadini(tasinanBilimKadiniString);
    }
}
