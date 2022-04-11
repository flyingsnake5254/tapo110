package com.tplink.iot.view.feedback;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import b.d.w.c.a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.about.d;
import com.tplink.iot.widget.viewgroup.AutoScrolledWebView;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class HelpAndFeedbackActivity
  extends BaseActivity
{
  private String H3;
  @BindView
  TextView mFeedback;
  @BindView
  AutoScrolledWebView mFeedbackWebView;
  @BindView
  ProgressBar mLoadingProgress;
  @BindView
  View mRefreshLayout;
  private boolean p0 = false;
  private String p1 = "";
  private String p2 = "";
  private String p3;
  private MenuItem y = null;
  private boolean z;
  
  private void g1()
  {
    if (this.mFeedbackWebView.canGoBack()) {
      this.mFeedbackWebView.goBack();
    } else {
      finish();
    }
  }
  
  private void h1()
  {
    if (getIntent() != null)
    {
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null)
      {
        this.p0 = localBundle.getBoolean("help_feed_back_device_setup_fail_flag");
        this.p1 = localBundle.getString("help_feed_back_device_faq_url", "");
        this.p2 = localBundle.getString("help_feed_back_device_name", "");
        this.p3 = localBundle.getString("help_feed_back_device_type", EnumDeviceType.UNKNOWN.getDeviceType());
        this.H3 = localBundle.getString("help_feed_back_feedback_category", "");
      }
    }
    if (TextUtils.isEmpty(this.H3)) {
      this.H3 = EnumFeedbackCategory.fromDeviceType(this.p3).getValue();
    }
  }
  
  @SuppressLint({"JavascriptInterface"})
  private void i1()
  {
    c1(this.p2);
    this.mLoadingProgress.setMax(100);
    this.mLoadingProgress.setVisibility(0);
    this.mRefreshLayout.setVisibility(8);
    j1();
    this.mFeedbackWebView.setWebViewClient(new c(null));
    this.mFeedbackWebView.setWebChromeClient(new b(null));
  }
  
  private void j1()
  {
    this.mFeedbackWebView.getSettings().setJavaScriptEnabled(true);
    this.mFeedbackWebView.getSettings().setDefaultTextEncodingName("UTF-8");
    this.mFeedbackWebView.getSettings().setAllowFileAccess(true);
    this.mFeedbackWebView.getSettings().setAllowFileAccessFromFileURLs(true);
    this.mFeedbackWebView.getSettings().setAllowContentAccess(true);
    this.mFeedbackWebView.getSettings().setDomStorageEnabled(true);
    this.mFeedbackWebView.getSettings().setAppCacheEnabled(false);
    this.mFeedbackWebView.getSettings().setCacheMode(2);
    this.mFeedbackWebView.getSettings().setSupportZoom(false);
    this.mFeedbackWebView.getSettings().setBuiltInZoomControls(false);
    this.mFeedbackWebView.setLayerType(1, null);
  }
  
  public static void k1(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EnumFeedbackCategory paramEnumFeedbackCategory)
  {
    Intent localIntent = new Intent(paramContext, HelpAndFeedbackActivity.class);
    localIntent.putExtra("help_feed_back_device_faq_url", paramString1);
    localIntent.putExtra("help_feed_back_device_name", paramString2);
    localIntent.putExtra("help_feed_back_device_type", paramString3);
    localIntent.putExtra("help_feed_back_device_model", paramString4);
    localIntent.putExtra("help_feed_back_feedback_category", paramEnumFeedbackCategory.getValue());
    paramContext.startActivity(localIntent);
  }
  
  public static void l1(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(paramContext, HelpAndFeedbackActivity.class);
    localIntent.putExtra("help_feed_back_device_setup_fail_flag", true);
    localIntent.putExtra("help_feed_back_device_faq_url", paramString1);
    localIntent.putExtra("help_feed_back_device_name", paramString2);
    localIntent.putExtra("help_feed_back_device_type", paramString3);
    localIntent.putExtra("help_feed_back_device_model", paramString4);
    paramContext.startActivity(localIntent);
  }
  
  public static void m1(Context paramContext, String paramString1, String paramString2, EnumFeedbackCategory paramEnumFeedbackCategory)
  {
    Intent localIntent = new Intent(paramContext, HelpAndFeedbackActivity.class);
    localIntent.putExtra("help_feed_back_device_faq_url", paramString1);
    localIntent.putExtra("help_feed_back_device_name", paramString2);
    localIntent.putExtra("help_feed_back_feedback_category", paramEnumFeedbackCategory.getValue());
    paramContext.startActivity(localIntent);
  }
  
  private void n1()
  {
    if (t0.g(this))
    {
      this.z = false;
      this.mLoadingProgress.setProgress(0);
      this.mLoadingProgress.setVisibility(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FAQ URL: ");
      localStringBuilder.append(this.p1);
      a.e("Feedback", localStringBuilder.toString());
      this.mFeedbackWebView.loadUrl(this.p1);
    }
    else
    {
      this.z = true;
      this.mRefreshLayout.setVisibility(0);
      this.mFeedbackWebView.setVisibility(8);
      this.mLoadingProgress.setVisibility(8);
    }
  }
  
  @OnClick
  void gotoSelectFeedbackDeviceActivity()
  {
    Intent localIntent = new Intent(this, SelectFeedbackDeviceActivity.class);
    localIntent.putExtra("help_feed_back_device_type", this.p3);
    localIntent.putExtra("help_feed_back_feedback_category", this.H3);
    String str = d.a();
    if (this.p0)
    {
      localIntent.setClass(this, FeedBackWebActivity.class);
      localIntent.putExtra("feed_back_faq_params", d.c(this, null, this.p2));
    }
    else if ((this.p1.startsWith("https://www.tapo.com/app/#/faqList2?categoryType=")) && (this.p1.contains(str)))
    {
      localIntent.putExtra("help_feed_back_total_product_type", this.p1.replace(str, "").substring(49));
    }
    else
    {
      localIntent.putExtra("help_feed_back_total_product_type", "");
    }
    startActivity(localIntent);
  }
  
  public void onBackPressed()
  {
    g1();
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558537);
    ButterKnife.a(this);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    h1();
    i1();
    n1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623938, paramMenu);
    paramMenu = paramMenu.findItem(2131362297);
    this.y = paramMenu;
    paramMenu.setVisible(false);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (o.a() == 0) {
      return;
    }
    AutoScrolledWebView localAutoScrolledWebView = this.mFeedbackWebView;
    if (localAutoScrolledWebView != null)
    {
      localAutoScrolledWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
      this.mFeedbackWebView.clearHistory();
      ((ViewGroup)this.mFeedbackWebView.getParent()).removeView(this.mFeedbackWebView);
      this.mFeedbackWebView.destroy();
      this.mFeedbackWebView = null;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i != 16908332)
    {
      if (i != 2131362297) {
        return super.onOptionsItemSelected(paramMenuItem);
      }
      finish();
      return true;
    }
    g1();
    return false;
  }
  
  @OnClick
  void refreshLayout()
  {
    n1();
  }
  
  private class b
    extends WebChromeClient
  {
    private b() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        HelpAndFeedbackActivity.this.mLoadingProgress.setVisibility(8);
      } else {
        HelpAndFeedbackActivity.this.mLoadingProgress.setProgress(paramInt);
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
      if (HelpAndFeedbackActivity.e1(HelpAndFeedbackActivity.this) != null)
      {
        paramString = HelpAndFeedbackActivity.e1(HelpAndFeedbackActivity.this);
        paramWebView = HelpAndFeedbackActivity.this.mFeedbackWebView;
        boolean bool;
        if ((paramWebView != null) && (paramWebView.canGoBack())) {
          bool = true;
        } else {
          bool = false;
        }
        paramString.setVisible(bool);
      }
      if (!HelpAndFeedbackActivity.f1(HelpAndFeedbackActivity.this))
      {
        paramString = HelpAndFeedbackActivity.this;
        paramWebView = paramString.mRefreshLayout;
        if ((paramWebView != null) && (paramString.mFeedbackWebView != null))
        {
          paramWebView.setVisibility(8);
          HelpAndFeedbackActivity.this.mFeedbackWebView.setVisibility(0);
        }
      }
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" description: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" failingUrl: ");
      localStringBuilder.append(paramString2);
      a.e("HelpAndFeedback", localStringBuilder.toString());
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedError WebResourceRequest: ");
      localStringBuilder.append(l.g(paramWebResourceRequest));
      localStringBuilder.append(" WebResourceError: ");
      localStringBuilder.append(l.f(paramWebResourceError));
      a.e("HelpAndFeedback", localStringBuilder.toString());
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
    
    public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceivedHttpError WebResourceRequest: ");
      localStringBuilder.append(l.g(paramWebResourceRequest));
      a.e("HelpAndFeedback", localStringBuilder.toString());
      super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    }
    
    @RequiresApi(api=21)
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, final String paramString)
    {
      if (paramString.startsWith("tel:"))
      {
        new TPMaterialDialogV2.Builder(HelpAndFeedbackActivity.this).k(paramString.substring(4), 2131099937).l(2131952391, 2131099804, null).o(2131952680, 2131099808, new a(paramString)).g(8, 8).a().show();
        return true;
      }
      if (paramString.startsWith("mailto:"))
      {
        paramWebView = new Intent("android.intent.action.SENDTO");
        paramWebView.setData(Uri.parse(paramString));
        HelpAndFeedbackActivity.this.startActivity(paramWebView);
        return true;
      }
      HelpAndFeedbackActivity.this.mLoadingProgress.setProgress(0);
      HelpAndFeedbackActivity.this.mLoadingProgress.setVisibility(0);
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    
    class a
      implements TPMaterialDialogV2.d
    {
      a(String paramString) {}
      
      public void onClick(View paramView)
      {
        paramView = new Intent("android.intent.action.DIAL");
        paramView.setData(Uri.parse(paramString));
        HelpAndFeedbackActivity.this.startActivity(paramView);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\feedback\HelpAndFeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */