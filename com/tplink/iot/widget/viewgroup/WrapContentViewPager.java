package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.j;

public final class WrapContentViewPager
  extends ViewPager
{
  public WrapContentViewPager(Context paramContext)
  {
    this(paramContext, null, 2, null);
  }
  
  public WrapContentViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    int j = 0;
    paramInt2 = 0;
    while (j < i)
    {
      View localView = getChildAt(j);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      j.d(localView, "child");
      paramInt2 = Math.max(paramInt2, localView.getMeasuredHeight());
      j++;
    }
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\viewgroup\WrapContentViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */