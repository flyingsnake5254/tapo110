package com.tplink.libtpcontrols.tpwheelview;

import android.os.Handler;
import android.os.Message;
import android.view.View;

final class f
  extends Handler
{
  final LoopView a;
  
  f(LoopView paramLoopView)
  {
    this.a = paramLoopView;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      this.a.invalidate();
    }
    int i = paramMessage.what;
    if (i == 2000) {
      LoopView.m(this.a);
    } else if (i == 3000) {
      this.a.h();
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */