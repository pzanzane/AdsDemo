package com.jio.sample;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.jio.jioads.adinterfaces.JioAdError;
import com.jio.jioads.adinterfaces.JioAdListener;
import com.jio.jioads.adinterfaces.JioAdView;
import com.jio.jioads.adinterfaces.JioAds;
import com.jio.sample.databinding.ActivityBannerAdGoogleBinding;
import com.jio.sample.databinding.ActivityVideoBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BannerAdGoogleActivity extends BaseActivity {

    private ActivityBannerAdGoogleBinding binding;
    private JioAdView jioAdView=null;
    private AdView adView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JioAds.Companion.getInstance().setLogLevel(JioAds.LogLevel.DEBUG);

        JioAds.Companion.getInstance().init(this);

        binding = ActivityBannerAdGoogleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        binding.btnBanner.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.BANNER));
        binding.btnFullBanner.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.FULL_BANNER));
        binding.btnLargeBanner.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.LARGE_BANNER));
        binding.btnLeaderboard.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.LEADERBOARD));
        binding.btnMediumRectangle.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.MEDIUM_RECTANGLE));
        binding.btnSmartBanner.setOnClickListener((View.OnClickListener) view -> loadAdd(AdSize.SMART_BANNER));

    }

    private void loadAdd(AdSize adSize) {

        if(adView!=null) {
            binding.getRoot().removeView(adView);
        }
        AdRequest adRequest = new AdRequest.Builder().build();

        adView = new AdView(this);

        dialog.show();
        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull @NotNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                dialog.dismiss();
                Toast.makeText(BannerAdGoogleActivity.this, "Error : "+loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                dialog.dismiss();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdSwipeGestureClicked() {
                super.onAdSwipeGestureClicked();
            }
        });

        adView.setAdSize(adSize);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        adView.loadAd(adRequest);

        binding.getRoot().addView(adView);

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