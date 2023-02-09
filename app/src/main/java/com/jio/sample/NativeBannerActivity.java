package com.jio.sample;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.jio.jioads.adinterfaces.JioAdError;
import com.jio.jioads.adinterfaces.JioAdListener;
import com.jio.jioads.adinterfaces.JioAdView;
import com.jio.jioads.adinterfaces.JioAds;
import com.jio.jioads.util.Constants;
import com.jio.sample.databinding.ActivityNativeBannerBinding;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

public class NativeBannerActivity extends BaseActivity   {

    private ActivityNativeBannerBinding binding;
    private JioAdView jioAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JioAds.Companion.getInstance().setLogLevel(JioAds.LogLevel.DEBUG);

        JioAds.Companion.getInstance().init(this);

        binding = ActivityNativeBannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btnNativeBanner.setOnClickListener(view -> nativeBannerAd());

        binding.btnNativeBillboard.setOnClickListener(view -> nativeBillboardAd());

        binding.btnDynamicBanner.setOnClickListener(view -> dynamicBannerAd());

        binding.btnDynamicBillboard.setOnClickListener(view -> dynamicBillboardAd());

    }

    private void nativeBannerAd() {
        dialog.show();
        jioAdView = new JioAdView(this, "ocl0xur8",
                JioAdView.AD_TYPE.INFEED);

        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(NativeBannerActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(NativeBannerActivity.this, "onAdClosed : ", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NativeBannerActivity.this, "onAdRender : " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(NativeBannerActivity.this, "onAdMediaEnd : " , Toast.LENGTH_SHORT).show();
            }
        });

        List<Constants.DynamicDisplaySize> strings = new ArrayList<>();
        strings.add(Constants.DynamicDisplaySize.SIZE_320x50);
        jioAdView.setDisplayAdSize(strings);
        binding.adview.removeAllViews();
        binding.adview.addView(jioAdView);
        jioAdView.cacheAd();
    }

    private void nativeBillboardAd() {
        dialog.show();
        jioAdView = new JioAdView(this, "bzpf5akn",
                JioAdView.AD_TYPE.CONTENT_STREAM);
        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(NativeBannerActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(NativeBannerActivity.this, "onAdClosed : ", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NativeBannerActivity.this, "onAdRender : " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(NativeBannerActivity.this, "onAdMediaEnd : " , Toast.LENGTH_SHORT).show();
            }
        });

        binding.adview.removeAllViews();
        binding.adview.addView(jioAdView);
        jioAdView.cacheAd();
    }

    private void dynamicBannerAd() {
        dialog.show();
        jioAdView = new JioAdView(this, "eycs6phx",
                JioAdView.AD_TYPE.DYNAMIC_DISPLAY);
        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(NativeBannerActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(NativeBannerActivity.this, "onAdClosed : ", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NativeBannerActivity.this, "onAdRender : " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(NativeBannerActivity.this, "onAdMediaEnd : " , Toast.LENGTH_SHORT).show();
            }
        });

        List<Constants.DynamicDisplaySize> strings = new ArrayList<>();
        strings.add(Constants.DynamicDisplaySize.SIZE_320x50);
        jioAdView.setDisplayAdSize(strings);
        binding.adview.removeAllViews();
        binding.adview.addView(jioAdView);
        jioAdView.cacheAd();
    }


    private void dynamicBillboardAd() {
        dialog.show();
        jioAdView = new JioAdView(this, "pykf9ags",
                JioAdView.AD_TYPE.DYNAMIC_DISPLAY);
        jioAdView.setAdListener(new JioAdListener() {
            @Override
            public void onAdFailedToLoad(@Nullable JioAdView jioAdView, @Nullable JioAdError jioAdError) {
                dialog.dismiss();
                Toast.makeText(NativeBannerActivity.this, "onAdFailedToLoad : "+jioAdError.getErrorDescription(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed(@Nullable JioAdView jioAdView, boolean b, boolean b1) {
                Toast.makeText(NativeBannerActivity.this, "onAdClosed : ", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NativeBannerActivity.this, "onAdRender : " , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdMediaEnd(@Nullable JioAdView jioAdView) {
                Toast.makeText(NativeBannerActivity.this, "onAdMediaEnd : " , Toast.LENGTH_SHORT).show();
            }
        });

        List<Constants.DynamicDisplaySize> strings = new ArrayList<>();
        strings.add(Constants.DynamicDisplaySize.SIZE_300x250);
        jioAdView.setDisplayAdSize(strings);
        binding.adview.removeAllViews();
        binding.adview.addView(jioAdView);
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