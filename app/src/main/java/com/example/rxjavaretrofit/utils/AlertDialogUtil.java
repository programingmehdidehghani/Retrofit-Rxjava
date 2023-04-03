package com.example.rxjavaretrofit.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import androidx.appcompat.app.AlertDialog;

import com.example.rxjavaretrofit.R;

public class AlertDialogUtil {

    public static void alertDialogGoster(Context context, String title, String message, String dialogType){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(context.getResources().getString(R.string.alert_dialog_positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialogType == Constants.INTERNET_YOK_DIALOG ){
                    context.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }else{
                    dialog.dismiss();
                    ((Activity)context).finish();
                }
            }
        });
        builder.setNegativeButton(context.getResources().getString(R.string.alert_dialog_negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialogType == Constants.INTERNET_YOK_DIALOG ){
                    dialog.dismiss();
                    ((Activity)context).finish();
                }else{
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
}
