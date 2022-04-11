package com.tplink.iot.view.wss;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.wss.WssViewModel;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import org.apache.commons.lang.b;

public class WssAccountLinkWebActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private View p0;
  private WssViewModel p1;
  private boolean p2;
  private WebView y = null;
  private ProgressBar z = null;
  
  private void j1()
  {
    c1("");
    Object localObject = (ProgressBar)findViewById(2131364827);
    this.z = ((ProgressBar)localObject);
    ((ProgressBar)localObject).setMax(100);
    this.z.setVisibility(0);
    localObject = findViewById(2131364828);
    this.p0 = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.z.setProgress(0);
    localObject = (WebView)findViewById(2131363392);
    this.y = ((WebView)localObject);
    n1(((WebView)localObject).getSettings());
    this.y.setWebViewClient(new c(null));
    this.y.setWebChromeClient(new d(null));
  }
  
  private void k1(String paramString)
  {
    runOnUiThread(new b());
    SkillActiveParams localSkillActiveParams = new SkillActiveParams();
    localSkillActiveParams.setAmazonAuthCode(paramString);
    this.p1.h(localSkillActiveParams);
  }
  
  private void l1()
  {
    if (t0.g(this))
    {
      this.p2 = false;
      this.z.setProgress(0);
      this.z.setVisibility(0);
      this.p0.setVisibility(8);
      this.y.loadUrl("https://www.amazon.com/ap/oa?client_id=amzn1.application-oa2-client.06037d9eeed544e1b0490368ab295cae&scope=alexa::skills:account_linking%20frustration_free_setup::device:setup&redirect_uri=https://alexa-ffs.tplinknbu.com/v1/public/ffs/redirect/android&response_type=code&stage=live");
    }
    else
    {
      this.p2 = true;
      this.p0.setVisibility(0);
      this.y.setVisibility(8);
      this.z.setVisibility(8);
    }
  }
  
  private void m1()
  {
    this.p1.j().observe(this, new a());
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  private void n1(WebSettings paramWebSettings)
  {
    paramWebSettings.setJavaScriptEnabled(true);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364828) {
      l1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558716);
    this.p1 = ((WssViewModel)ViewModelProviders.of(this).get(WssViewModel.class));
    j1();
    l1();
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
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      
      if (b.b(paramBoolean))
      {
        WssAccountLinkWebActivity.this.setResult(-1);
        WssAccountLinkWebActivity.this.overridePendingTransition(2130772063, 2130772064);
        WssAccountLinkWebActivity.this.finish();
      }
      else if ((paramBoolean != null) && (!paramBoolean.booleanValue()))
      {
        s0.s(WssAccountLinkWebActivity.this, 2131952444);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      s0.l(WssAccountLinkWebActivity.this);
    }
  }
  
  private class c
    extends WebViewClient
  {
    private c() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if ((!WssAccountLinkWebActivity.f1(WssAccountLinkWebActivity.this)) && (WssAccountLinkWebActivity.g1(WssAccountLinkWebActivity.this) != null) && (WssAccountLinkWebActivity.h1(WssAccountLinkWebActivity.this) != null))
      {
        WssAccountLinkWebActivity.g1(WssAccountLinkWebActivity.this).setVisibility(8);
        WssAccountLinkWebActivity.h1(WssAccountLinkWebActivity.this).setVisibility(0);
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
      paramWebView = new StringBuilder();
      paramWebView.append(paramString);
      paramWebView.append("");
      a.e("url", paramWebView.toString());
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://alexa-ffs.tplinknbu.com/v1/public/ffs/redirect/android")) && (paramString.contains("code=")))
      {
        paramWebView = new StringBuilder();
        for (int i = paramString.indexOf("code=") + 5; (i < paramString.length()) && (paramString.charAt(i) != '&'); i++) {
          paramWebView.append(paramString.charAt(i));
        }
        paramString = paramWebView.toString();
        paramWebView = new StringBuilder();
        paramWebView.append(paramString);
        paramWebView.append(" ");
        a.e("wss_code", paramWebView.toString());
        WssAccountLinkWebActivity.e1(WssAccountLinkWebActivity.this, paramString);
        return true;
      }
      return false;
    }
  }
  
  private class d
    extends WebChromeClient
  {
    private d() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        WssAccountLinkWebActivity.i1(WssAccountLinkWebActivity.this).setVisibility(8);
      } else {
        WssAccountLinkWebActivity.i1(WssAccountLinkWebActivity.this).setProgress(paramInt);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\wss\WssAccountLinkWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */