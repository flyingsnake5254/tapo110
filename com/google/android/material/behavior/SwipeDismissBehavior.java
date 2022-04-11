package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5F;
  private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0F;
  private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5F;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  public static final int SWIPE_DIRECTION_ANY = 2;
  public static final int SWIPE_DIRECTION_END_TO_START = 1;
  public static final int SWIPE_DIRECTION_START_TO_END = 0;
  float alphaEndSwipeDistance = 0.5F;
  float alphaStartSwipeDistance = 0.0F;
  private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    private static final int INVALID_POINTER_ID = -1;
    private int activePointerId = -1;
    private int originalCapturedViewLeft;
    
    private boolean shouldDismiss(@NonNull View paramAnonymousView, float paramAnonymousFloat)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool4 = paramAnonymousFloat < 0.0F;
      if (bool4)
      {
        if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
          j = 1;
        } else {
          j = 0;
        }
        k = SwipeDismissBehavior.this.swipeDirection;
        if (k == 2) {
          return true;
        }
        if (k == 0)
        {
          if (j != 0 ? paramAnonymousFloat < 0.0F : bool4) {
            bool3 = true;
          }
          return bool3;
        }
        bool3 = bool1;
        if (k == 1)
        {
          if (j != 0)
          {
            bool3 = bool1;
            if (!bool4) {
              break label119;
            }
          }
          else
          {
            bool3 = bool1;
            if (paramAnonymousFloat >= 0.0F) {
              break label119;
            }
          }
          bool3 = true;
        }
        label119:
        return bool3;
      }
      int j = paramAnonymousView.getLeft();
      int k = this.originalCapturedViewLeft;
      int i = Math.round(paramAnonymousView.getWidth() * SwipeDismissBehavior.this.dragDismissThreshold);
      bool3 = bool2;
      if (Math.abs(j - k) >= i) {
        bool3 = true;
      }
      return bool3;
    }
    
    public int clampViewPositionHorizontal(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
        paramAnonymousInt2 = 1;
      } else {
        paramAnonymousInt2 = 0;
      }
      int i = SwipeDismissBehavior.this.swipeDirection;
      if (i == 0)
      {
        if (paramAnonymousInt2 != 0)
        {
          i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
          paramAnonymousInt2 = this.originalCapturedViewLeft;
        }
        else
        {
          i = this.originalCapturedViewLeft;
        }
      }
      else
      {
        for (paramAnonymousInt2 = paramAnonymousView.getWidth();; paramAnonymousInt2 = paramAnonymousView.getWidth())
        {
          paramAnonymousInt2 += i;
          break label137;
          if (i != 1) {
            break label114;
          }
          if (paramAnonymousInt2 == 0) {
            break;
          }
          i = this.originalCapturedViewLeft;
        }
        i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
        paramAnonymousInt2 = this.originalCapturedViewLeft;
        break label137;
        label114:
        i = this.originalCapturedViewLeft - paramAnonymousView.getWidth();
        paramAnonymousInt2 = this.originalCapturedViewLeft;
        paramAnonymousInt2 = paramAnonymousView.getWidth() + paramAnonymousInt2;
      }
      label137:
      return SwipeDismissBehavior.clamp(i, paramAnonymousInt1, paramAnonymousInt2);
    }
    
    public int clampViewPositionVertical(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getTop();
    }
    
    public int getViewHorizontalDragRange(@NonNull View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
    
    public void onViewCaptured(@NonNull View paramAnonymousView, int paramAnonymousInt)
    {
      this.activePointerId = paramAnonymousInt;
      this.originalCapturedViewLeft = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      SwipeDismissBehavior.OnDismissListener localOnDismissListener = SwipeDismissBehavior.this.listener;
      if (localOnDismissListener != null) {
        localOnDismissListener.onDragStateChanged(paramAnonymousInt);
      }
    }
    
    public void onViewPositionChanged(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      float f1 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance;
      float f2 = this.originalCapturedViewLeft + paramAnonymousView.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance;
      float f3 = paramAnonymousInt1;
      if (f3 <= f1) {
        paramAnonymousView.setAlpha(1.0F);
      } else if (f3 >= f2) {
        paramAnonymousView.setAlpha(0.0F);
      } else {
        paramAnonymousView.setAlpha(SwipeDismissBehavior.clamp(0.0F, 1.0F - SwipeDismissBehavior.fraction(f1, f2, f3), 1.0F));
      }
    }
    
    public void onViewReleased(@NonNull View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      this.activePointerId = -1;
      int i = paramAnonymousView.getWidth();
      int k;
      boolean bool;
      if (shouldDismiss(paramAnonymousView, paramAnonymousFloat1))
      {
        int j = paramAnonymousView.getLeft();
        k = this.originalCapturedViewLeft;
        if (j < k) {
          k -= i;
        } else {
          k += i;
        }
        bool = true;
      }
      else
      {
        k = this.originalCapturedViewLeft;
        bool = false;
      }
      if (SwipeDismissBehavior.this.viewDragHelper.settleCapturedViewAt(k, paramAnonymousView.getTop()))
      {
        ViewCompat.postOnAnimation(paramAnonymousView, new SwipeDismissBehavior.SettleRunnable(SwipeDismissBehavior.this, paramAnonymousView, bool));
      }
      else if (bool)
      {
        SwipeDismissBehavior.OnDismissListener localOnDismissListener = SwipeDismissBehavior.this.listener;
        if (localOnDismissListener != null) {
          localOnDismissListener.onDismiss(paramAnonymousView);
        }
      }
    }
    
    public boolean tryCaptureView(View paramAnonymousView, int paramAnonymousInt)
    {
      int i = this.activePointerId;
      boolean bool;
      if (((i == -1) || (i == paramAnonymousInt)) && (SwipeDismissBehavior.this.canSwipeDismissView(paramAnonymousView))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  };
  float dragDismissThreshold = 0.5F;
  private boolean interceptingEvents;
  OnDismissListener listener;
  private float sensitivity = 0.0F;
  private boolean sensitivitySet;
  int swipeDirection = 2;
  ViewDragHelper viewDragHelper;
  
  static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void ensureViewDragHelper(ViewGroup paramViewGroup)
  {
    if (this.viewDragHelper == null)
    {
      if (this.sensitivitySet) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.sensitivity, this.dragCallback);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.dragCallback);
      }
      this.viewDragHelper = paramViewGroup;
    }
  }
  
  static float fraction(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void updateAccessibilityActions(View paramView)
  {
    ViewCompat.removeAccessibilityAction(paramView, 1048576);
    if (canSwipeDismissView(paramView)) {
      ViewCompat.replaceAccessibilityAction(paramView, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand()
      {
        public boolean perform(@NonNull View paramAnonymousView, @Nullable AccessibilityViewCommand.CommandArguments paramAnonymousCommandArguments)
        {
          boolean bool = SwipeDismissBehavior.this.canSwipeDismissView(paramAnonymousView);
          int i = 0;
          if (bool)
          {
            if (ViewCompat.getLayoutDirection(paramAnonymousView) == 1) {
              j = 1;
            } else {
              j = 0;
            }
            int k = SwipeDismissBehavior.this.swipeDirection;
            int m;
            if ((k != 0) || (j == 0))
            {
              m = i;
              if (k == 1)
              {
                m = i;
                if (j != 0) {}
              }
            }
            else
            {
              m = 1;
            }
            i = paramAnonymousView.getWidth();
            int j = i;
            if (m != 0) {
              j = -i;
            }
            ViewCompat.offsetLeftAndRight(paramAnonymousView, j);
            paramAnonymousView.setAlpha(0.0F);
            paramAnonymousCommandArguments = SwipeDismissBehavior.this.listener;
            if (paramAnonymousCommandArguments != null) {
              paramAnonymousCommandArguments.onDismiss(paramAnonymousView);
            }
            return true;
          }
          return false;
        }
      });
    }
  }
  
  public boolean canSwipeDismissView(@NonNull View paramView)
  {
    return true;
  }
  
  public int getDragState()
  {
    ViewDragHelper localViewDragHelper = this.viewDragHelper;
    int i;
    if (localViewDragHelper != null) {
      i = localViewDragHelper.getViewDragState();
    } else {
      i = 0;
    }
    return i;
  }
  
  @Nullable
  @VisibleForTesting
  public OnDismissListener getListener()
  {
    return this.listener;
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    boolean bool = this.interceptingEvents;
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        this.interceptingEvents = false;
      }
    }
    else
    {
      bool = paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      this.interceptingEvents = bool;
    }
    if (bool)
    {
      ensureViewDragHelper(paramCoordinatorLayout);
      return this.viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramV, paramInt);
    if (ViewCompat.getImportantForAccessibility(paramV) == 0)
    {
      ViewCompat.setImportantForAccessibility(paramV, 1);
      updateAccessibilityActions(paramV);
    }
    return bool;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = this.viewDragHelper;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public void setDragDismissDistance(float paramFloat)
  {
    this.dragDismissThreshold = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setEndAlphaSwipeDistance(float paramFloat)
  {
    this.alphaEndSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setListener(@Nullable OnDismissListener paramOnDismissListener)
  {
    this.listener = paramOnDismissListener;
  }
  
  public void setSensitivity(float paramFloat)
  {
    this.sensitivity = paramFloat;
    this.sensitivitySet = true;
  }
  
  public void setStartAlphaSwipeDistance(float paramFloat)
  {
    this.alphaStartSwipeDistance = clamp(0.0F, paramFloat, 1.0F);
  }
  
  public void setSwipeDirection(int paramInt)
  {
    this.swipeDirection = paramInt;
  }
  
  public static abstract interface OnDismissListener
  {
    public abstract void onDismiss(View paramView);
    
    public abstract void onDragStateChanged(int paramInt);
  }
  
  private class SettleRunnable
    implements Runnable
  {
    private final boolean dismiss;
    private final View view;
    
    SettleRunnable(View paramView, boolean paramBoolean)
    {
      this.view = paramView;
      this.dismiss = paramBoolean;
    }
    
    public void run()
    {
      Object localObject = SwipeDismissBehavior.this.viewDragHelper;
      if ((localObject != null) && (((ViewDragHelper)localObject).continueSettling(true)))
      {
        ViewCompat.postOnAnimation(this.view, this);
      }
      else if (this.dismiss)
      {
        localObject = SwipeDismissBehavior.this.listener;
        if (localObject != null) {
          ((SwipeDismissBehavior.OnDismissListener)localObject).onDismiss(this.view);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\behavior\SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */