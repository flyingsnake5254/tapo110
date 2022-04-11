package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  private int overlayTop;
  final Rect tempRect1 = new Rect();
  final Rect tempRect2 = new Rect();
  private int verticalLayoutGap = 0;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int resolveGravity(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388659;
    }
    return i;
  }
  
  @Nullable
  abstract View findFirstDependency(List<View> paramList);
  
  final int getOverlapPixelsForOffset(View paramView)
  {
    int i = this.overlayTop;
    int j = 0;
    if (i != 0)
    {
      float f = getOverlapRatioForOffset(paramView);
      j = this.overlayTop;
      j = MathUtils.clamp((int)(f * j), 0, j);
    }
    return j;
  }
  
  float getOverlapRatioForOffset(View paramView)
  {
    return 1.0F;
  }
  
  public final int getOverlayTop()
  {
    return this.overlayTop;
  }
  
  int getScrollRange(@NonNull View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  final int getVerticalLayoutGap()
  {
    return this.verticalLayoutGap;
  }
  
  protected void layoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, int paramInt)
  {
    View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.tempRect1;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + localLayoutParams.leftMargin, localView.getBottom() + localLayoutParams.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - localLayoutParams.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - localLayoutParams.bottomMargin);
      WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
      if ((localWindowInsetsCompat != null) && (ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView)))
      {
        localRect.left += localWindowInsetsCompat.getSystemWindowInsetLeft();
        localRect.right -= localWindowInsetsCompat.getSystemWindowInsetRight();
      }
      paramCoordinatorLayout = this.tempRect2;
      GravityCompat.apply(resolveGravity(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = getOverlapPixelsForOffset(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.verticalLayoutGap = (paramCoordinatorLayout.top - localView.getBottom());
    }
    else
    {
      super.layoutChild(paramCoordinatorLayout, paramView, paramInt);
      this.verticalLayoutGap = 0;
    }
  }
  
  public boolean onMeasureChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramView.getLayoutParams().height;
    if ((i == -1) || (i == -2))
    {
      View localView = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        int j = View.MeasureSpec.getSize(paramInt3);
        if (j > 0)
        {
          paramInt3 = j;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
            paramInt3 = j;
            if (localWindowInsetsCompat != null) {
              paramInt3 = j + (localWindowInsetsCompat.getSystemWindowInsetTop() + localWindowInsetsCompat.getSystemWindowInsetBottom());
            }
          }
        }
        else
        {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        paramInt3 += getScrollRange(localView);
        j = localView.getMeasuredHeight();
        if (shouldHeaderOverlapScrollingChild()) {
          paramView.setTranslationY(-j);
        } else {
          paramInt3 -= j;
        }
        if (i == -1) {
          j = 1073741824;
        } else {
          j = Integer.MIN_VALUE;
        }
        paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, j), paramInt4);
        return true;
      }
    }
    return false;
  }
  
  public final void setOverlayTop(int paramInt)
  {
    this.overlayTop = paramInt;
  }
  
  protected boolean shouldHeaderOverlapScrollingChild()
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\appbar\HeaderScrollingViewBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */