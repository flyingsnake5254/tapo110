package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tplink.libtpcontrols.s0;

public class PullToRefreshHorizontalScrollView
  extends PullToRefreshBase<HorizontalScrollView>
{
  public PullToRefreshHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected HorizontalScrollView K(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      paramContext = new a(paramContext, paramAttributeSet);
    } else {
      paramContext = new HorizontalScrollView(paramContext, paramAttributeSet);
    }
    paramContext.setId(s0.scrollview);
    return paramContext;
  }
  
  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.HORIZONTAL;
  }
  
  protected boolean p()
  {
    Object localObject = (HorizontalScrollView)this.H3;
    boolean bool1 = false;
    localObject = ((HorizontalScrollView)localObject).getChildAt(0);
    boolean bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((HorizontalScrollView)this.H3).getScrollX() >= ((View)localObject).getWidth() - getWidth()) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  protected boolean q()
  {
    boolean bool;
    if (((HorizontalScrollView)this.H3).getScrollX() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @TargetApi(9)
  final class a
    extends HorizontalScrollView
  {
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private int a()
    {
      int i = getChildCount();
      int j = 0;
      if (i > 0) {
        j = Math.max(0, getChildAt(0).getWidth() - (getWidth() - getPaddingLeft() - getPaddingRight()));
      }
      return j;
    }
    
    protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      f.c(PullToRefreshHorizontalScrollView.this, paramInt1, paramInt3, paramInt2, paramInt4, a(), paramBoolean);
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\PullToRefreshHorizontalScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */