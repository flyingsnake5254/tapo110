package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.LinearLayout;

@TargetApi(9)
public final class f
{
  static boolean a(View paramView)
  {
    boolean bool;
    if (paramView.getOverScrollMode() != 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void b(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    if (a.a[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1)
    {
      paramInt1 = paramPullToRefreshBase.getScrollY();
      paramInt2 = paramInt3;
      paramInt3 = paramInt1;
    }
    else
    {
      paramInt3 = paramPullToRefreshBase.getScrollX();
      paramInt4 = paramInt2;
      paramInt2 = paramInt1;
    }
    if ((paramPullToRefreshBase.n()) && (!paramPullToRefreshBase.r()))
    {
      PullToRefreshBase.Mode localMode = paramPullToRefreshBase.getMode();
      if ((localMode.permitsPullToRefresh()) && (!paramBoolean) && (paramInt2 != 0))
      {
        paramInt1 = paramInt2 + paramInt4;
        if (paramInt1 < -paramInt6)
        {
          if (localMode.showHeaderLoadingLayout())
          {
            if (paramInt3 == 0) {
              paramPullToRefreshBase.E(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
            }
            paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (paramInt3 + paramInt1)));
          }
        }
        else if (paramInt1 > paramInt5 + paramInt6)
        {
          if (localMode.showFooterLoadingLayout())
          {
            if (paramInt3 == 0) {
              paramPullToRefreshBase.E(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
            }
            paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (paramInt3 + paramInt1 - paramInt5)));
          }
        }
        else if ((Math.abs(paramInt1) <= paramInt6) || (Math.abs(paramInt1 - paramInt5) <= paramInt6)) {
          paramPullToRefreshBase.E(PullToRefreshBase.State.RESET, new boolean[0]);
        }
      }
      else if ((paramBoolean) && (PullToRefreshBase.State.OVERSCROLLING == paramPullToRefreshBase.getState()))
      {
        paramPullToRefreshBase.E(PullToRefreshBase.State.RESET, new boolean[0]);
      }
    }
  }
  
  public static void c(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    b(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }
  
  public static void d(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    c(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\handmark\pulltorefresh\library\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */