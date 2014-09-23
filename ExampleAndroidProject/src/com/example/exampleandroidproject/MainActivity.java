package com.example.exampleandroidproject;

import com.example.exampleandroidproject.ads.BannerAdsActivity;
import com.example.exampleandroidproject.webview.WebViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// set on click event for each button
		findViewById(R.id.btnShowBannerAds).setOnClickListener(this);
		findViewById(R.id.btnWebView).setOnClickListener(this);
		findViewById(R.id.btnDraggable1).setOnClickListener(this);
		findViewById(R.id.btnDraggable2).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.btnShowBannerAds:
			intent = new Intent(this, BannerAdsActivity.class);
			intent.putExtra(EXTRA_MESSAGE, "Show Banner Ads Activity");
			startActivity(intent);
			break;
			
		case R.id.btnWebView:
			intent = new Intent(this, WebViewActivity.class);
			intent.putExtra(EXTRA_MESSAGE, "Show Web View Activity");
			startActivity(intent);
			break;
			
		case R.id.btnDraggable1:
			intent = new Intent(this, BannerAdsActivity.class);
			intent.putExtra(EXTRA_MESSAGE, "Show Draggable 1 Activity");
			startActivity(intent);
			break;
			
		case R.id.btnDraggable2:
			intent = new Intent(this, BannerAdsActivity.class);
			intent.putExtra(EXTRA_MESSAGE, "Show Draggable 2 Activity");
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
