package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public abstract class AbsCommonWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean H3;
  private ProgressBar p0;
  private TPMaterialDialogV2 p1 = null;
  private String p2 = "";
  private MenuItem p3 = null;
  private WebView y;
  private View z;
  
  private void m1()
  {
    if (this.y.canGoBack()) {
      this.y.goBack();
    } else {
      finish();
    }
  }
  
  @SuppressLint({"JavascriptInterface"})
  private void p1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      this.p2 = ((Intent)localObject).getStringExtra("url");
    }
    localObject = findViewById(2131364832);
    this.z = ((View)localObject);
    ((View)localObject).setVisibility(8);
    this.z.setOnClickListener(this);
    localObject = (ProgressBar)findViewById(2131363716);
    this.p0 = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    this.p0.setVisibility(0);
    localObject = (WebView)findViewById(2131364829);
    this.y = ((WebView)localObject);
    localObject = ((WebView)localObject).getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setAllowFileAccess(true);
    ((WebSettings)localObject).setSupportZoom(false);
    ((WebSettings)localObject).setBuiltInZoomControls(false);
    this.y.setWebViewClient(new c(null));
    this.y.setWebChromeClient(new b(null));
    this.y.addJavascriptInterface(n1(), o1());
  }
  
  private void q1()
  {
    if (t0.g(this))
    {
      this.H3 = false;
      this.p0.setProgress(0);
      this.p0.setVisibility(0);
      this.z.setVisibility(8);
      this.y.setVisibility(8);
      this.y.loadUrl(this.p2);
    }
    else
    {
      this.H3 = true;
      this.z.setVisibility(0);
      this.y.setVisibility(8);
      this.p0.setVisibility(8);
    }
  }
  
  public abstract Object n1();
  
  public abstract String o1();
  
  public void onBackPressed()
  {
    m1();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364832) {
      q1();
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558489);
    if (o.a() == 0) {
      return;
    }
    setSupportActionBar((Toolbar)findViewById(2131364275));
    paramBundle = getIntent().getStringExtra("toolbar_title");
    if (!TextUtils.isEmpty(paramBundle)) {
      c1(paramBundle);
    }
    p1();
    q1();
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    paramMenu = paramMenu.findItem(2131362297);
    this.p3 = paramMenu;
    paramMenu.setVisible(false);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 2131362297)
    {
      finish();
      return true;
    }
    if (i == 16908332)
    {
      m1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private class b
    extends WebChromeClient
  {
    private b() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        AbsCommonWebActivity.l1(AbsCommonWebActivity.this).setVisibility(8);
      } else {
        AbsCommonWebActivity.l1(AbsCommonWebActivity.this).setProgress(paramInt);
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
      if (AbsCommonWebActivity.k1(AbsCommonWebActivity.this) != null)
      {
        paramWebView = AbsCommonWebActivity.k1(AbsCommonWebActivity.this);
        boolean bool;
        if ((AbsCommonWebActivity.j1(AbsCommonWebActivity.this) != null) && (AbsCommonWebActivity.j1(AbsCommonWebActivity.this).canGoBack())) {
          bool = true;
        } else {
          bool = false;
        }
        paramWebView.setVisible(bool);
      }
      if ((!AbsCommonWebActivity.g1(AbsCommonWebActivity.this)) && (AbsCommonWebActivity.i1(AbsCommonWebActivity.this) != null) && (AbsCommonWebActivity.j1(AbsCommonWebActivity.this) != null))
      {
        AbsCommonWebActivity.i1(AbsCommonWebActivity.this).setVisibility(8);
        AbsCommonWebActivity.j1(AbsCommonWebActivity.this).setVisibility(0);
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AbsCommonWebActivity.h1(AbsCommonWebActivity.this, true);
      if ((AbsCommonWebActivity.i1(AbsCommonWebActivity.this) != null) && (AbsCommonWebActivity.j1(AbsCommonWebActivity.this) != null))
      {
        AbsCommonWebActivity.i1(AbsCommonWebActivity.this).setVisibility(0);
        AbsCommonWebActivity.j1(AbsCommonWebActivity.this).setVisibility(8);
      }
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      AbsCommonWebActivity.h1(AbsCommonWebActivity.this, true);
      if ((AbsCommonWebActivity.i1(AbsCommonWebActivity.this) != null) && (AbsCommonWebActivity.j1(AbsCommonWebActivity.this) != null))
      {
        AbsCommonWebActivity.i1(AbsCommonWebActivity.this).setVisibility(0);
        AbsCommonWebActivity.j1(AbsCommonWebActivity.this).setVisibility(8);
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
        if (AbsCommonWebActivity.e1(AbsCommonWebActivity.this) == null)
        {
          paramString = new TPMaterialDialogV2.Builder(AbsCommonWebActivity.this);
          AbsCommonWebActivity.f1(AbsCommonWebActivity.this, paramString.k(paramWebView.substring(4), 2131099937).l(2131952391, 2131099804, null).o(2131952680, 2131099808, new a(paramWebView)).g(8, 8).a());
        }
        AbsCommonWebActivity.e1(AbsCommonWebActivity.this).show();
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
        AbsCommonWebActivity.this.startActivity(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\about\AbsCommonWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */