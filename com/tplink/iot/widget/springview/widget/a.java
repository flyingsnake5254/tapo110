package com.tplink.iot.widget.springview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;

class a
{
  public static boolean a(AppBarLayout paramAppBarLayout)
  {
    boolean bool1 = false;
    if (paramAppBarLayout == null) {
      return false;
    }
    boolean bool2;
    for (int i = 0;; i++)
    {
      bool2 = bool1;
      if (i >= paramAppBarLayout.getChildCount()) {
        break;
      }
      if (b(paramAppBarLayout.getChildAt(i)))
      {
        bool2 = true;
        break;
      }
    }
    return bool2;
  }
  
  private static boolean b(View paramView)
  {
    if ((paramView.getLayoutParams() instanceof AppBarLayout.LayoutParams)) {
      return (((AppBarLayout.LayoutParams)paramView.getLayoutParams()).getScrollFlags() & 0x1) == 1;
    }
    b.d.w.c.a.e("SpringView", "view检查出现异常");
    return false;
  }
  
  public static AppBarLayout c(View paramView)
  {
    for (paramView = paramView.getParent(); (paramView != null) && (!(paramView instanceof CoordinatorLayout)); paramView = paramView.getParent()) {}
    if ((paramView instanceof CoordinatorLayout))
    {
      CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)paramView;
      for (int i = localCoordinatorLayout.getChildCount() - 1; i >= 0; i--)
      {
        paramView = localCoordinatorLayout.getChildAt(i);
        if ((paramView instanceof AppBarLayout)) {
          return (AppBarLayout)paramView;
        }
      }
    }
    paramView = null;
    return paramView;
  }
  
  public static View d(View paramView)
  {
    if (e(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      for (int i = 0; i < localViewGroup.getChildCount(); i++)
      {
        paramView = d(localViewGroup.getChildAt(i));
        if (paramView != null) {
          return paramView;
        }
      }
    }
    return null;
  }
  
  public static boolean e(View paramView)
  {
    boolean bool1 = paramView instanceof ListView;
    boolean bool2 = true;
    boolean bool3 = bool2;
    if (!bool1)
    {
      bool3 = bool2;
      if (!(paramView instanceof ScrollView))
      {
        bool3 = bool2;
        if (!(paramView instanceof NestedScrollView))
        {
          bool3 = bool2;
          if (!(paramView instanceof RecyclerView)) {
            if ((paramView instanceof WebView))
            {
              bool3 = bool2;
            }
            else
            {
              bool3 = bool2;
              if (!paramView.canScrollVertically(-1)) {
                if (paramView.canScrollVertically(1)) {
                  bool3 = bool2;
                } else {
                  bool3 = false;
                }
              }
            }
          }
        }
      }
    }
    return bool3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\springview\widget\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */