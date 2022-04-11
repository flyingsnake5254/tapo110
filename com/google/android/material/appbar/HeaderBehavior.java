package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private static final int INVALID_POINTER = -1;
  private int activePointerId = -1;
  @Nullable
  private Runnable flingRunnable;
  private boolean isBeingDragged;
  private int lastMotionY;
  OverScroller scroller;
  private int touchSlop = -1;
  @Nullable
  private VelocityTracker velocityTracker;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ensureVelocityTracker()
  {
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
  }
  
  boolean canDragView(V paramV)
  {
    return false;
  }
  
  final boolean fling(CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = this.flingRunnable;
    if (localRunnable != null)
    {
      paramV.removeCallbacks(localRunnable);
      this.flingRunnable = null;
    }
    if (this.scroller == null) {
      this.scroller = new OverScroller(paramV.getContext());
    }
    this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.scroller.computeScrollOffset())
    {
      paramCoordinatorLayout = new FlingRunnable(paramCoordinatorLayout, paramV);
      this.flingRunnable = paramCoordinatorLayout;
      ViewCompat.postOnAnimation(paramV, paramCoordinatorLayout);
      return true;
    }
    onFlingFinished(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int getMaxDragOffset(@NonNull V paramV)
  {
    return -paramV.getHeight();
  }
  
  int getScrollRangeForDragFling(@NonNull V paramV)
  {
    return paramV.getHeight();
  }
  
  int getTopBottomOffsetForScrollingSibling()
  {
    return getTopAndBottomOffset();
  }
  
  void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.touchSlop < 0) {
      this.touchSlop = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    if ((paramMotionEvent.getActionMasked() == 2) && (this.isBeingDragged))
    {
      i = this.activePointerId;
      if (i == -1) {
        return false;
      }
      i = paramMotionEvent.findPointerIndex(i);
      if (i == -1) {
        return false;
      }
      i = (int)paramMotionEvent.getY(i);
      if (Math.abs(i - this.lastMotionY) > this.touchSlop)
      {
        this.lastMotionY = i;
        return true;
      }
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.activePointerId = -1;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      boolean bool;
      if ((canDragView(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, i, j))) {
        bool = true;
      } else {
        bool = false;
      }
      this.isBeingDragged = bool;
      if (bool)
      {
        this.lastMotionY = j;
        this.activePointerId = paramMotionEvent.getPointerId(0);
        ensureVelocityTracker();
        paramCoordinatorLayout = this.scroller;
        if ((paramCoordinatorLayout != null) && (!paramCoordinatorLayout.isFinished()))
        {
          this.scroller.abortAnimation();
          return true;
        }
      }
    }
    paramCoordinatorLayout = this.velocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool1 = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label205;
        }
        if (i == 6)
        {
          if (paramMotionEvent.getActionIndex() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          this.activePointerId = paramMotionEvent.getPointerId(i);
          this.lastMotionY = ((int)(paramMotionEvent.getY(i) + 0.5F));
        }
      }
      else
      {
        i = paramMotionEvent.findPointerIndex(this.activePointerId);
        if (i == -1) {
          return false;
        }
        i = (int)paramMotionEvent.getY(i);
        j = this.lastMotionY;
        this.lastMotionY = i;
        scroll(paramCoordinatorLayout, paramV, j - i, getMaxDragOffset(paramV), 0);
      }
      j = 0;
      break label244;
    }
    else
    {
      VelocityTracker localVelocityTracker = this.velocityTracker;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.addMovement(paramMotionEvent);
        this.velocityTracker.computeCurrentVelocity(1000);
        float f = this.velocityTracker.getYVelocity(this.activePointerId);
        fling(paramCoordinatorLayout, paramV, -getScrollRangeForDragFling(paramV), 0, f);
        i = 1;
        break label208;
      }
    }
    label205:
    i = 0;
    label208:
    this.isBeingDragged = false;
    this.activePointerId = -1;
    paramCoordinatorLayout = this.velocityTracker;
    int j = i;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.recycle();
      this.velocityTracker = null;
      j = i;
    }
    label244:
    paramCoordinatorLayout = this.velocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    boolean bool2 = bool1;
    if (!this.isBeingDragged) {
      if (j != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  final int scroll(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, getTopBottomOffsetForScrollingSibling() - paramInt1, paramInt2, paramInt3);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return setHeaderTopBottomOffset(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = getTopAndBottomOffset();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        setTopAndBottomOffset(paramInt1);
        return i - paramInt1;
      }
    }
    paramInt1 = 0;
    return paramInt1;
  }
  
  private class FlingRunnable
    implements Runnable
  {
    private final V layout;
    private final CoordinatorLayout parent;
    
    FlingRunnable(V paramV)
    {
      this.parent = paramV;
      View localView;
      this.layout = localView;
    }
    
    public void run()
    {
      if (this.layout != null)
      {
        Object localObject = HeaderBehavior.this.scroller;
        if (localObject != null) {
          if (((OverScroller)localObject).computeScrollOffset())
          {
            localObject = HeaderBehavior.this;
            ((HeaderBehavior)localObject).setHeaderTopBottomOffset(this.parent, this.layout, ((HeaderBehavior)localObject).scroller.getCurrY());
            ViewCompat.postOnAnimation(this.layout, this);
          }
          else
          {
            HeaderBehavior.this.onFlingFinished(this.parent, this.layout);
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\appbar\HeaderBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */