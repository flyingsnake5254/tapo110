package com.tplink.iot.view.authflip;

import android.annotation.SuppressLint;
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
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.viewmodel.authflip.AppFlipAuthViewModel;
import java.util.Objects;

public class WebViewFragment
  extends BaseAppFlipFragment
{
  private WebView q = null;
  private ProgressBar x = null;
  private View y;
  private boolean z;
  
  private void J0()
  {
    setHasOptionsMenu(true);
    ((Toolbar)this.c.findViewById(2131364275)).setNavigationOnClickListener(new a());
    Object localObject = (ProgressBar)this.c.findViewById(2131364827);
    this.x = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    this.x.setVisibility(0);
    localObject = this.c.findViewById(2131364828);
    this.y = ((View)localObject);
    ((View)localObject).setOnClickListener(new f(this));
    this.x.setProgress(0);
    localObject = (WebView)this.c.findViewById(2131363392);
    this.q = ((WebView)localObject);
    O0(((WebView)localObject).getSettings());
    this.q.setWebViewClient(new b(null));
    this.q.setWebChromeClient(new c(null));
  }
  
  private void N0()
  {
    if (t0.g(getActivity()))
    {
      this.z = false;
      this.x.setProgress(0);
      this.x.setVisibility(0);
      this.y.setVisibility(8);
      this.q.loadUrl(this.f.w());
    }
    else
    {
      this.z = true;
      this.y.setVisibility(0);
      this.q.setVisibility(8);
      this.x.setVisibility(8);
    }
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void O0(WebSettings paramWebSettings)
  {
    paramWebSettings.setJavaScriptEnabled(true);
  }
  
  public int A0()
  {
    return 2131558990;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    J0();
    N0();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = WebViewFragment.this.getActivity();
      Objects.requireNonNull(paramView);
      ((FragmentActivity)paramView).onBackPressed();
    }
  }
  
  private class b
    extends WebViewClient
  {
    private b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((!WebViewFragment.C0(WebViewFragment.this)) && (WebViewFragment.G0(WebViewFragment.this) != null) && (WebViewFragment.H0(WebViewFragment.this) != null))
      {
        WebViewFragment.G0(WebViewFragment.this).setVisibility(8);
        WebViewFragment.H0(WebViewFragment.this).setVisibility(0);
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return false;
    }
  }
  
  private class c
    extends WebChromeClient
  {
    private c() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        WebViewFragment.I0(WebViewFragment.this).setVisibility(8);
      } else {
        WebViewFragment.I0(WebViewFragment.this).setProgress(paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\authflip\WebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */