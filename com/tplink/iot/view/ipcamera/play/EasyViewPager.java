package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class EasyViewPager
  extends ViewPager
{
  private boolean c = true;
  
  public EasyViewPager(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public EasyViewPager(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.c) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCurrentItem(int paramInt)
  {
    super.setCurrentItem(paramInt, this.c);
  }
  
  public void setScroll(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\EasyViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */