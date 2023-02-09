package com.jio.sample;

import androidx.appcompat.app.AppCompatActivity;

import com.jio.sample.util.Dialog;

public class BaseActivity extends AppCompatActivity {
    final protected Dialog dialog = new Dialog(BaseActivity.this);
    final long SHOW_AD_AFTER_MS = 3000;
}
