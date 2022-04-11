package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.tplink.libtpcontrols.s0;

public class PullToRefreshScrollView
  extends PullToRefreshBase<ScrollView>
{
  private d X3;
  private c Y3;
  
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    M();
  }
  
  private void M()
  {
    getHeaderLayout().getViewTreeObserver().addOnPreDrawListener(new a());
  }
  
  protected ScrollView L(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext = new b(paramContext, paramAttributeSet);
    } else {
      paramContext = new ScrollView(paramContext, paramAttributeSet);
    }
    paramContext.setId(s0.scrollview);
    return paramContext;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d locald = this.X3;
    if (locald != null) {
      locald.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected boolean p()
  {
    Object localObject = (ScrollView)this.H3;
    boolean bool1 = false;
    localObject = ((ScrollView)localObject).getChildAt(0);
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((ScrollView)this.H3).getScrollY() >= ((View)localObject).getHeight() - getHeight()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  protected boolean q()
  {
    boolean bool;
    if (((ScrollView)this.H3).getScrollY() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void setHeaderWheelBarColor(int paramInt)
  {
    getHeaderLayout().setHeaderWheelBarColor(paramInt);
  }
  
  public void setOnPullToRefreshReadyListener(c paramc)
  {
    this.Y3 = paramc;
  }
  
  public void setPullToRefreshScrollListener(d paramd)
  {
    this.X3 = paramd;
  }
  
  class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a() {}
    
    public boolean onPreDraw()
    {
      if (PullToRefreshScrollView.this.getHeaderLayout().getHeight() > 0)
      {
        if (PullToRefreshScrollView.K(PullToRefreshScrollView.this) != null) {
          PullToRefreshScrollView.K(PullToRefreshScrollView.this).a();
        }
        PullToRefreshScrollView.this.getHeaderLayout().getViewTreeObserver().removeOnPreDrawListener(this);
      }
      return true;
    }
  }
  
  @TargetApi(9)
  final class b
    extends ScrollView
  {
    public b(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a()
    {
      int i = getChildCount();
      int j = 0;
      if (i > 0) {
        j = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
      }
      return j;
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      f.c(PullToRefreshScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
  
  public static abstract interface d
  {
    public abstract void a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */