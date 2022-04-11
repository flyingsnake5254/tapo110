package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.android.billingclient.api.Purchase;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.viewmodel.billing.BillingViewModel;
import io.reactivex.q;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class BillingFragment
  extends Fragment
  implements k, View.OnClickListener
{
  private static final String c = BillingFragment.class.getSimpleName();
  private String H3 = com.tplink.iot.Utils.v0.e.x();
  private long I3;
  private int J3 = 100;
  private boolean K3 = false;
  private String L3;
  private BillingViewModel d;
  private Toolbar f;
  private View p0;
  private View p1;
  private boolean p2 = true;
  private boolean p3 = false;
  private TextView q;
  private TextView x;
  private ProgressBar y;
  private WebView z;
  
  private void R0()
  {
    this.d.n().observe(this, new a(this));
    this.d.r().observe(this, new h(this));
    this.d.p().observe(this, new b(this));
    this.d.s().observe(this, new e(this));
    this.d.u().observe(this, new f(this));
    this.d.t().observe(this, new g(this));
  }
  
  private void S0()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof BaseActivity))
    {
      ((BaseActivity)localFragmentActivity).finish();
      localFragmentActivity.overridePendingTransition(0, 2130772064);
    }
  }
  
  private void T0(Integer paramInteger)
  {
    String str = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handlePurchaseEvent:");
    Object localObject;
    if (paramInteger == null) {
      localObject = "null";
    } else {
      localObject = paramInteger;
    }
    localStringBuilder.append(localObject);
    b.d.w.c.a.c(str, localStringBuilder.toString());
    if (paramInteger == null) {
      return;
    }
    switch (paramInteger.intValue())
    {
    default: 
      break;
    case 1006: 
      s0.p(getActivity(), getString(2131954250));
      break;
    case 1005: 
      s0.p(getActivity(), getString(2131954248));
      break;
    case 1004: 
      s0.p(getActivity(), getString(2131954249));
      break;
    case 1003: 
      s0.p(getActivity(), getString(2131954252));
      break;
    case 1002: 
      s0.p(getActivity(), getString(2131954255));
      break;
    case 1001: 
    case 1007: 
      s0.p(getActivity(), getString(2131954253));
    }
    if (paramInteger.intValue() != 0) {
      w.D(paramInteger.toString());
    }
  }
  
  private void U0(List<Purchase> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Purchase localPurchase = (Purchase)localIterator.next();
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("queryPurchase:");
        localStringBuilder.append(localPurchase.toString());
        b.d.w.c.a.c(str, localStringBuilder.toString());
      }
    }
    this.d.j(paramList);
  }
  
  private void V0(List<Purchase> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Purchase localPurchase = (Purchase)localIterator.next();
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PurchaseUpdate:");
        localStringBuilder.append(localPurchase.toString());
        b.d.w.c.a.c(str, localStringBuilder.toString());
      }
    }
    this.d.h(paramList);
  }
  
  private void W0(Integer paramInteger)
  {
    if (paramInteger == null) {
      return;
    }
    this.J3 = paramInteger.intValue();
    this.K3 = true;
    int i = paramInteger.intValue();
    if (i != 65236)
    {
      if (i != 65336)
      {
        if (i == 100)
        {
          if (this.p3) {
            this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", new Object[] { Integer.valueOf(0), this.d.o() }));
          }
          b.d.w.c.a.c(c, "SubscriptionState.VERIFICATION_SUCCESS");
        }
      }
      else
      {
        if (this.p3) {
          this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", new Object[] { Integer.valueOf(-1), "" }));
        }
        b.d.w.c.a.c(c, "SubscriptionState.VERIFICATION_ERROR");
      }
    }
    else
    {
      if (this.p3) {
        this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", new Object[] { Integer.valueOf(-1), "" }));
      }
      b.d.w.c.a.c(c, "SubscriptionState.ACKNOWLEDGEMENT_ERROR");
    }
  }
  
  private void X0(String paramString)
  {
    this.L3 = paramString;
    if ((paramString != null) && (this.p3))
    {
      b.d.w.c.a.c(c, paramString);
      this.z.loadUrl(paramString);
      this.z.setVisibility(0);
    }
  }
  
  private void Y0(View paramView)
  {
    this.f = ((Toolbar)paramView.findViewById(2131364275));
    Object localObject = paramView.findViewById(2131363284);
    Toolbar localToolbar = this.f;
    boolean bool = this.p2;
    int i = 8;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    localToolbar.setVisibility(j);
    if (this.p2) {
      j = i;
    } else {
      j = 0;
    }
    ((View)localObject).setVisibility(j);
    this.q = ((TextView)paramView.findViewById(2131364290));
    this.x = ((TextView)paramView.findViewById(2131364422));
    this.f.setTitle("");
    paramView.findViewById(2131364420).setOnClickListener(this);
    localObject = paramView.findViewById(2131363035);
    this.p1 = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.y = ((ProgressBar)paramView.findViewById(2131363622));
    localObject = (WebView)paramView.findViewById(2131364868);
    this.z = ((WebView)localObject);
    localObject = ((WebView)localObject).getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setDefaultTextEncodingName("UTF-8");
    ((WebSettings)localObject).setBlockNetworkImage(true);
    int j = Build.VERSION.SDK_INT;
    if (j >= 21) {
      ((WebSettings)localObject).setMixedContentMode(2);
    }
    if (j >= 19) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    this.z.setWebChromeClient(new a());
    this.z.setWebViewClient(new b());
    this.z.addJavascriptInterface(new f(), "purchase");
    this.z.addJavascriptInterface(new c(), "backToApp");
    this.z.addJavascriptInterface(new g(), "upgradeHardware");
    this.z.addJavascriptInterface(new d(), "loadAppProductList");
    this.z.addJavascriptInterface(new e(), "openBrowser");
    this.p0 = paramView.findViewById(2131363311);
    paramView.findViewById(2131364608).setOnClickListener(new c(this));
    l1(10);
    this.z.setVisibility(0);
  }
  
  public static BillingFragment h1(String paramString)
  {
    return i1(true, paramString);
  }
  
  public static BillingFragment i1(boolean paramBoolean, String paramString)
  {
    BillingFragment localBillingFragment = new BillingFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("full_screen", paramBoolean);
    localBundle.putString("url", paramString);
    localBillingFragment.setArguments(localBundle);
    return localBillingFragment;
  }
  
  private void j1()
  {
    if (this.L3 == null) {
      this.d.l0();
    } else {
      this.z.reload();
    }
    this.z.setVisibility(0);
    this.p0.setVisibility(8);
  }
  
  private void k1(Boolean paramBoolean)
  {
    if (paramBoolean != null) {
      if (paramBoolean.booleanValue()) {
        s0.l(getActivity());
      } else {
        s0.g();
      }
    }
  }
  
  private void l1(int paramInt)
  {
    this.y.setVisibility(8);
  }
  
  public boolean d()
  {
    if ((!this.K3) && (!this.z.getUrl().contains("tapolist")))
    {
      WebView localWebView = this.z;
      if ((localWebView != null) && (localWebView.canGoBack()))
      {
        this.z.goBack();
        return true;
      }
    }
    return false;
  }
  
  public void m1(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.p2) {
      this.q.setText(str);
    } else {
      this.x.setText(str);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363035)
    {
      if (i == 2131364420) {
        S0();
      }
    }
    else if ((!this.K3) && (!this.z.getUrl().contains("tapolist"))) {
      d();
    } else {
      S0();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.p2 = paramBundle.getBoolean("full_screen", true);
      this.H3 = paramBundle.getString("url");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = getActivity();
    Objects.requireNonNull(paramBundle);
    this.d = ((BillingViewModel)ViewModelProviders.of((FragmentActivity)paramBundle).get(BillingViewModel.class));
    paramLayoutInflater = paramLayoutInflater.inflate(2131558856, paramViewGroup, false);
    Y0(paramLayoutInflater);
    b.d.w.c.a.c(c, this.H3);
    this.z.loadUrl(this.H3);
    R0();
    return paramLayoutInflater;
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      paramWebView = BillingFragment.A0();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProgressChanged:");
      localStringBuilder.append(paramInt);
      b.d.w.c.a.c(paramWebView, localStringBuilder.toString());
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if ((paramString != null) && (!paramString.contains("error")) && (!paramString.contains("Error")) && (!paramString.contains("http")))
      {
        b.d.w.c.a.e(BillingFragment.A0(), paramString);
        BillingFragment.this.m1(paramString);
      }
    }
  }
  
  public class b
    extends WebViewClient
  {
    public b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      String str = BillingFragment.A0();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageFinished:");
      ((StringBuilder)localObject).append(paramString);
      b.d.w.c.a.c(str, ((StringBuilder)localObject).toString());
      if (!BillingFragment.I0(BillingFragment.this))
      {
        localObject = BillingFragment.K0(BillingFragment.this);
        int i;
        if (BillingFragment.J0(BillingFragment.this).canGoBack()) {
          i = 0;
        } else {
          i = 4;
        }
        ((View)localObject).setVisibility(i);
      }
      if (Uri.decode(paramString).equals(BillingFragment.L0(BillingFragment.this)))
      {
        paramWebView.getSettings().setBlockNetworkImage(false);
        BillingFragment.N0(BillingFragment.this, true);
        if (BillingFragment.O0(BillingFragment.this) != null)
        {
          BillingFragment.J0(BillingFragment.this).setVisibility(0);
          BillingFragment.P0(BillingFragment.this).setVisibility(8);
          BillingFragment.J0(BillingFragment.this).loadUrl(BillingFragment.O0(BillingFragment.this));
          b.d.w.c.a.c(BillingFragment.A0(), BillingFragment.O0(BillingFragment.this));
        }
      }
      BillingFragment.J0(BillingFragment.this).setVisibility(0);
      BillingFragment.P0(BillingFragment.this).setVisibility(8);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      paramBitmap = BillingFragment.A0();
      paramWebView = new StringBuilder();
      paramWebView.append("onPageStarted:");
      paramWebView.append(paramString);
      b.d.w.c.a.c(paramBitmap, paramWebView.toString());
      BillingFragment.C0(BillingFragment.this, System.currentTimeMillis());
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWebView = BillingFragment.A0();
        paramWebResourceRequest = new StringBuilder();
        paramWebResourceRequest.append("onReceivedError:");
        paramWebResourceRequest.append(paramWebResourceError.getDescription());
        b.d.w.c.a.c(paramWebView, paramWebResourceRequest.toString());
      }
    }
  }
  
  public class c
  {
    public c() {}
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      if (paramString != null) {
        try
        {
          Object localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = ((JSONObject)localObject).getString("message");
          if ((paramString != null) && ("done".equals(paramString)))
          {
            localObject = BillingFragment.this.getActivity().getWindow().getDecorView();
            paramString = new com/tplink/iot/view/tapocare/d;
            paramString.<init>(this);
            ((View)localObject).postDelayed(paramString, 500L);
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public class d
  {
    public d() {}
    
    @JavascriptInterface
    public void postMessage()
    {
      BillingFragment.G0(BillingFragment.this).l0();
    }
  }
  
  public class e
  {
    public e() {}
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      if ((BillingFragment.this.getActivity() != null) && (localIntent.resolveActivity(BillingFragment.this.getActivity().getPackageManager()) != null)) {
        BillingFragment.this.startActivity(localIntent);
      }
    }
  }
  
  public class f
  {
    public f() {}
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      Object localObject1;
      if (BillingFragment.Q0(BillingFragment.this))
      {
        paramString = BillingFragment.A0();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("retry:");
        ((StringBuilder)localObject1).append(BillingFragment.B0(BillingFragment.this));
        b.d.w.c.a.i(paramString, ((StringBuilder)localObject1).toString());
        if (BillingFragment.B0(BillingFragment.this) == 65236) {
          BillingFragment.G0(BillingFragment.this).m0().L0(io.reactivex.l0.a.c()).F0();
        } else if (BillingFragment.B0(BillingFragment.this) == 65336) {
          BillingFragment.G0(BillingFragment.this).n0().L0(io.reactivex.l0.a.c()).F0();
        } else if ((BillingFragment.B0(BillingFragment.this) == 100) && (BillingFragment.this.getActivity() != null)) {
          BillingFragment.this.getActivity().finish();
        }
      }
      else
      {
        Object localObject2 = BillingFragment.A0();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("purchase() is invoked by web with purchaseParamsJsonStr:");
        ((StringBuilder)localObject1).append(paramString);
        b.d.w.c.a.i((String)localObject2, ((StringBuilder)localObject1).toString());
        localObject2 = BillingFragment.G0(BillingFragment.this);
        localObject1 = BillingFragment.this.getActivity();
        Objects.requireNonNull(localObject1);
        ((BillingViewModel)localObject2).k((Activity)localObject1, paramString);
      }
    }
  }
  
  public class g
  {
    public g() {}
    
    @JavascriptInterface
    public void postMessage(String paramString)
    {
      FirmwareSlideActivity.q1(BillingFragment.this.getActivity(), "web");
      BillingFragment.H0(BillingFragment.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\tapocare\BillingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */