package com.tplink.iot.view.tapocare;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import b.d.w.c.a;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.base.BaseActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class TrialFragment
  extends Fragment
  implements k, View.OnClickListener
{
  private static final String c = TrialFragment.class.getSimpleName();
  private Toolbar d;
  private TextView f;
  private View p0;
  private boolean p1 = true;
  private String p2;
  private String p3 = e.j();
  private TextView q;
  private ProgressBar x;
  private WebView y;
  private View z;
  
  private void K0(View paramView)
  {
    this.d = ((Toolbar)paramView.findViewById(2131364275));
    Object localObject = paramView.findViewById(2131363284);
    Toolbar localToolbar = this.d;
    boolean bool = this.p1;
    int i = 8;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    localToolbar.setVisibility(j);
    if (this.p1) {
      j = i;
    } else {
      j = 0;
    }
    ((View)localObject).setVisibility(j);
    this.f = ((TextView)paramView.findViewById(2131364290));
    this.q = ((TextView)paramView.findViewById(2131364422));
    paramView.findViewById(2131364420).setOnClickListener(this);
    localObject = paramView.findViewById(2131363035);
    this.p0 = ((View)localObject);
    ((View)localObject).setOnClickListener(this);
    this.x = ((ProgressBar)paramView.findViewById(2131363622));
    localObject = (WebView)paramView.findViewById(2131364868);
    this.y = ((WebView)localObject);
    localObject = ((WebView)localObject).getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    ((WebSettings)localObject).setDefaultTextEncodingName("UTF-8");
    ((WebSettings)localObject).setBlockNetworkImage(true);
    if (Build.VERSION.SDK_INT >= 21) {
      ((WebSettings)localObject).setMixedContentMode(2);
    }
    this.y.setWebChromeClient(new c());
    this.y.setWebViewClient(new d());
    this.y.addJavascriptInterface(new a(), "backToApp");
    this.y.addJavascriptInterface(new b(), "exitIntro");
    this.z = paramView.findViewById(2131363311);
    paramView.findViewById(2131364608).setOnClickListener(new j(this));
    Q0(10);
    this.y.setVisibility(0);
  }
  
  public static TrialFragment O0(boolean paramBoolean, String paramString)
  {
    TrialFragment localTrialFragment = new TrialFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("full_screen", paramBoolean);
    localBundle.putString("url", paramString);
    localTrialFragment.setArguments(localBundle);
    return localTrialFragment;
  }
  
  private void P0()
  {
    this.y.reload();
    this.y.setVisibility(0);
    this.z.setVisibility(8);
  }
  
  private void Q0(int paramInt)
  {
    if (paramInt < 10) {
      this.x.setProgress(10);
    } else {
      this.x.setProgress(paramInt);
    }
    if (paramInt == 100) {
      this.x.setVisibility(8);
    } else if (this.x.getVisibility() != 0) {
      this.x.setVisibility(0);
    }
  }
  
  public void R0(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (this.p1)
    {
      this.d.setTitle("");
      this.f.setText(str);
    }
    else
    {
      this.q.setText(str);
    }
  }
  
  public boolean d()
  {
    WebView localWebView = this.y;
    if ((localWebView != null) && (localWebView.canGoBack()))
    {
      this.y.goBack();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363035)
    {
      if (i == 2131364420)
      {
        paramView = getActivity();
        if ((paramView instanceof BaseActivity))
        {
          ((BaseActivity)paramView).finish();
          paramView.overridePendingTransition(0, 2130772064);
        }
      }
    }
    else {
      d();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.p1 = paramBundle.getBoolean("full_screen", true);
      this.p2 = paramBundle.getString("url");
    }
    if (!TextUtils.isEmpty(this.p2)) {
      this.p3 = this.p2;
    }
    Log.e("WebsiteUrl", this.p3);
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558856, paramViewGroup, false);
    K0(paramLayoutInflater);
    this.y.loadUrl(this.p3);
    return paramLayoutInflater;
  }
  
  public class a
  {
    public a() {}
    
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
            localObject = TrialFragment.this.getActivity().getWindow().getDecorView();
            paramString = new com/tplink/iot/view/tapocare/i;
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
  
  public class b
  {
    public b() {}
    
    @JavascriptInterface
    public void postMessage()
    {
      if (TrialFragment.this.getActivity() != null) {
        TrialFragment.this.getActivity().finish();
      }
    }
  }
  
  public class c
    extends WebChromeClient
  {
    public c() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      String str = TrialFragment.A0();
      paramWebView = new StringBuilder();
      paramWebView.append("onProgressChanged:");
      paramWebView.append(paramInt);
      a.c(str, paramWebView.toString());
      TrialFragment.J0(TrialFragment.this, paramInt);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if ((paramString != null) && (!paramString.contains("error")) && (!paramString.contains("Error")) && (!paramString.contains("http"))) {
        TrialFragment.this.R0(paramString);
      }
    }
  }
  
  public class d
    extends WebViewClient
  {
    public d() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      Object localObject = TrialFragment.A0();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageFinished:");
      localStringBuilder.append(paramString);
      a.c((String)localObject, localStringBuilder.toString());
      if (!TrialFragment.B0(TrialFragment.this))
      {
        localObject = TrialFragment.G0(TrialFragment.this);
        int i;
        if (TrialFragment.C0(TrialFragment.this).canGoBack()) {
          i = 0;
        } else {
          i = 4;
        }
        ((View)localObject).setVisibility(i);
      }
      if (Uri.decode(paramString).equals(TrialFragment.H0(TrialFragment.this))) {
        paramWebView.getSettings().setBlockNetworkImage(false);
      }
      TrialFragment.C0(TrialFragment.this).setVisibility(0);
      TrialFragment.I0(TrialFragment.this).setVisibility(8);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      paramWebView = TrialFragment.A0();
      paramBitmap = new StringBuilder();
      paramBitmap.append("onPageStarted:");
      paramBitmap.append(paramString);
      a.c(paramWebView, paramBitmap.toString());
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWebView = TrialFragment.A0();
        paramWebResourceRequest = new StringBuilder();
        paramWebResourceRequest.append("onReceivedError:");
        paramWebResourceRequest.append(paramWebResourceError.getDescription());
        a.c(paramWebView, paramWebResourceRequest.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\tapocare\TrialFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */