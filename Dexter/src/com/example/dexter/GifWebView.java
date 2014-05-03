package com.example.dexter;

import android.content.Context;
import android.webkit.WebView;

/**
 * Allows to open a WebView, which can open a webpage and display it in the phone.
 * 
 * In activity, simply call:
 * GifWebView view = new GifWebView(this, "file:///android_asset/chikorita.gif");
 * setContentView(view);
 *
 */
public class GifWebView extends WebView
{
	public GifWebView(Context context, String path) {
		super(context);
		loadUrl(path);
	}
}
