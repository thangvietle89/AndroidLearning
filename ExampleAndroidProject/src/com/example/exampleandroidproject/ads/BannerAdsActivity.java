package com.example.exampleandroidproject.ads;

import java.util.GregorianCalendar;

import com.example.exampleandroidproject.MainActivity;
import com.example.exampleandroidproject.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class BannerAdsActivity extends Activity {

	private AdView adView;
	private TextView txtMessageTitle;

	@SuppressLint("ShowToast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.banner_ads);

		// get message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		// set message to textview
		txtMessageTitle = (TextView) findViewById(R.id.txtMessageTitle);
		txtMessageTitle.setText(message);

		adView = (AdView) findViewById(R.id.adView);
		Bundle bundle = new Bundle();
		bundle.putString("color_bg", "AAAAFF");
		bundle.putString("color_bg_top", "FFFFFF");
		bundle.putString("color_border", "FFFFFF");
		bundle.putString("color_link", "000080");
		bundle.putString("color_text", "808080");
		bundle.putString("color_url", "008000");
		AdMobExtras extras = new AdMobExtras(bundle);
		LocationManager locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or use LocationManager.GPS_PROVIDER
		Location lastKnownLocation = locationManager
				.getLastKnownLocation(locationProvider);
		AdRequest adRequest = new AdRequest.Builder()
				.addKeyword("Hello World!").setGender(AdRequest.GENDER_FEMALE)
				.setBirthday(new GregorianCalendar(1989, 1, 1).getTime())
				.setLocation(lastKnownLocation)
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addNetworkExtras(extras).tagForChildDirectedTreatment(true)
				.addTestDevice("**").build();
		adView.loadAd(adRequest);
		adView.setVisibility(View.VISIBLE);
		adView.setAdListener(new AdListener() {
			@Override
			public void onAdOpened() {
				// Save app state before going to the ad overlay.
				Log.d("BannerAdsActivityLog", "On Ad Opened");
				Toast.makeText(getApplicationContext(), "On Ad Opened",
						Toast.LENGTH_LONG);
			}

			@Override
			public void onAdLoaded() {
				Log.d("BannerAdsActivityLog", "On Ad Loaded");
				Toast.makeText(getApplicationContext(), "On Ad Loaded",
						Toast.LENGTH_LONG);
			}
		});
	}

	@Override
	protected void onPause() {
		if (adView != null) {
			adView.pause();
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		if (adView != null) {
			adView.resume();
		}
		super.onResume();
	}

	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}
}
