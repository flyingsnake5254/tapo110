package com.tplink.libtpcontrols;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.booking.rtlviewpager.RtlViewPager;

public class TPNoScrollViewPager
  extends RtlViewPager
{
  public TPNoScrollViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public TPNoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\TPNoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */