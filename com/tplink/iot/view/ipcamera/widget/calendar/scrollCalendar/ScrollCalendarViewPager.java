package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;

public class ScrollCalendarViewPager
  extends ViewPager
{
  public ScrollCalendarViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollCalendarViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int m;
    for (int j = 0; i < getChildCount(); j = m)
    {
      View localView = getChildAt(i);
      localView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int k = localView.getMeasuredHeight();
      m = j;
      if (k > j) {
        m = k;
      }
      i++;
    }
    if (j != 0) {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\calendar\scrollCalendar\ScrollCalendarViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */