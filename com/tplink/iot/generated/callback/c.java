package com.tplink.iot.generated.callback;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public final class c
  implements View.OnTouchListener
{
  final a c;
  final int d;
  
  public c(a parama, int paramInt)
  {
    this.c = parama;
    this.d = paramInt;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return this.c.f(this.d, paramView, paramMotionEvent);
  }
  
  public static abstract interface a
  {
    public abstract boolean f(int paramInt, View paramView, MotionEvent paramMotionEvent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\generated\callback\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */