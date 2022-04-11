package b.d.n.g;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import b.d.n.a;
import b.d.n.b;
import b.d.n.c;

public class e
  extends Dialog
  implements View.OnClickListener
{
  private static final String c = e.class.getSimpleName();
  private TextView d;
  private ProgressBar f;
  private LinearLayout q;
  private WebView x;
  
  public e(@NonNull Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    setContentView(b.layout_web);
    h();
    f(paramString);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
  }
  
  public e(@NonNull Context paramContext, String paramString)
  {
    this(paramContext, c.CustomDialog, paramString);
  }
  
  private void f(String paramString)
  {
    this.d = ((TextView)findViewById(a.tv_dialog_title));
    findViewById(a.tv_dialog_close).setOnClickListener(this);
    findViewById(a.tv_dialog_back).setOnClickListener(this);
    this.f = ((ProgressBar)findViewById(a.pb));
    this.q = ((LinearLayout)findViewById(a.ll_network_error));
    Object localObject = (WebView)findViewById(a.wv);
    this.x = ((WebView)localObject);
    localObject = ((WebView)localObject).getSettings();
    ((WebSettings)localObject).setDefaultTextEncodingName("UTF-8");
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      ((WebSettings)localObject).setMixedContentMode(2);
    }
    if (i >= 19) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    this.x.setWebChromeClient(new a());
    this.x.setWebViewClient(new b());
    this.x.loadUrl(paramString);
  }
  
  private void g(int paramInt)
  {
    int i = 100;
    if (paramInt == 100) {
      this.f.setVisibility(8);
    } else {
      this.f.setVisibility(0);
    }
    int j = paramInt;
    if (paramInt < 10) {
      j = 10;
    }
    if (j > 100) {
      paramInt = i;
    } else {
      paramInt = j;
    }
    this.f.setProgress(paramInt);
  }
  
  private void h()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.setWindowAnimations(c.DialogBottomTranslate);
      localWindow.setGravity(80);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == a.tv_dialog_close)
    {
      dismiss();
    }
    else if (paramView.getId() == a.tv_dialog_back)
    {
      paramView = this.x;
      if ((paramView != null) && (paramView.canGoBack())) {
        this.x.goBack();
      } else {
        dismiss();
      }
    }
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      super.onProgressChanged(paramWebView, paramInt);
      e.d(e.this, paramInt);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if ((paramString != null) && (!paramString.contains("error")) && (!paramString.contains("Error")) && (!paramString.contains("http"))) {
        e.e(e.this).setText(paramString);
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
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramWebView = new StringBuilder();
        paramWebView.append(e.a());
        paramWebView.append(" onReceivedError:");
        paramWebView.append(paramString1);
        b.d.n.j.e.a(paramWebView.toString());
      }
      e.b(e.this).setVisibility(0);
      e.c(e.this).setVisibility(8);
    }
    
    public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */