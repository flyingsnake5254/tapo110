package com.scwang.smart.refresh.layout.d;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.b.a;

public class b
  implements Interpolator
{
  public static int a = 0;
  public static int b = 1;
  private static float c = Resources.getSystem().getDisplayMetrics().density;
  private static final float d;
  private static final float e;
  private int f;
  
  static
  {
    float f1 = 1.0F / k(1.0F);
    d = f1;
    e = 1.0F - f1 * k(1.0F);
  }
  
  public b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public static boolean a(@NonNull View paramView, PointF paramPointF, boolean paramBoolean)
  {
    boolean bool1 = true;
    if ((paramView.canScrollVertically(1)) && (paramView.getVisibility() == 0)) {
      return false;
    }
    if (((paramView instanceof ViewGroup)) && (paramPointF != null) && (!f(paramView)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i = localViewGroup.getChildCount();
      PointF localPointF = new PointF();
      while (i > 0)
      {
        View localView = localViewGroup.getChildAt(i - 1);
        if (g(localViewGroup, localView, paramPointF.x, paramPointF.y, localPointF))
        {
          paramView = localView.getTag(a.srl_tag);
          if ((!"fixed".equals(paramView)) && (!"fixed-top".equals(paramView)))
          {
            paramPointF.offset(localPointF.x, localPointF.y);
            paramBoolean = a(localView, paramPointF, paramBoolean);
            paramPointF.offset(-localPointF.x, -localPointF.y);
            return paramBoolean;
          }
          return false;
        }
        i--;
      }
    }
    boolean bool2 = bool1;
    if (!paramBoolean) {
      if (paramView.canScrollVertically(-1)) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public static boolean b(@NonNull View paramView, PointF paramPointF)
  {
    if ((paramView.canScrollVertically(-1)) && (paramView.getVisibility() == 0)) {
      return false;
    }
    if (((paramView instanceof ViewGroup)) && (paramPointF != null))
    {
      Object localObject = (ViewGroup)paramView;
      int i = ((ViewGroup)localObject).getChildCount();
      paramView = new PointF();
      while (i > 0)
      {
        View localView = ((ViewGroup)localObject).getChildAt(i - 1);
        if (g((View)localObject, localView, paramPointF.x, paramPointF.y, paramView))
        {
          localObject = localView.getTag(a.srl_tag);
          if ((!"fixed".equals(localObject)) && (!"fixed-bottom".equals(localObject)))
          {
            paramPointF.offset(paramView.x, paramView.y);
            boolean bool = b(localView, paramPointF);
            paramPointF.offset(-paramView.x, -paramView.y);
            return bool;
          }
          return false;
        }
        i--;
      }
    }
    return true;
  }
  
  public static int c(float paramFloat)
  {
    return (int)(paramFloat * c + 0.5F);
  }
  
  public static void d(View paramView, int paramInt)
  {
    if ((paramView instanceof ScrollView)) {
      ((ScrollView)paramView).fling(paramInt);
    } else if ((paramView instanceof AbsListView))
    {
      if (Build.VERSION.SDK_INT >= 21) {
        ((AbsListView)paramView).fling(paramInt);
      }
    }
    else if ((paramView instanceof WebView)) {
      ((WebView)paramView).flingScroll(0, paramInt);
    } else if ((paramView instanceof NestedScrollView)) {
      ((NestedScrollView)paramView).fling(paramInt);
    } else if ((paramView instanceof RecyclerView)) {
      ((RecyclerView)paramView).fling(0, paramInt);
    }
  }
  
  public static boolean e(View paramView)
  {
    boolean bool;
    if ((!f(paramView)) && (!(paramView instanceof ViewPager)) && (!(paramView instanceof NestedScrollingParent))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f(View paramView)
  {
    boolean bool;
    if ((!(paramView instanceof AbsListView)) && (!(paramView instanceof ScrollView)) && (!(paramView instanceof ScrollingView)) && (!(paramView instanceof WebView)) && (!(paramView instanceof NestedScrollingChild))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g(@NonNull View paramView1, @NonNull View paramView2, float paramFloat1, float paramFloat2, PointF paramPointF)
  {
    if (paramView2.getVisibility() != 0) {
      return false;
    }
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[0] += paramView1.getScrollX() - paramView2.getLeft();
    arrayOfFloat[1] += paramView1.getScrollY() - paramView2.getTop();
    boolean bool;
    if ((arrayOfFloat[0] >= 0.0F) && (arrayOfFloat[1] >= 0.0F) && (arrayOfFloat[0] < paramView2.getWidth()) && (arrayOfFloat[1] < paramView2.getHeight())) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (paramPointF != null)) {
      paramPointF.set(arrayOfFloat[0] - paramFloat1, arrayOfFloat[1] - paramFloat2);
    }
    return bool;
  }
  
  public static int h(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams1 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = localLayoutParams1;
    if (localLayoutParams1 == null) {
      localLayoutParams2 = new ViewGroup.LayoutParams(-1, -2);
    }
    int i = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams2.width);
    int j = localLayoutParams2.height;
    if (j > 0) {
      j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    } else {
      j = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i, j);
    return paramView.getMeasuredHeight();
  }
  
  public static float i(int paramInt)
  {
    return paramInt / c;
  }
  
  public static void j(@NonNull AbsListView paramAbsListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramAbsListView.scrollListBy(paramInt);
    }
    else if ((paramAbsListView instanceof ListView))
    {
      int i = paramAbsListView.getFirstVisiblePosition();
      if (i == -1) {
        return;
      }
      View localView = paramAbsListView.getChildAt(0);
      if (localView == null) {
        return;
      }
      int j = localView.getTop();
      ((ListView)paramAbsListView).setSelectionFromTop(i, j - paramInt);
    }
    else
    {
      paramAbsListView.smoothScrollBy(paramInt, 0);
    }
  }
  
  private static float k(float paramFloat)
  {
    paramFloat *= 8.0F;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp(1.0F - paramFloat)) * 0.63212055F + 0.36787945F;
    }
    return paramFloat;
  }
  
  public float getInterpolation(float paramFloat)
  {
    if (this.f == b)
    {
      paramFloat = 1.0F - paramFloat;
      return 1.0F - paramFloat * paramFloat;
    }
    float f1 = d * k(paramFloat);
    paramFloat = f1;
    if (f1 > 0.0F) {
      paramFloat = f1 + e;
    }
    return paramFloat;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */