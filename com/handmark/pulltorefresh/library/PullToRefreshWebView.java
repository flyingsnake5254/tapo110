package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tplink.libtpcontrols.s0;

public class PullToRefreshWebView
  extends PullToRefreshBase<WebView>
{
  private static final PullToRefreshBase.e<WebView> X3 = c.a;
  private final WebChromeClient Y3;
  
  public PullToRefreshWebView(Context paramContext)
  {
    super(paramContext);
    paramContext = new a();
    this.Y3 = paramContext;
    setOnRefreshListener(X3);
    ((WebView)this.H3).setWebChromeClient(paramContext);
  }
  
  public PullToRefreshWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = new a();
    this.Y3 = paramContext;
    setOnRefreshListener(X3);
    ((WebView)this.H3).setWebChromeClient(paramContext);
  }
  
  protected WebView K(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext = new b(paramContext, paramAttributeSet);
    } else {
      paramContext = new WebView(paramContext, paramAttributeSet);
    }
    paramContext.setId(s0.webview);
    return paramContext;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected boolean p()
  {
    float f = (float)Math.floor(((WebView)this.H3).getContentHeight() * ((WebView)this.H3).getScale());
    boolean bool;
    if (((WebView)this.H3).getScrollY() >= f - ((WebView)this.H3).getHeight()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected boolean q()
  {
    boolean bool;
    if (((WebView)this.H3).getScrollY() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected void t(Bundle paramBundle)
  {
    super.t(paramBundle);
    ((WebView)this.H3).restoreState(paramBundle);
  }
  
  protected void u(Bundle paramBundle)
  {
    super.u(paramBundle);
    ((WebView)this.H3).saveState(paramBundle);
  }
  
  class a
    extends WebChromeClient
  {
    a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        PullToRefreshWebView.this.w();
      }
    }
  }
  
  @TargetApi(9)
  final class b
    extends WebView
  {
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a()
    {
      return (int)Math.max(0.0D, Math.floor(((WebView)PullToRefreshWebView.this.H3).getContentHeight() * ((WebView)PullToRefreshWebView.this.H3).getScale()) - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      f.b(PullToRefreshWebView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), 2, 1.5F, paramBoolean);
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */