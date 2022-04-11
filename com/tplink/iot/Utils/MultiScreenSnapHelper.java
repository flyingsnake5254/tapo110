package com.tplink.iot.Utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action;
import androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView.State;
import androidx.recyclerview.widget.SnapHelper;

public class MultiScreenSnapHelper
  extends SnapHelper
{
  private OrientationHelper a;
  private RecyclerView b;
  private int c = 1;
  private int d = 1000;
  
  private int b(View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) - paramOrientationHelper.getStartAfterPadding();
  }
  
  private int c(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramOrientationHelper = (LinearLayoutManager)paramLayoutManager;
      int i = paramOrientationHelper.findFirstVisibleItemPosition();
      if (i == -1) {
        return -1;
      }
      if (paramOrientationHelper.findLastCompletelyVisibleItemPosition() == paramLayoutManager.getItemCount() - 1) {
        return -1;
      }
      paramOrientationHelper = paramLayoutManager.findViewByPosition(i);
      int j = ((LinearLayoutManager)paramLayoutManager).findLastVisibleItemPosition();
      View localView = paramLayoutManager.findViewByPosition(j);
      int k = this.c;
      int m = k - i % k;
      int n = j % k + 1;
      if (m > n)
      {
        i = i / k * k;
      }
      else if (n > m)
      {
        i = j / k * k;
      }
      else
      {
        paramLayoutManager = new Rect();
        Rect localRect = new Rect();
        paramOrientationHelper.getLocalVisibleRect(paramLayoutManager);
        localView.getLocalVisibleRect(localRect);
        if (paramLayoutManager.height() * paramLayoutManager.width() >= localRect.height() * localRect.width())
        {
          j = this.c;
          i = i / j * j;
        }
        else
        {
          i = this.c;
          i = j / i * i;
        }
      }
      return i;
    }
    return -1;
  }
  
  private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (this.a == null) {
      this.a = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.a;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
    throws IllegalStateException
  {
    this.b = paramRecyclerView;
    super.attachToRecyclerView(paramRecyclerView);
  }
  
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = b(paramView, getHorizontalHelper(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    return arrayOfInt;
  }
  
  @Nullable
  protected LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    return new a(this.b.getContext());
  }
  
  public void d(int paramInt)
  {
    this.c = paramInt;
  }
  
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    return paramLayoutManager.findViewByPosition(c(paramLayoutManager, getHorizontalHelper(paramLayoutManager)));
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = c(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    if (i == -1) {
      return ((LinearLayoutManager)paramLayoutManager).findFirstVisibleItemPosition();
    }
    int j = this.d;
    if (paramInt1 > j)
    {
      paramInt2 = i + this.c;
    }
    else
    {
      paramInt2 = i;
      if (paramInt1 < -j) {
        paramInt2 = i - this.c;
      }
    }
    i = paramLayoutManager.getItemCount();
    if (paramInt2 > i)
    {
      paramInt1 = i - this.c;
    }
    else
    {
      paramInt1 = paramInt2;
      if (paramInt2 < 0)
      {
        paramInt1 = paramInt2;
        if (i > 0) {
          paramInt1 = 0;
        }
      }
    }
    return paramInt1;
  }
  
  class a
    extends LinearSmoothScroller
  {
    a(Context paramContext)
    {
      super();
    }
    
    protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
    {
      return 40.0F / paramDisplayMetrics.densityDpi;
    }
    
    protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
    {
      paramState = MultiScreenSnapHelper.this;
      paramView = paramState.calculateDistanceToFinalSnap(MultiScreenSnapHelper.a(paramState).getLayoutManager(), paramView);
      int i = paramView[0];
      int j = paramView[1];
      int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
      if (k > 0) {
        paramAction.update(i, j, k, this.mDecelerateInterpolator);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\MultiScreenSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */