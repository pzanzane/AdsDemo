package com.jio.sample.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.jio.sample.R;

public class Dialog {

    // 2 objects activity and dialog
    private Activity activity;
    private AlertDialog dialog;

    // constructor of dialog class
    // with parameter activity
    public Dialog(Activity myActivity) {
        activity = myActivity;
    }

    @SuppressLint("InflateParams")
    public void show() {

        // adding ALERT Dialog builder object and passing activity as parameter
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        // layoutinflater object and use activity to get layout inflater
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    // dismiss method
    public void dismiss() {
        dialog.dismiss();
    }

}
