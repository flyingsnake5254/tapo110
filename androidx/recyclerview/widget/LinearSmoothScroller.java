package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class LinearSmoothScroller
  extends RecyclerView.SmoothScroller
{
  private static final boolean DEBUG = false;
  private static final float MILLISECONDS_PER_INCH = 25.0F;
  public static final int SNAP_TO_ANY = 0;
  public static final int SNAP_TO_END = 1;
  public static final int SNAP_TO_START = -1;
  private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2F;
  private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
  protected final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
  private final DisplayMetrics mDisplayMetrics;
  private boolean mHasCalculatedMillisPerPixel = false;
  protected int mInterimTargetDx = 0;
  protected int mInterimTargetDy = 0;
  protected final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
  private float mMillisPerPixel;
  protected PointF mTargetVector;
  
  public LinearSmoothScroller(Context paramContext)
  {
    this.mDisplayMetrics = paramContext.getResources().getDisplayMetrics();
  }
  
  private int clampApplyScroll(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 - paramInt2;
    if (paramInt1 * paramInt2 <= 0) {
      return 0;
    }
    return paramInt2;
  }
  
  private float getSpeedPerPixel()
  {
    if (!this.mHasCalculatedMillisPerPixel)
    {
      this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
      this.mHasCalculatedMillisPerPixel = true;
    }
    return this.mMillisPerPixel;
  }
  
  public int calculateDtToFit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 != -1)
    {
      if (paramInt5 != 0)
      {
        if (paramInt5 == 1) {
          return paramInt4 - paramInt2;
        }
        throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
      }
      paramInt1 = paramInt3 - paramInt1;
      if (paramInt1 > 0) {
        return paramInt1;
      }
      paramInt1 = paramInt4 - paramInt2;
      if (paramInt1 < 0) {
        return paramInt1;
      }
      return 0;
    }
    return paramInt3 - paramInt1;
  }
  
  public int calculateDxToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollHorizontally()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return calculateDtToFit(localLayoutManager.getDecoratedLeft(paramView) - localLayoutParams.leftMargin, localLayoutManager.getDecoratedRight(paramView) + localLayoutParams.rightMargin, localLayoutManager.getPaddingLeft(), localLayoutManager.getWidth() - localLayoutManager.getPaddingRight(), paramInt);
    }
    return 0;
  }
  
  public int calculateDyToMakeVisible(View paramView, int paramInt)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    if ((localLayoutManager != null) && (localLayoutManager.canScrollVertically()))
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return calculateDtToFit(localLayoutManager.getDecoratedTop(paramView) - localLayoutParams.topMargin, localLayoutManager.getDecoratedBottom(paramView) + localLayoutParams.bottomMargin, localLayoutManager.getPaddingTop(), localLayoutManager.getHeight() - localLayoutManager.getPaddingBottom(), paramInt);
    }
    return 0;
  }
  
  protected float calculateSpeedPerPixel(DisplayMetrics paramDisplayMetrics)
  {
    return 25.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected int calculateTimeForDeceleration(int paramInt)
  {
    return (int)Math.ceil(calculateTimeForScrolling(paramInt) / 0.3356D);
  }
  
  protected int calculateTimeForScrolling(int paramInt)
  {
    return (int)Math.ceil(Math.abs(paramInt) * getSpeedPerPixel());
  }
  
  protected int getHorizontalSnapPreference()
  {
    PointF localPointF = this.mTargetVector;
    if (localPointF != null)
    {
      float f = localPointF.x;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    int i = 0;
    return i;
  }
  
  protected int getVerticalSnapPreference()
  {
    PointF localPointF = this.mTargetVector;
    if (localPointF != null)
    {
      float f = localPointF.y;
      if (f != 0.0F)
      {
        if (f > 0.0F) {
          return 1;
        }
        return -1;
      }
    }
    int i = 0;
    return i;
  }
  
  protected void onSeekTargetStep(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    if (getChildCount() == 0)
    {
      stop();
      return;
    }
    this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, paramInt1);
    paramInt1 = clampApplyScroll(this.mInterimTargetDy, paramInt2);
    this.mInterimTargetDy = paramInt1;
    if ((this.mInterimTargetDx == 0) && (paramInt1 == 0)) {
      updateActionForInterimTarget(paramAction);
    }
  }
  
  protected void onStart() {}
  
  protected void onStop()
  {
    this.mInterimTargetDy = 0;
    this.mInterimTargetDx = 0;
    this.mTargetVector = null;
  }
  
  protected void onTargetFound(View paramView, RecyclerView.State paramState, RecyclerView.SmoothScroller.Action paramAction)
  {
    int i = calculateDxToMakeVisible(paramView, getHorizontalSnapPreference());
    int j = calculateDyToMakeVisible(paramView, getVerticalSnapPreference());
    int k = calculateTimeForDeceleration((int)Math.sqrt(i * i + j * j));
    if (k > 0) {
      paramAction.update(-i, -j, k, this.mDecelerateInterpolator);
    }
  }
  
  protected void updateActionForInterimTarget(RecyclerView.SmoothScroller.Action paramAction)
  {
    PointF localPointF = computeScrollVectorForPosition(getTargetPosition());
    if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F)))
    {
      normalize(localPointF);
      this.mTargetVector = localPointF;
      this.mInterimTargetDx = ((int)(localPointF.x * 10000.0F));
      this.mInterimTargetDy = ((int)(localPointF.y * 10000.0F));
      int i = calculateTimeForScrolling(10000);
      paramAction.update((int)(this.mInterimTargetDx * 1.2F), (int)(this.mInterimTargetDy * 1.2F), (int)(i * 1.2F), this.mLinearInterpolator);
      return;
    }
    paramAction.jumpTo(getTargetPosition());
    stop();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\LinearSmoothScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */