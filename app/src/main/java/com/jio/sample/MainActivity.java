package com.jio.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.jio.sample.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivity extends BaseActivity {

    com.jio.sample.databinding.ActivityMainBinding binding=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.jio_ads));

        binding.btnVideoJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,VideoAdActivity.class);
            startActivity(intent);

            // Intent intent = new Intent(this,PlayVideoActivity.class);
            // startActivity(intent);
        });

        binding.btnNativeBannerJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,NativeBannerActivity.class);
            startActivity(intent);
        });

        binding.btnInterstitialJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,DynamicInterstitialActivity.class);
            startActivity(intent);
        });

        binding.btnRewardedVideoJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,RewardedVideoActivity.class);
            startActivity(intent);
        });

        binding.btnInstreamVideoJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,InstreamVideoActivity.class);
            startActivity(intent);
        });

        binding.btnCustomInstreamVideoJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,CustomInstreamVideoActivity.class);
            startActivity(intent);
        });

        binding.btnCustomInstreaAudioJioAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,InstreamAudioActivity.class);
            startActivity(intent);
        });


        binding.btnBannerGoogleAds.setOnClickListener(view -> {
            Intent intent = new Intent(this,BannerAdGoogleActivity.class);
            startActivity(intent);
        });

        binding.btnNativeGoogleAds.setOnClickListener(view -> {
                Intent intent = new Intent(this,NativeAdGoogleActivity.class);
                startActivity(intent);
        });

        binding.btnInterstitialGoogleAds.setOnClickListener(view -> {

            AdRequest adRequest = new AdRequest.Builder().build();

            dialog.show();

            InterstitialAd.load(MainActivity.this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            dialog.dismiss();
                           interstitialAd.show(MainActivity.this);
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "Error : "+loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        });

        binding.btnRewardedVideoGoogleAds.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
                AdRequest adRequest = new AdRequest.Builder().build();
                RewardedAd.load(MainActivity.this, "ca-app-pub-3940256099942544/5224354917",
                        adRequest, new RewardedAdLoadCallback() {
                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                                dialog.dismiss();
                                Toast.makeText(MainActivity.this, "Error : "+loadAdError.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                                dialog.dismiss();
                                if (rewardedAd != null) {
                                    Activity activityContext = MainActivity.this;
                                    rewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                        @Override
                                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                            // Handle the reward.
                                            int rewardAmount = rewardItem.getAmount();
                                            String rewardType = rewardItem.getType();
                                        }
                                    });
                                } else {
                                    Toast.makeText(MainActivity.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_jio) {
            getSupportActionBar().setTitle(getResources().getString(R.string.jio_ads));
            binding.llJioAds.setVisibility(View.VISIBLE);
            binding.llGoogleAds.setVisibility(View.GONE);
            return true;
        }

        if (id == R.id.action_google) {
            getSupportActionBar().setTitle(getResources().getString(R.string.google_ads));
            binding.llJioAds.setVisibility(View.GONE);
            binding.llGoogleAds.setVisibility(View.VISIBLE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void googleAds(){

    }

}