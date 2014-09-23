package com.example.exampleandroidproject.webview;

import com.example.exampleandroidproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class WebViewActivity extends Activity implements OnClickListener {

	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);

		// get message from the intent
		// Intent intent = getIntent();
		// String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// Add Click listeners for all buttons
		View firstBtn = findViewById(R.id.button1);
		firstBtn.setOnClickListener(this);
		View secordBtn = findViewById(R.id.button2);
		secordBtn.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.button1:
			intent = new Intent(this, WebscreenActivity.class);
			intent.putExtra(WebscreenActivity.URL,
					"http://eagle.phys.utk.edu/guidry/recipes/mojito.html");
			startActivity(intent);
			break;

		case R.id.button2:
			intent = new Intent(this, WebscreenActivity.class);
			intent.putExtra(WebscreenActivity.URL,
					"http://www.ssd.noaa.gov/goes/east/tatl/vis-l.jpg");
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
