package com.tplink.libtpcontrols.tpwheelview;

import android.os.Handler;
import java.util.TimerTask;

final class e
  extends TimerTask
{
  int c;
  int d;
  int f;
  final LoopView q;
  
  e(LoopView paramLoopView, int paramInt)
  {
    this.q = paramLoopView;
    this.f = paramInt;
    this.c = Integer.MAX_VALUE;
    this.d = 0;
  }
  
  public final void run()
  {
    if (this.c == Integer.MAX_VALUE)
    {
      this.q.getClass();
      float f1 = this.q.g4 * 2.0F;
      i = (int)((this.f + f1) % f1);
      this.f = i;
      if (i > f1 / 2.0F) {
        this.c = ((int)(f1 - i));
      } else {
        this.c = (-i);
      }
    }
    int i = this.c;
    int j = (int)(i * 0.1F);
    this.d = j;
    if (j == 0) {
      if (i < 0) {
        this.d = -1;
      } else {
        this.d = 1;
      }
    }
    if (Math.abs(i) <= 0)
    {
      this.q.a();
      this.q.K3.sendEmptyMessage(3000);
    }
    else
    {
      LoopView localLoopView = this.q;
      localLoopView.W3 += this.d;
      localLoopView.K3.sendEmptyMessage(1000);
      this.c -= this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */