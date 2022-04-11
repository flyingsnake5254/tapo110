package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.j;

public final class AutoScrolledWebView
  extends WebView
{
  private int c;
  private final HashMap<String, Integer> d = new HashMap();
  private WebViewClient f;
  private WebChromeClient q;
  private String x;
  private String y;
  private AutoScrolledStrategy z = AutoScrolledStrategy.FIRST_ONLY;
  
  public AutoScrolledWebView(Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  public AutoScrolledWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  public AutoScrolledWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (Build.VERSION.SDK_INT >= 23) {
      setOnScrollChangeListener(new a(this));
    }
    super.setWebViewClient(new c());
    super.setWebChromeClient(new b());
  }
  
  private final void i(int paramInt)
  {
    Object localObject = this.z;
    int i = a.a[localObject.ordinal()];
    if (i != 2)
    {
      if (i == 3)
      {
        localObject = this.x;
        if ((localObject != null) && (j.a(localObject, getOriginalUrl()))) {
          this.c = paramInt;
        }
      }
    }
    else {
      this.c = paramInt;
    }
  }
  
  private final int j(String paramString)
  {
    int i = 0;
    int j = i;
    if (paramString != null)
    {
      paramString = (Integer)this.d.get(paramString);
      if (paramString == null) {
        paramString = Integer.valueOf(0);
      }
      j = i;
      if (paramString != null) {
        j = paramString.intValue();
      }
    }
    return j;
  }
  
  private final void k(String paramString)
  {
    if (paramString != null) {
      this.d.put(paramString, Integer.valueOf(this.c));
    }
  }
  
  private final void l()
  {
    String str = this.y;
    if (str != null)
    {
      AutoScrolledStrategy localAutoScrolledStrategy = this.z;
      if (localAutoScrolledStrategy == AutoScrolledStrategy.ALL) {
        k(str);
      } else if ((localAutoScrolledStrategy == AutoScrolledStrategy.FIRST_ONLY) && (j.a(str, this.x))) {
        k(str);
      }
    }
  }
  
  private final void m(String paramString)
  {
    if (paramString != null)
    {
      int i = j(paramString);
      this.c = i;
      scrollTo(0, i);
    }
  }
  
  private final void n(String paramString)
  {
    Object localObject = this.z;
    int i = a.b[localObject.ordinal()];
    if (i != 2)
    {
      if (i == 3)
      {
        localObject = this.x;
        if ((localObject != null) && (j.a(localObject, paramString))) {
          p(this, paramString, 0, 2, null);
        }
      }
    }
    else {
      p(this, paramString, 0, 2, null);
    }
  }
  
  private final void o(final String paramString, int paramInt)
  {
    postDelayed(new d(this, paramString), paramInt);
  }
  
  public final AutoScrolledStrategy getStrategy()
  {
    return this.z;
  }
  
  public void loadUrl(String paramString)
  {
    j.e(paramString, "url");
    super.loadUrl(paramString);
    this.x = paramString;
  }
  
  public final void setStrategy(AutoScrolledStrategy paramAutoScrolledStrategy)
  {
    j.e(paramAutoScrolledStrategy, "<set-?>");
    this.z = paramAutoScrolledStrategy;
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.q = paramWebChromeClient;
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    j.e(paramWebViewClient, "client");
    this.f = paramWebViewClient;
  }
  
  public static enum AutoScrolledStrategy
  {
    static
    {
      AutoScrolledStrategy localAutoScrolledStrategy1 = new AutoScrolledStrategy("NONE", 0);
      NONE = localAutoScrolledStrategy1;
      AutoScrolledStrategy localAutoScrolledStrategy2 = new AutoScrolledStrategy("ALL", 1);
      ALL = localAutoScrolledStrategy2;
      AutoScrolledStrategy localAutoScrolledStrategy3 = new AutoScrolledStrategy("FIRST_ONLY", 2);
      FIRST_ONLY = localAutoScrolledStrategy3;
      $VALUES = new AutoScrolledStrategy[] { localAutoScrolledStrategy1, localAutoScrolledStrategy2, localAutoScrolledStrategy3 };
    }
  }
  
  static final class a
    implements View.OnScrollChangeListener
  {
    a(AutoScrolledWebView paramAutoScrolledWebView) {}
    
    public final void onScrollChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AutoScrolledWebView.a(this.a, paramInt2);
    }
  }
  
  private final class b
    extends WebChromeClient
  {
    public b() {}
    
    public Bitmap getDefaultVideoPoster()
    {
      Object localObject = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localObject != null)
      {
        localObject = ((WebChromeClient)localObject).getDefaultVideoPoster();
        if (localObject != null) {}
      }
      else
      {
        localObject = super.getDefaultVideoPoster();
      }
      return (Bitmap)localObject;
    }
    
    public View getVideoLoadingProgressView()
    {
      Object localObject = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localObject != null)
      {
        localObject = ((WebChromeClient)localObject).getVideoLoadingProgressView();
        if (localObject != null) {}
      }
      else
      {
        localObject = super.getVideoLoadingProgressView();
      }
      return (View)localObject;
    }
    
    public void getVisitedHistory(ValueCallback<String[]> paramValueCallback)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.getVisitedHistory(paramValueCallback);
      }
    }
    
    public void onCloseWindow(WebView paramWebView)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onCloseWindow(paramWebView);
      }
    }
    
    public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onConsoleMessage(paramString1, paramInt, paramString2);
      }
    }
    
    public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onConsoleMessage(paramConsoleMessage);
      } else {
        bool = super.onConsoleMessage(paramConsoleMessage);
      }
      return bool;
    }
    
    public boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        paramBoolean1 = localWebChromeClient.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
      } else {
        paramBoolean1 = super.onCreateWindow(paramWebView, paramBoolean1, paramBoolean2, paramMessage);
      }
      return paramBoolean1;
    }
    
    public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramQuotaUpdater);
      } else {
        super.onExceededDatabaseQuota(paramString1, paramString2, paramLong1, paramLong2, paramLong3, paramQuotaUpdater);
      }
    }
    
    public void onGeolocationPermissionsHidePrompt()
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onGeolocationPermissionsHidePrompt();
      }
    }
    
    public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
      }
    }
    
    public void onHideCustomView()
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onHideCustomView();
      }
    }
    
    public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
      } else {
        bool = super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
      }
      return bool;
    }
    
    public boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
      } else {
        bool = super.onJsBeforeUnload(paramWebView, paramString1, paramString2, paramJsResult);
      }
      return bool;
    }
    
    public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
      } else {
        bool = super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
      }
      return bool;
    }
    
    public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
      } else {
        bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
      }
      return bool;
    }
    
    public boolean onJsTimeout()
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onJsTimeout();
      } else {
        bool = super.onJsTimeout();
      }
      return bool;
    }
    
    public void onPermissionRequest(PermissionRequest paramPermissionRequest)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onPermissionRequest(paramPermissionRequest);
      } else {
        super.onPermissionRequest(paramPermissionRequest);
      }
    }
    
    public void onPermissionRequestCanceled(PermissionRequest paramPermissionRequest)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onPermissionRequestCanceled(paramPermissionRequest);
      }
    }
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100)
      {
        AutoScrolledWebView localAutoScrolledWebView = AutoScrolledWebView.this;
        if (paramWebView != null) {
          localObject = paramWebView.getOriginalUrl();
        } else {
          localObject = null;
        }
        AutoScrolledWebView.g(localAutoScrolledWebView, (String)localObject);
      }
      Object localObject = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localObject != null) {
        ((WebChromeClient)localObject).onProgressChanged(paramWebView, paramInt);
      }
    }
    
    public void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onReachedMaxAppCacheSize(paramLong1, paramLong2, paramQuotaUpdater);
      } else {
        super.onReachedMaxAppCacheSize(paramLong1, paramLong2, paramQuotaUpdater);
      }
    }
    
    public void onReceivedIcon(WebView paramWebView, Bitmap paramBitmap)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onReceivedIcon(paramWebView, paramBitmap);
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onReceivedTitle(paramWebView, paramString);
      }
    }
    
    public void onReceivedTouchIconUrl(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onReceivedTouchIconUrl(paramWebView, paramString, paramBoolean);
      }
    }
    
    public void onRequestFocus(WebView paramWebView)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onRequestFocus(paramWebView);
      }
    }
    
    public void onShowCustomView(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onShowCustomView(paramView, paramInt, paramCustomViewCallback);
      }
    }
    
    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      if (localWebChromeClient != null) {
        localWebChromeClient.onShowCustomView(paramView, paramCustomViewCallback);
      }
    }
    
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      WebChromeClient localWebChromeClient = AutoScrolledWebView.c(AutoScrolledWebView.this);
      boolean bool;
      if (localWebChromeClient != null) {
        bool = localWebChromeClient.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
      } else {
        bool = super.onShowFileChooser(paramWebView, paramValueCallback, paramFileChooserParams);
      }
      return bool;
    }
  }
  
  private final class c
    extends WebViewClient
  {
    public c() {}
    
    public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
      }
    }
    
    public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
      } else {
        super.onFormResubmission(paramWebView, paramMessage1, paramMessage2);
      }
    }
    
    public void onLoadResource(WebView paramWebView, String paramString)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onLoadResource(paramWebView, paramString);
      }
    }
    
    @RequiresApi(23)
    public void onPageCommitVisible(WebView paramWebView, String paramString)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onPageCommitVisible(paramWebView, paramString);
      }
    }
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onPageFinished(paramWebView, paramString);
      }
      if ((paramString != null) && ((j.a(AutoScrolledWebView.b(AutoScrolledWebView.this), paramString) ^ true))) {
        AutoScrolledWebView.e(AutoScrolledWebView.this);
      }
      AutoScrolledWebView.h(AutoScrolledWebView.this, paramString);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onPageStarted(paramWebView, paramString, paramBitmap);
      }
    }
    
    public void onReceivedClientCertRequest(WebView paramWebView, ClientCertRequest paramClientCertRequest)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
      } else {
        super.onReceivedClientCertRequest(paramWebView, paramClientCertRequest);
      }
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      }
    }
    
    @RequiresApi(23)
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      } else {
        super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      }
    }
    
    public void onReceivedHttpAuthRequest(WebView paramWebView, HttpAuthHandler paramHttpAuthHandler, String paramString1, String paramString2)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
      } else {
        super.onReceivedHttpAuthRequest(paramWebView, paramHttpAuthHandler, paramString1, paramString2);
      }
    }
    
    @RequiresApi(23)
    public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      }
    }
    
    public void onReceivedLoginRequest(WebView paramWebView, String paramString1, String paramString2, String paramString3)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedLoginRequest(paramWebView, paramString1, paramString2, paramString3);
      }
    }
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      } else {
        super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      }
    }
    
    @RequiresApi(26)
    public boolean onRenderProcessGone(WebView paramWebView, RenderProcessGoneDetail paramRenderProcessGoneDetail)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      boolean bool;
      if (localWebViewClient != null) {
        bool = localWebViewClient.onRenderProcessGone(paramWebView, paramRenderProcessGoneDetail);
      } else {
        bool = super.onRenderProcessGone(paramWebView, paramRenderProcessGoneDetail);
      }
      return bool;
    }
    
    @RequiresApi(27)
    public void onSafeBrowsingHit(WebView paramWebView, WebResourceRequest paramWebResourceRequest, int paramInt, SafeBrowsingResponse paramSafeBrowsingResponse)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onSafeBrowsingHit(paramWebView, paramWebResourceRequest, paramInt, paramSafeBrowsingResponse);
      } else {
        super.onSafeBrowsingHit(paramWebView, paramWebResourceRequest, paramInt, paramSafeBrowsingResponse);
      }
    }
    
    public void onScaleChanged(WebView paramWebView, float paramFloat1, float paramFloat2)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onScaleChanged(paramWebView, paramFloat1, paramFloat2);
      }
    }
    
    public void onTooManyRedirects(WebView paramWebView, Message paramMessage1, Message paramMessage2)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
      } else {
        super.onTooManyRedirects(paramWebView, paramMessage1, paramMessage2);
      }
    }
    
    public void onUnhandledKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localWebViewClient != null) {
        localWebViewClient.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
      } else {
        super.onUnhandledKeyEvent(paramWebView, paramKeyEvent);
      }
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      Object localObject = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localObject != null)
      {
        localObject = ((WebViewClient)localObject).shouldInterceptRequest(paramWebView, paramWebResourceRequest);
        if (localObject != null) {
          return (WebView)localObject;
        }
      }
      paramWebView = super.shouldInterceptRequest(paramWebView, paramWebResourceRequest);
      return paramWebView;
    }
    
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      Object localObject = AutoScrolledWebView.d(AutoScrolledWebView.this);
      if (localObject != null)
      {
        localObject = ((WebViewClient)localObject).shouldInterceptRequest(paramWebView, paramString);
        if (localObject != null) {
          return (WebView)localObject;
        }
      }
      paramWebView = super.shouldInterceptRequest(paramWebView, paramString);
      return paramWebView;
    }
    
    public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      boolean bool;
      if (localWebViewClient != null) {
        bool = localWebViewClient.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
      } else {
        bool = super.shouldOverrideKeyEvent(paramWebView, paramKeyEvent);
      }
      return bool;
    }
    
    @RequiresApi(24)
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      boolean bool;
      if (localWebViewClient != null) {
        bool = localWebViewClient.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
      } else {
        bool = super.shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest);
      }
      return bool;
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      WebViewClient localWebViewClient = AutoScrolledWebView.d(AutoScrolledWebView.this);
      boolean bool;
      if (localWebViewClient != null) {
        bool = localWebViewClient.shouldOverrideUrlLoading(paramWebView, paramString);
      } else {
        bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      return bool;
    }
  }
  
  static final class d
    implements Runnable
  {
    d(AutoScrolledWebView paramAutoScrolledWebView, String paramString) {}
    
    public final void run()
    {
      AutoScrolledWebView.f(this.c, paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\AutoScrolledWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */