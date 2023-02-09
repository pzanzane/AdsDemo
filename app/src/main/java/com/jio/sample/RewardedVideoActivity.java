package com.jio.sample;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jio.jioads.adinterfaces.JioAdError;
import com.jio.jioads.adinterfaces.JioAdListener;
import com.jio.jioads.adinterfaces.JioAdView;
import com.jio.jioads.adinterfaces.JioAds;
import com.jio.sample.databinding.ActivityDynamicInterstitialrBinding;
import org.jetbrains.annotations.Nullable;

public class RewardedVideoActivity extends BaseActivity  {

    private ActivityDynamicInterstitialrBinding binding;
    private JioAdView jioAdView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JioAds.Companion.getInstance().setLogLevel(JioAds.LogLevel.DEBUG);

        //for this jio document not updated yet. they are using JioAds.getInstance().init(this)
        JioAds.Companion.getInstance().init(this);

        binding = ActivityDynamicInterstitialrBinding.inflate(getLayoutInflater());
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
        delayed(this::dynamicInterstitialAd);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopVideo();
    }

    private void dynamicInterstitialAd() {

        dialog.show();
        jioAdView = new JioAdView(this, "ojfq520l",
                JioAdView.AD_TYPE.INTERSTITIAL);

        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(RewardedVideoActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
                resumeVideo();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(RewardedVideoActivity.this, "onAdClosed : ", Toast.LENGTH_SHORT).show();
                resumeVideo();
            }

            @Override
            public void onAdPrepared(@Nullable JioAdView jioAdView) {
                dialog.dismiss();
                if(jioAdView.getAdState() == JioAdView.AdState.PREPARED) {
                    jioAdView.loadAd();
                }

            }

            @Override
            public void onAdRender(@Nullable JioAdView jioAdView) {
                Toast.makeText(RewardedVideoActivity.this, "onAdRender : " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(RewardedVideoActivity.this, "onAdMediaEnd : " , Toast.LENGTH_SHORT).show();
            }
        });

        binding.nativeAdContainer.removeAllViews();
        binding.nativeAdContainer.addView(jioAdView);
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