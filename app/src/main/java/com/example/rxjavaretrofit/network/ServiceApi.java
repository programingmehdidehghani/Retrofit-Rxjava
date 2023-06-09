package com.example.rxjavaretrofit.network;


import com.example.rxjavaretrofit.model.BilimKadiniModel;
import com.example.rxjavaretrofit.utils.Constants;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET(Constants.SERVIS_API)
    Observable<List<BilimKadiniModel>> bilimKadinlariniGetir();

}
