package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class EllipsizeLayout
  extends LinearLayout
{
  public EllipsizeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EllipsizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      Object localObject1 = null;
      int i = getChildCount();
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getSize(paramInt1);
      int m = 0;
      int n = View.MeasureSpec.makeMeasureSpec(k, 0);
      k = 0;
      int i1 = 0;
      int i3;
      for (int i2 = 0;; i2 = i3)
      {
        i3 = 1;
        int i4 = 1;
        if ((i1 >= i) || (k != 0)) {
          break;
        }
        View localView = getChildAt(i1);
        Object localObject2 = localObject1;
        i5 = k;
        i3 = i2;
        if (localView != null)
        {
          localObject2 = localObject1;
          i5 = k;
          i3 = i2;
          if (localView.getVisibility() != 8)
          {
            if ((localView instanceof TextView))
            {
              localObject2 = (TextView)localView;
              if (((TextView)localObject2).getEllipsize() != null) {
                if (localObject1 == null)
                {
                  ((TextView)localObject2).setMaxWidth(Integer.MAX_VALUE);
                  localObject1 = localObject2;
                }
                else
                {
                  k = 1;
                }
              }
            }
            measureChildWithMargins(localView, n, 0, paramInt2, 0);
            localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            if (localObject2 != null)
            {
              if (((LinearLayout.LayoutParams)localObject2).weight > 0.0F) {
                i5 = i4;
              } else {
                i5 = 0;
              }
              i3 = i2 + (localView.getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((LinearLayout.LayoutParams)localObject2).rightMargin);
              i5 = k | i5;
              localObject2 = localObject1;
            }
            else
            {
              i5 = 1;
              i3 = i2;
              localObject2 = localObject1;
            }
          }
        }
        i1++;
        localObject1 = localObject2;
        k = i5;
      }
      int i5 = i3;
      if (localObject1 != null) {
        if (i2 == 0) {
          i5 = i3;
        } else {
          i5 = 0;
        }
      }
      if (((k | i5) == 0) && (i2 > j))
      {
        k = ((TextView)localObject1).getMeasuredWidth() - (i2 - j);
        if (k < 0) {
          k = m;
        }
        ((TextView)localObject1).setMaxWidth(k);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\EllipsizeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */