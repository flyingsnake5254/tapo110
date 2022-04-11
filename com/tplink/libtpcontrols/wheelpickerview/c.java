package com.tplink.libtpcontrols.wheelpickerview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

final class c
  extends Handler
{
  final LoopView a;
  
  c(LoopView paramLoopView)
  {
    this.a = paramLoopView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i != 2000)
      {
        if (i == 3000) {
          this.a.e();
        }
      }
      else {
        this.a.h(LoopView.ACTION.FLING);
      }
    }
    else {
      this.a.invalidate();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpickerview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */