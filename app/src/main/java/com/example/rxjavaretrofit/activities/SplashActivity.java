package com.example.rxjavaretrofit.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.utils.AlertDialogUtil;
import com.example.rxjavaretrofit.utils.Constants;
import com.example.rxjavaretrofit.utils.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init(){
        imgLogo = findViewById(R.id.imgLogo);
        countDownTimeriBaslat();
    }

    private void countDownTimeriBaslat(){
        CountDownTimer countDownTimer = new CountDownTimer(Constants.TIMER_SANIYE,Constants.TIMER_ARALIK) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                internetKontrolEt();
            }
        };
        countDownTimer.start();
    }

    private void internetKontrolEt(){
        if(NetworkUtil.internetVarMi(getApplicationContext())){
            ekranGecisiYap();
        }else{
            AlertDialogUtil.alertDialogGoster(
                    SplashActivity.this,
                    getString(R.string.alert_dialog_internet_title),
                    getString(R.string.alert_dialog_internet_message),
                    Constants.INTERNET_YOK_DIALOG);
        }
    }

    private void ekranGecisiYap(){
        startActivity(new Intent(SplashActivity.this, ListActivity.class));
        finish();
    }
}