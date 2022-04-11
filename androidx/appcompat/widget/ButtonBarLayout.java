package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout
  extends LinearLayout
{
  private static final int PEEK_BUTTON_DP = 16;
  private boolean mAllowStacking;
  private int mLastWidthSize = -1;
  private int mMinimumHeight = 0;
  
  public ButtonBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int[] arrayOfInt = R.styleable.ButtonBarLayout;
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt);
    ViewCompat.saveAttributeDataForStyleable(this, paramContext, arrayOfInt, paramAttributeSet, localTypedArray, 0, 0);
    this.mAllowStacking = localTypedArray.getBoolean(R.styleable.ButtonBarLayout_allowStacking, true);
    localTypedArray.recycle();
  }
  
  private int getNextVisibleChildIndex(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  private boolean isStacked()
  {
    int i = getOrientation();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    setOrientation(paramBoolean);
    int i;
    if (paramBoolean) {
      i = 5;
    } else {
      i = 80;
    }
    setGravity(i);
    View localView = findViewById(R.id.spacer);
    if (localView != null)
    {
      if (paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = true;
      }
      localView.setVisibility(paramBoolean);
    }
    for (paramBoolean = getChildCount() - 2; !paramBoolean; paramBoolean--) {
      bringChildToFront(getChildAt(paramBoolean));
    }
  }
  
  public int getMinimumHeight()
  {
    return Math.max(this.mMinimumHeight, super.getMinimumHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    boolean bool = this.mAllowStacking;
    int j = 0;
    if (bool)
    {
      if ((i > this.mLastWidthSize) && (isStacked())) {
        setStacked(false);
      }
      this.mLastWidthSize = i;
    }
    if ((!isStacked()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      k = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
      i = 1;
    }
    else
    {
      k = paramInt1;
      i = 0;
    }
    super.onMeasure(k, paramInt2);
    int k = i;
    if (this.mAllowStacking)
    {
      k = i;
      if (!isStacked())
      {
        int m;
        if ((getMeasuredWidthAndState() & 0xFF000000) == 16777216) {
          m = 1;
        } else {
          m = 0;
        }
        k = i;
        if (m != 0)
        {
          setStacked(true);
          k = 1;
        }
      }
    }
    if (k != 0) {
      super.onMeasure(paramInt1, paramInt2);
    }
    i = getNextVisibleChildIndex(0);
    paramInt1 = j;
    if (i >= 0)
    {
      View localView = getChildAt(i);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = getPaddingTop() + localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0;
      if (isStacked())
      {
        i = getNextVisibleChildIndex(i + 1);
        paramInt1 = paramInt2;
        if (i >= 0) {
          paramInt1 = paramInt2 + (getChildAt(i).getPaddingTop() + (int)(getResources().getDisplayMetrics().density * 16.0F));
        }
      }
      else
      {
        paramInt1 = paramInt2 + getPaddingBottom();
      }
    }
    if (ViewCompat.getMinimumHeight(this) != paramInt1) {
      setMinimumHeight(paramInt1);
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (this.mAllowStacking != paramBoolean)
    {
      this.mAllowStacking = paramBoolean;
      if ((!paramBoolean) && (getOrientation() == 1)) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\ButtonBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */