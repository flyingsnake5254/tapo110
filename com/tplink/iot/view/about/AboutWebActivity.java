package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class AboutWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean H3;
  private View p0 = null;
  private TPMaterialDialogV2 p1 = null;
  private String p2 = "";
  private TPMaterialDialogV2 p3;
  private WebView y;
  private ProgressBar z;
  
  private void l1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      this.p2 = ((Intent)localObject).getStringExtra("url");
    }
    setSupportActionBar((Toolbar)findViewById(2131364275));
    localObject = getIntent().getStringExtra("toolbar_title");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c1((CharSequence)localObject);
    }
    localObject = (ProgressBar)findViewById(2131363716);
    this.z = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    localObject = findViewById(2131363826);
    this.p0 = ((View)localObject);
    ((View)localObject).setVisibility(8);
    this.p0.setOnClickListener(this);
    localObject = (WebView)findViewById(2131364829);
    this.y = ((WebView)localObject);
    localObject = ((WebView)localObject).getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowFileAccess(true);
    ((WebSettings)localObject).setSupportZoom(false);
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    this.y.setWebViewClient(new c(null));
    this.y.setWebChromeClient(new b(null));
    m1();
  }
  
  private void m1()
  {
    if (t0.g(this))
    {
      this.H3 = false;
      this.z.setProgress(0);
      this.z.setVisibility(0);
      this.p0.setVisibility(8);
      this.y.loadUrl(this.p2);
      this.y.setVisibility(4);
    }
    else
    {
      this.H3 = true;
      this.p0.setVisibility(0);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363826) {
      m1();
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558710);
    if (o.a() == 0) {
      return;
    }
    l1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
  }
  
  protected void onDestroy()
  {
    Object localObject = this.p1;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.p1.dismiss();
      this.p1 = null;
    }
    localObject = this.p3;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.p3.dismiss();
      this.p3 = null;
    }
    super.onDestroy();
    localObject = this.y;
    if (localObject != null)
    {
      ((WebView)localObject).loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.y.clearHistory();
      ((ViewGroup)this.y.getParent()).removeView(this.y);
      this.y.destroy();
      this.y = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = this.p1;
      if ((paramKeyEvent != null) && (paramKeyEvent.isShowing()))
      {
        this.p1.dismiss();
        this.p1 = null;
        return true;
      }
      paramKeyEvent = this.p3;
      if ((paramKeyEvent != null) && (paramKeyEvent.isShowing()))
      {
        this.p3.dismiss();
        this.p3 = null;
        return true;
      }
    }
    finish();
    return false;
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  private class b
    extends WebChromeClient
  {
    private b() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        AboutWebActivity.k1(AboutWebActivity.this).setVisibility(8);
      } else {
        AboutWebActivity.k1(AboutWebActivity.this).setProgress(paramInt);
      }
    }
  }
  
  private class c
    extends WebViewClient
  {
    private c() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!AboutWebActivity.g1(AboutWebActivity.this))
      {
        if (AboutWebActivity.i1(AboutWebActivity.this) != null) {
          AboutWebActivity.i1(AboutWebActivity.this).setVisibility(8);
        }
        if (AboutWebActivity.j1(AboutWebActivity.this) != null) {
          AboutWebActivity.j1(AboutWebActivity.this).setVisibility(0);
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AboutWebActivity.h1(AboutWebActivity.this, true);
      if (AboutWebActivity.i1(AboutWebActivity.this) != null) {
        AboutWebActivity.i1(AboutWebActivity.this).setVisibility(0);
      }
      if (AboutWebActivity.j1(AboutWebActivity.this) != null) {
        AboutWebActivity.j1(AboutWebActivity.this).setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      AboutWebActivity.h1(AboutWebActivity.this, true);
      if (AboutWebActivity.i1(AboutWebActivity.this) != null) {
        AboutWebActivity.i1(AboutWebActivity.this).setVisibility(0);
      }
      if (AboutWebActivity.j1(AboutWebActivity.this) != null) {
        AboutWebActivity.j1(AboutWebActivity.this).setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
    
    public boolean shouldOverrideUrlLoading(final WebView paramWebView, String paramString)
    {
      if (paramString.startsWith("tel:"))
      {
        paramWebView = paramString;
        if (Build.VERSION.SDK_INT < 19) {
          try
          {
            paramWebView = URLDecoder.decode(paramString, "utf-8");
          }
          catch (UnsupportedEncodingException paramWebView)
          {
            paramWebView.printStackTrace();
            paramWebView = paramString;
          }
        }
        if (AboutWebActivity.e1(AboutWebActivity.this) == null)
        {
          paramString = new TPMaterialDialogV2.Builder(AboutWebActivity.this);
          AboutWebActivity.f1(AboutWebActivity.this, paramString.k(paramWebView.substring(4), 2131099937).l(2131952391, 2131099804, null).o(2131952680, 2131099808, new a(paramWebView)).g(8, 8).a());
        }
        AboutWebActivity.e1(AboutWebActivity.this).show();
      }
      else
      {
        paramWebView.loadUrl(paramString);
      }
      return true;
    }
    
    class a
      implements TPMaterialDialogV2.d
    {
      a(String paramString) {}
      
      public void onClick(View paramView)
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramWebView));
        AboutWebActivity.this.startActivity(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\AboutWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */