package com.example.rxjavaretrofit.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.utils.AlertDialogUtil;
import com.example.rxjavaretrofit.utils.Constants;

public class ListActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtAciklama;
    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    public void onBackPressed() {
        AlertDialogUtil.alertDialogGoster(
                ListActivity.this,
                getString(R.string.alert_dialog_geri_tusu_title),
                getString(R.string.alert_dialog_geri_tusu_message),
                Constants.CIKIS_DIALOG);
    }
}
