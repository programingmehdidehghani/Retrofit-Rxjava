package com.example.rxjavaretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavaretrofit.R;
import com.example.rxjavaretrofit.model.BilimKadiniModel;
import com.example.rxjavaretrofit.utils.GlideUtil;

import java.util.List;

public class BilimKadiniAdaptor extends RecyclerView.Adapter<BilimKadiniViewHolder> {

    List<BilimKadiniModel> bilimKadinlari;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClik(int position);
    }

    public BilimKadiniAdaptor(List<BilimKadiniModel> bilimKadinlari, Context context, OnItemClickListener listener) {
        this.bilimKadinlari = bilimKadinlari;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BilimKadiniViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_bilim_kadini,parent,false);
        return new BilimKadiniViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull BilimKadiniViewHolder viewHolder, int position) {
        viewHolder.txtAdi.setText(bilimKadinlari.get(position).getAdi());
        viewHolder.txtAlani.setText(bilimKadinlari.get(position).getAlani());
        viewHolder.txtDogumTarihi.setText(bilimKadinlari.get(position).getDogumTarihi());
        viewHolder.txtOlumTarihi.setText(bilimKadinlari.get(position).getOlumTarihi());
        GlideUtil.resimIndiripGoster(context,bilimKadinlari.get(position).getLogoUrl(),viewHolder.imgBilimKadiniLogo);
    }

    @Override
    public int getItemCount() {
        return bilimKadinlari.size();
    }
}