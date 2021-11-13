package com.example.studentmonitoring;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

	private WebView mywebView;
	private EditText myurl;
	private Button mysubmit;
	private LinearLayout myform;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 mywebView=(WebView) findViewById(R.id.webview);
		 myurl = (EditText)findViewById(R.id.et_url);
		 mysubmit = (Button)findViewById(R.id.btn_submit);
		 myform = (LinearLayout)findViewById(R.id.form);
		 
		 mysubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String url = myurl.getText().toString().trim();
				if (!url.isEmpty()) {
					mywebView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
					myform.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
					 mywebView.setWebViewClient(new WebViewClient());
					 mywebView.loadUrl(url);
					 WebSettings webSettings=mywebView.getSettings();
					 webSettings.setJavaScriptEnabled(true);					 
				}
			}
		});		
	}
	
	public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
	@Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
	    else{
	        super.onBackPressed();
        }
}
}
