package com.rdevlab.tupresidentesoundboard;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.rdevlab.tupresidentesoundboard.fragments.CategoryAdapter;

/**
 * @author rms
 */
public class MainActivity extends AppCompatActivity {

    public static ViewPager viewPager;

    private static int mAdCount = 0;
    private static final int S_NO_CLICKS = 5;
    private static InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        initBannerAd();
        initInterstitialAd();
    }

    private void initBannerAd() {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest mAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(mAdRequest);
    }

    private void initInterstitialAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public static void adCounter() {
        mAdCount++;
        Log.d("Interstitial", "Click: " + getmAdCount());
        if (getmAdCount() == S_NO_CLICKS) {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
            callNewInterstitialAd();
            setmAdCount();
        }
    }

    public static void callNewInterstitialAd() {
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    private static int getmAdCount() {
        return mAdCount;
    }

    private static void setmAdCount() {
        mAdCount = 0;
    }
}
