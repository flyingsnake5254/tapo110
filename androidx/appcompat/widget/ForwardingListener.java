package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ForwardingListener
  implements View.OnTouchListener, View.OnAttachStateChangeListener
{
  private int mActivePointerId;
  private Runnable mDisallowIntercept;
  private boolean mForwarding;
  private final int mLongPressTimeout;
  private final float mScaledTouchSlop;
  final View mSrc;
  private final int mTapTimeout;
  private final int[] mTmpLocation = new int[2];
  private Runnable mTriggerLongPress;
  
  public ForwardingListener(View paramView)
  {
    this.mSrc = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.mScaledTouchSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    int i = ViewConfiguration.getTapTimeout();
    this.mTapTimeout = i;
    this.mLongPressTimeout = ((i + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private void clearCallbacks()
  {
    Runnable localRunnable = this.mTriggerLongPress;
    if (localRunnable != null) {
      this.mSrc.removeCallbacks(localRunnable);
    }
    localRunnable = this.mDisallowIntercept;
    if (localRunnable != null) {
      this.mSrc.removeCallbacks(localRunnable);
    }
  }
  
  private boolean onTouchForwarded(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    Object localObject = getPopup();
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localObject != null) {
      if (!((ShowableListMenu)localObject).isShowing())
      {
        bool2 = bool1;
      }
      else
      {
        DropDownListView localDropDownListView = (DropDownListView)((ShowableListMenu)localObject).getListView();
        bool2 = bool1;
        if (localDropDownListView != null) {
          if (!localDropDownListView.isShown())
          {
            bool2 = bool1;
          }
          else
          {
            localObject = MotionEvent.obtainNoHistory(paramMotionEvent);
            toGlobalMotionEvent(localView, (MotionEvent)localObject);
            toLocalMotionEvent(localDropDownListView, (MotionEvent)localObject);
            boolean bool3 = localDropDownListView.onForwardedEvent((MotionEvent)localObject, this.mActivePointerId);
            ((MotionEvent)localObject).recycle();
            int i = paramMotionEvent.getActionMasked();
            if ((i != 1) && (i != 3)) {
              i = 1;
            } else {
              i = 0;
            }
            bool2 = bool1;
            if (bool3)
            {
              bool2 = bool1;
              if (i != 0) {
                bool2 = true;
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  private boolean onTouchObserved(MotionEvent paramMotionEvent)
  {
    View localView = this.mSrc;
    if (!localView.isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label173;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if ((i < 0) || (pointInView(localView, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.mScaledTouchSlop))) {
            break label173;
          }
          clearCallbacks();
          localView.getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        }
      }
      clearCallbacks();
    }
    else
    {
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      if (this.mDisallowIntercept == null) {
        this.mDisallowIntercept = new DisallowIntercept();
      }
      localView.postDelayed(this.mDisallowIntercept, this.mTapTimeout);
      if (this.mTriggerLongPress == null) {
        this.mTriggerLongPress = new TriggerLongPress();
      }
      localView.postDelayed(this.mTriggerLongPress, this.mLongPressTimeout);
    }
    label173:
    return false;
  }
  
  private static boolean pointInView(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = -paramFloat3;
    boolean bool;
    if ((paramFloat1 >= f) && (paramFloat2 >= f) && (paramFloat1 < paramView.getRight() - paramView.getLeft() + paramFloat3) && (paramFloat2 < paramView.getBottom() - paramView.getTop() + paramFloat3)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean toGlobalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private boolean toLocalMotionEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.mTmpLocation;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  public abstract ShowableListMenu getPopup();
  
  protected boolean onForwardingStarted()
  {
    ShowableListMenu localShowableListMenu = getPopup();
    if ((localShowableListMenu != null) && (!localShowableListMenu.isShowing())) {
      localShowableListMenu.show();
    }
    return true;
  }
  
  protected boolean onForwardingStopped()
  {
    ShowableListMenu localShowableListMenu = getPopup();
    if ((localShowableListMenu != null) && (localShowableListMenu.isShowing())) {
      localShowableListMenu.dismiss();
    }
    return true;
  }
  
  void onLongPress()
  {
    clearCallbacks();
    View localView = this.mSrc;
    if ((localView.isEnabled()) && (!localView.isLongClickable()))
    {
      if (!onForwardingStarted()) {
        return;
      }
      localView.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      localView.onTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      this.mForwarding = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mForwarding;
    boolean bool2 = true;
    boolean bool3;
    if (bool1)
    {
      if ((!onTouchForwarded(paramMotionEvent)) && (onForwardingStopped())) {
        bool3 = false;
      } else {
        bool3 = true;
      }
    }
    else
    {
      if ((onTouchObserved(paramMotionEvent)) && (onForwardingStarted())) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      bool3 = bool4;
      if (bool4)
      {
        long l = SystemClock.uptimeMillis();
        paramView = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.mSrc.onTouchEvent(paramView);
        paramView.recycle();
        bool3 = bool4;
      }
    }
    this.mForwarding = bool3;
    boolean bool4 = bool2;
    if (!bool3) {
      if (bool1) {
        bool4 = bool2;
      } else {
        bool4 = false;
      }
    }
    return bool4;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    this.mForwarding = false;
    this.mActivePointerId = -1;
    paramView = this.mDisallowIntercept;
    if (paramView != null) {
      this.mSrc.removeCallbacks(paramView);
    }
  }
  
  private class DisallowIntercept
    implements Runnable
  {
    DisallowIntercept() {}
    
    public void run()
    {
      ViewParent localViewParent = ForwardingListener.this.mSrc.getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
    }
  }
  
  private class TriggerLongPress
    implements Runnable
  {
    TriggerLongPress() {}
    
    public void run()
    {
      ForwardingListener.this.onLongPress();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ForwardingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */