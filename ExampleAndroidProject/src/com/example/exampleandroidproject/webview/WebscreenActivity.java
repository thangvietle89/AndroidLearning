package com.example.exampleandroidproject.webview;

import com.example.exampleandroidproject.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class WebscreenActivity extends Activity {
	public static final String URL = "";
	private static final String TAG = "Class Webscreen";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webscreen);

		String url = getIntent().getStringExtra(URL);
		Log.d(TAG, "Recipe url = " + url);

		WebView webView = new WebView(this);
		setContentView(webView);

		// Simplest usage: No exception thrown for page-load error
		webView.loadUrl(url);
	}
}
