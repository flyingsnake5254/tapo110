package com.handmark.pulltorefresh.library.extras;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2
  extends PullToRefreshWebView
{
  private a Z3;
  private final AtomicBoolean a4 = new AtomicBoolean(false);
  private final AtomicBoolean b4 = new AtomicBoolean(false);
  
  public PullToRefreshWebView2(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshWebView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @SuppressLint({"JavascriptInterface"})
  protected WebView K(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = super.K(paramContext, paramAttributeSet);
    paramAttributeSet = new a();
    this.Z3 = paramAttributeSet;
    paramContext.addJavascriptInterface(paramAttributeSet, "ptr");
    return paramContext;
  }
  
  protected boolean p()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
    return this.b4.get();
  }
  
  protected boolean q()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
    return this.a4.get();
  }
  
  final class a
  {
    a() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\extras\PullToRefreshWebView2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */