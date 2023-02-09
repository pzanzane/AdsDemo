package com.jio.sample;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jio.jioads.adinterfaces.JioAdError;
import com.jio.jioads.adinterfaces.JioAdListener;
import com.jio.jioads.adinterfaces.JioAdView;
import com.jio.jioads.adinterfaces.JioAds;
import com.jio.sample.databinding.ActivityVideoBinding;

import org.jetbrains.annotations.Nullable;

public class VideoAdActivity extends BaseActivity {

    private ActivityVideoBinding binding;
    private JioAdView jioAdView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JioAds.Companion.getInstance().setLogLevel(JioAds.LogLevel.DEBUG);

        JioAds.Companion.getInstance().init(this);

        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        startVideo(binding.videoView);
        delayed(this::videoAd);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopVideo();
    }

    private void videoAd() {
        pauseVideo();
        dialog.show();
        jioAdView = new JioAdView (this,"ocl0xur8",
        JioAdView.AD_TYPE.INSTREAM_VIDEO);

        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(VideoAdActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
                resumeVideo();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(VideoAdActivity.this, "onAdClosed", Toast.LENGTH_SHORT).show();
                resumeVideo();
            }

            @Override
            public void onAdPrepared(@Nullable JioAdView jioAdView) {
                dialog.dismiss();
                if(jioAdView.getAdState() == JioAdView.AdState.PREPARED) {
                    binding.nativeAdContainer.addView(jioAdView);
                    jioAdView.loadAd();
                }

            }

            @Override
            public void onAdRender(@Nullable JioAdView jioAdView) {
                Toast.makeText(VideoAdActivity.this, "onAdRender", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(VideoAdActivity.this, "onAdMediaEnd", Toast.LENGTH_SHORT).show();
            }
        });
        jioAdView.setPackageName(getApplicationContext().getPackageName());
        jioAdView.cacheAd();
    }


    @Override
    protected void onDestroy() {
        JioAds.Companion.getInstance().release();

        if(jioAdView!=null) {
            jioAdView.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}