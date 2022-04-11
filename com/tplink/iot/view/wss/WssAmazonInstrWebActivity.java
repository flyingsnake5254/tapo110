package com.tplink.iot.view.wss;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;

public class WssAmazonInstrWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View p0;
  private boolean p1;
  private String p2;
  private boolean p3 = false;
  private WebView y = null;
  private ProgressBar z = null;
  
  public static void j1(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, WssAmazonInstrWebActivity.class);
    localIntent.putExtra("UrlExtra", paramString);
    paramActivity.startActivity(localIntent);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void k1()
  {
    c1("");
    Object localObject = findViewById(2131364828);
    this.p0 = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    localObject = (ProgressBar)findViewById(2131364827);
    this.z = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    localObject = (WebView)findViewById(2131364829);
    this.y = ((WebView)localObject);
    n1(((WebView)localObject).getSettings());
    this.y.setWebViewClient(new b(null));
    this.y.setWebChromeClient(new c(null));
  }
  
  public static void l1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, WssAmazonInstrWebActivity.class);
    localIntent.putExtra("UrlExtra", paramString);
    localIntent.putExtra("ShowTitleExtra", true);
    paramContext.startActivity(localIntent);
  }
  
  private void m1()
  {
    if (t0.g(this))
    {
      this.p1 = false;
      this.z.setProgress(0);
      this.z.setVisibility(0);
      this.p0.setVisibility(8);
      this.y.loadUrl(this.p2);
    }
    else
    {
      this.p1 = true;
      this.p0.setVisibility(0);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void n1(WebSettings paramWebSettings)
  {
    paramWebSettings.setJavaScriptEnabled(true);
  }
  
  public void onBackPressed()
  {
    if (this.y.canGoBack()) {
      this.y.goBack();
    } else {
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364828) {
      m1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558722);
    this.p2 = getIntent().getStringExtra("UrlExtra");
    this.p3 = getIntent().getBooleanExtra("ShowTitleExtra", false);
    k1();
    m1();
  }
  
  protected void onDestroy()
  {
    WebView localWebView = this.y;
    if (localWebView != null)
    {
      localWebView.stopLoading();
      this.y.getSettings().setJavaScriptEnabled(false);
      this.y.clearHistory();
      this.y.removeAllViews();
      this.y.destroy();
      this.y = null;
    }
    super.onDestroy();
  }
  
  private class b
    extends WebViewClient
  {
    private b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((!WssAmazonInstrWebActivity.e1(WssAmazonInstrWebActivity.this)) && (WssAmazonInstrWebActivity.f1(WssAmazonInstrWebActivity.this) != null) && (WssAmazonInstrWebActivity.g1(WssAmazonInstrWebActivity.this) != null))
      {
        WssAmazonInstrWebActivity.f1(WssAmazonInstrWebActivity.this).setVisibility(8);
        WssAmazonInstrWebActivity.g1(WssAmazonInstrWebActivity.this).setVisibility(0);
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    @RequiresApi(api=23)
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
  }
  
  private class c
    extends WebChromeClient
  {
    private c() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        WssAmazonInstrWebActivity.h1(WssAmazonInstrWebActivity.this).setVisibility(8);
      } else {
        WssAmazonInstrWebActivity.h1(WssAmazonInstrWebActivity.this).setProgress(paramInt);
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      if (WssAmazonInstrWebActivity.i1(WssAmazonInstrWebActivity.this)) {
        WssAmazonInstrWebActivity.this.c1(paramString);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\wss\WssAmazonInstrWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */