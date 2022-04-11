package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PagerSnapHelper
  extends SnapHelper
{
  private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
  @Nullable
  private OrientationHelper mHorizontalHelper;
  @Nullable
  private OrientationHelper mVerticalHelper;
  
  private int distanceToCenter(@NonNull View paramView, OrientationHelper paramOrientationHelper)
  {
    return paramOrientationHelper.getDecoratedStart(paramView) + paramOrientationHelper.getDecoratedMeasurement(paramView) / 2 - (paramOrientationHelper.getStartAfterPadding() + paramOrientationHelper.getTotalSpace() / 2);
  }
  
  @Nullable
  private View findCenterView(RecyclerView.LayoutManager paramLayoutManager, OrientationHelper paramOrientationHelper)
  {
    int i = paramLayoutManager.getChildCount();
    Object localObject = null;
    if (i == 0) {
      return null;
    }
    int j = paramOrientationHelper.getStartAfterPadding();
    int k = paramOrientationHelper.getTotalSpace() / 2;
    int m = Integer.MAX_VALUE;
    int n = 0;
    while (n < i)
    {
      View localView = paramLayoutManager.getChildAt(n);
      int i1 = Math.abs(paramOrientationHelper.getDecoratedStart(localView) + paramOrientationHelper.getDecoratedMeasurement(localView) / 2 - (j + k));
      int i2 = m;
      if (i1 < m)
      {
        localObject = localView;
        i2 = i1;
      }
      n++;
      m = i2;
    }
    return (View)localObject;
  }
  
  @NonNull
  private OrientationHelper getHorizontalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = this.mHorizontalHelper;
    if ((localOrientationHelper == null) || (localOrientationHelper.mLayoutManager != paramLayoutManager)) {
      this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(paramLayoutManager);
    }
    return this.mHorizontalHelper;
  }
  
  @Nullable
  private OrientationHelper getOrientationHelper(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return getVerticalHelper(paramLayoutManager);
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return getHorizontalHelper(paramLayoutManager);
    }
    return null;
  }
  
  @NonNull
  private OrientationHelper getVerticalHelper(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    OrientationHelper localOrientationHelper = this.mVerticalHelper;
    if ((localOrientationHelper == null) || (localOrientationHelper.mLayoutManager != paramLayoutManager)) {
      this.mVerticalHelper = OrientationHelper.createVerticalHelper(paramLayoutManager);
    }
    return this.mVerticalHelper;
  }
  
  private boolean isForwardFling(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    boolean bool1 = paramLayoutManager.canScrollHorizontally();
    boolean bool2 = true;
    boolean bool3 = true;
    if (bool1)
    {
      if (paramInt1 <= 0) {
        bool3 = false;
      }
      return bool3;
    }
    if (paramInt2 > 0) {
      bool3 = bool2;
    } else {
      bool3 = false;
    }
    return bool3;
  }
  
  private boolean isReverseLayout(RecyclerView.LayoutManager paramLayoutManager)
  {
    int i = paramLayoutManager.getItemCount();
    boolean bool1 = paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramLayoutManager = ((RecyclerView.SmoothScroller.ScrollVectorProvider)paramLayoutManager).computeScrollVectorForPosition(i - 1);
      bool3 = bool2;
      if (paramLayoutManager != null) {
        if (paramLayoutManager.x >= 0.0F)
        {
          bool3 = bool2;
          if (paramLayoutManager.y >= 0.0F) {}
        }
        else
        {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  @Nullable
  public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager paramLayoutManager, @NonNull View paramView)
  {
    int[] arrayOfInt = new int[2];
    if (paramLayoutManager.canScrollHorizontally()) {
      arrayOfInt[0] = distanceToCenter(paramView, getHorizontalHelper(paramLayoutManager));
    } else {
      arrayOfInt[0] = 0;
    }
    if (paramLayoutManager.canScrollVertically()) {
      arrayOfInt[1] = distanceToCenter(paramView, getVerticalHelper(paramLayoutManager));
    } else {
      arrayOfInt[1] = 0;
    }
    return arrayOfInt;
  }
  
  @Nullable
  protected RecyclerView.SmoothScroller createScroller(@NonNull RecyclerView.LayoutManager paramLayoutManager)
  {
    if (!(paramLayoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
      return null;
    }
    new LinearSmoothScroller(this.mRecyclerView.getContext())
    {
      protected float calculateSpeedPerPixel(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 100.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      protected int calculateTimeForScrolling(int paramAnonymousInt)
      {
        return Math.min(100, super.calculateTimeForScrolling(paramAnonymousInt));
      }
      
      protected void onTargetFound(View paramAnonymousView, RecyclerView.State paramAnonymousState, RecyclerView.SmoothScroller.Action paramAnonymousAction)
      {
        paramAnonymousState = PagerSnapHelper.this;
        paramAnonymousView = paramAnonymousState.calculateDistanceToFinalSnap(paramAnonymousState.mRecyclerView.getLayoutManager(), paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousAction.update(i, j, k, this.mDecelerateInterpolator);
        }
      }
    };
  }
  
  @Nullable
  public View findSnapView(RecyclerView.LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager.canScrollVertically()) {
      return findCenterView(paramLayoutManager, getVerticalHelper(paramLayoutManager));
    }
    if (paramLayoutManager.canScrollHorizontally()) {
      return findCenterView(paramLayoutManager, getHorizontalHelper(paramLayoutManager));
    }
    return null;
  }
  
  public int findTargetSnapPosition(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    int i = paramLayoutManager.getItemCount();
    if (i == 0) {
      return -1;
    }
    OrientationHelper localOrientationHelper = getOrientationHelper(paramLayoutManager);
    if (localOrientationHelper == null) {
      return -1;
    }
    int j = Integer.MIN_VALUE;
    int k = Integer.MAX_VALUE;
    int m = paramLayoutManager.getChildCount();
    int n = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    while (n < m)
    {
      View localView = paramLayoutManager.getChildAt(n);
      int i1;
      Object localObject3;
      if (localView == null)
      {
        i1 = k;
        localObject3 = localObject1;
      }
      else
      {
        int i2 = distanceToCenter(localView, localOrientationHelper);
        int i3 = j;
        Object localObject4 = localObject2;
        if (i2 <= 0)
        {
          i3 = j;
          localObject4 = localObject2;
          if (i2 > j)
          {
            localObject4 = localView;
            i3 = i2;
          }
        }
        j = i3;
        i1 = k;
        localObject3 = localObject1;
        localObject2 = localObject4;
        if (i2 >= 0)
        {
          j = i3;
          i1 = k;
          localObject3 = localObject1;
          localObject2 = localObject4;
          if (i2 < k)
          {
            localObject2 = localObject4;
            localObject3 = localView;
            i1 = i2;
            j = i3;
          }
        }
      }
      n++;
      k = i1;
      localObject1 = localObject3;
    }
    boolean bool = isForwardFling(paramLayoutManager, paramInt1, paramInt2);
    if ((bool) && (localObject1 != null)) {
      return paramLayoutManager.getPosition((View)localObject1);
    }
    if ((!bool) && (localObject2 != null)) {
      return paramLayoutManager.getPosition((View)localObject2);
    }
    if (bool) {
      localObject1 = localObject2;
    }
    if (localObject1 == null) {
      return -1;
    }
    paramInt2 = paramLayoutManager.getPosition((View)localObject1);
    if (isReverseLayout(paramLayoutManager) == bool) {
      paramInt1 = -1;
    } else {
      paramInt1 = 1;
    }
    paramInt1 = paramInt2 + paramInt1;
    if ((paramInt1 >= 0) && (paramInt1 < i)) {
      return paramInt1;
    }
    return -1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\PagerSnapHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */