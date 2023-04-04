package com.example.rxjavaretrofit.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.adapter.BilimKadiniAdaptor;
import com.example.rxjavaretrofit.model.BilimKadiniModel;
import com.example.rxjavaretrofit.network.Service;
import com.example.rxjavaretrofit.utils.AlertDialogUtil;
import com.example.rxjavaretrofit.utils.Constants;
import com.example.rxjavaretrofit.utils.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

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

    private void init(){
        imgKapak = findViewById(R.id.imgKapak);
        txtAciklama = findViewById(R.id.txtAciklama);
        progressDialogGoster();
        bilimKadinlariniGetir();
    }

    public void  bilimKadinlariniGetir(){
        new Service().getServiceApi().bilimKadinlariniGetir()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<BilimKadiniModel>>() {
                    List<BilimKadiniModel> bilimKadinlari=new ArrayList<>();
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<BilimKadiniModel> bilimKadiniModels) {
                        bilimKadinlari = bilimKadiniModels;

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if(bilimKadinlari.size()>0) {
                            initRecycleView(bilimKadinlari);
                        }
                        progressDialog.dismiss();
                    }
                });
    }


    private void initRecycleView(List<BilimKadiniModel> bilimKadiniList){
        recyclerView = findViewById(R.id.rcvBilimKadinlari);
        BilimKadiniAdaptor bilimKadiniAdaptor = new BilimKadiniAdaptor(bilimKadiniList, getApplicationContext(), new BilimKadiniAdaptor.OnItemClickListener() {
            @Override
            public void onClik(int position) {
                BilimKadiniModel tiklananBilimKadini = bilimKadiniList.get(position);
                ekranGecisiYap(tiklananBilimKadini);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(bilimKadiniAdaptor);
    }

    private void ekranGecisiYap(BilimKadiniModel tiklananBilimKadini){
        Intent detayActivityIntent = new Intent(getApplicationContext(),DetayActivity.class);
        String tiklananBilimKadiniString = ObjectUtil.bilimKadiniToJsonString(tiklananBilimKadini);
        detayActivityIntent.putExtra(Constants.TIKLANAN_BILIM_KADINI_TASINANIN_BASLIGI,tiklananBilimKadiniString);
        startActivity(detayActivityIntent);

    }

    private void progressDialogGoster(){
        progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage(getString(R.string.progress_dialog_message));
        progressDialog.show();
    }


}
