package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class NestedScrollingChildHelper
{
  private boolean mIsNestedScrollingEnabled;
  private ViewParent mNestedScrollingParentNonTouch;
  private ViewParent mNestedScrollingParentTouch;
  private int[] mTempNestedScrollConsumed;
  private final View mView;
  
  public NestedScrollingChildHelper(@NonNull View paramView)
  {
    this.mView = paramView;
  }
  
  private boolean dispatchNestedScrollInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt1, int paramInt5, @Nullable int[] paramArrayOfInt2)
  {
    if (isNestedScrollingEnabled())
    {
      ViewParent localViewParent = getNestedScrollingParentForType(paramInt5);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
      {
        if (paramArrayOfInt1 != null)
        {
          paramArrayOfInt1[0] = 0;
          paramArrayOfInt1[1] = 0;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt1 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt1);
          i = paramArrayOfInt1[0];
          j = paramArrayOfInt1[1];
        }
        else
        {
          i = 0;
          j = 0;
        }
        if (paramArrayOfInt2 == null)
        {
          paramArrayOfInt2 = getTempNestedScrollConsumed();
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
        }
        ViewParentCompat.onNestedScroll(localViewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfInt2);
        if (paramArrayOfInt1 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt1);
          paramArrayOfInt1[0] -= i;
          paramArrayOfInt1[1] -= j;
        }
        return true;
      }
    }
    return false;
  }
  
  private ViewParent getNestedScrollingParentForType(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      return this.mNestedScrollingParentNonTouch;
    }
    return this.mNestedScrollingParentTouch;
  }
  
  private int[] getTempNestedScrollConsumed()
  {
    if (this.mTempNestedScrollConsumed == null) {
      this.mTempNestedScrollConsumed = new int[2];
    }
    return this.mTempNestedScrollConsumed;
  }
  
  private void setNestedScrollingParentForType(int paramInt, ViewParent paramViewParent)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.mNestedScrollingParentNonTouch = paramViewParent;
      }
    }
    else {
      this.mNestedScrollingParentTouch = paramViewParent;
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (isNestedScrollingEnabled())
    {
      ViewParent localViewParent = getNestedScrollingParentForType(0);
      if (localViewParent != null) {
        return ViewParentCompat.onNestedFling(localViewParent, this.mView, paramFloat1, paramFloat2, paramBoolean);
      }
    }
    return false;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    if (isNestedScrollingEnabled())
    {
      ViewParent localViewParent = getNestedScrollingParentForType(0);
      if (localViewParent != null) {
        return ViewParentCompat.onNestedPreFling(localViewParent, this.mView, paramFloat1, paramFloat2);
      }
    }
    return false;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2)
  {
    return dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, 0);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt1, @Nullable int[] paramArrayOfInt2, int paramInt3)
  {
    boolean bool1 = isNestedScrollingEnabled();
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      ViewParent localViewParent = getNestedScrollingParentForType(paramInt3);
      if (localViewParent == null) {
        return false;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        bool3 = bool2;
        if (paramArrayOfInt2 != null)
        {
          paramArrayOfInt2[0] = 0;
          paramArrayOfInt2[1] = 0;
          bool3 = bool2;
        }
      }
      else
      {
        int i;
        int j;
        if (paramArrayOfInt2 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt2);
          i = paramArrayOfInt2[0];
          j = paramArrayOfInt2[1];
        }
        else
        {
          i = 0;
          j = 0;
        }
        int[] arrayOfInt = paramArrayOfInt1;
        if (paramArrayOfInt1 == null) {
          arrayOfInt = getTempNestedScrollConsumed();
        }
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        ViewParentCompat.onNestedPreScroll(localViewParent, this.mView, paramInt1, paramInt2, arrayOfInt, paramInt3);
        if (paramArrayOfInt2 != null)
        {
          this.mView.getLocationInWindow(paramArrayOfInt2);
          paramArrayOfInt2[0] -= i;
          paramArrayOfInt2[1] -= j;
        }
        if (arrayOfInt[0] == 0)
        {
          bool3 = bool2;
          if (arrayOfInt[1] == 0) {}
        }
        else
        {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt1, int paramInt5, @Nullable int[] paramArrayOfInt2)
  {
    dispatchNestedScrollInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt1, paramInt5, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt)
  {
    return dispatchNestedScrollInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, 0, null);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable int[] paramArrayOfInt, int paramInt5)
  {
    return dispatchNestedScrollInternal(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5, null);
  }
  
  public boolean hasNestedScrollingParent()
  {
    return hasNestedScrollingParent(0);
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    boolean bool;
    if (getNestedScrollingParentForType(paramInt) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.mIsNestedScrollingEnabled;
  }
  
  public void onDetachedFromWindow()
  {
    ViewCompat.stopNestedScroll(this.mView);
  }
  
  public void onStopNestedScroll(@NonNull View paramView)
  {
    ViewCompat.stopNestedScroll(this.mView);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    if (this.mIsNestedScrollingEnabled) {
      ViewCompat.stopNestedScroll(this.mView);
    }
    this.mIsNestedScrollingEnabled = paramBoolean;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return startNestedScroll(paramInt, 0);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    if (hasNestedScrollingParent(paramInt2)) {
      return true;
    }
    if (isNestedScrollingEnabled())
    {
      ViewParent localViewParent = this.mView.getParent();
      View localView = this.mView;
      while (localViewParent != null)
      {
        if (ViewParentCompat.onStartNestedScroll(localViewParent, localView, this.mView, paramInt1, paramInt2))
        {
          setNestedScrollingParentForType(paramInt2, localViewParent);
          ViewParentCompat.onNestedScrollAccepted(localViewParent, localView, this.mView, paramInt1, paramInt2);
          return true;
        }
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
    }
    return false;
  }
  
  public void stopNestedScroll()
  {
    stopNestedScroll(0);
  }
  
  public void stopNestedScroll(int paramInt)
  {
    ViewParent localViewParent = getNestedScrollingParentForType(paramInt);
    if (localViewParent != null)
    {
      ViewParentCompat.onStopNestedScroll(localViewParent, this.mView, paramInt);
      setNestedScrollingParentForType(paramInt, null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\NestedScrollingChildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */