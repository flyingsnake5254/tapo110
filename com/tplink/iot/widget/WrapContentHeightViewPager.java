package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public class WrapContentHeightViewPager
  extends ViewPager
{
  public WrapContentHeightViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public WrapContentHeightViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int k;
    for (paramInt2 = 0; i < getChildCount(); paramInt2 = k)
    {
      View localView = getChildAt(i);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int j = localView.getMeasuredHeight();
      k = paramInt2;
      if (j > paramInt2) {
        k = j;
      }
      i++;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\WrapContentHeightViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */