package com.tplink.libtpcontrols.wheelpickerview;

import android.os.Handler;

final class f
  implements Runnable
{
  int c;
  int d;
  int f;
  final LoopView q;
  
  f(LoopView paramLoopView, int paramInt)
  {
    this.q = paramLoopView;
    this.f = paramInt;
    this.c = Integer.MAX_VALUE;
    this.d = 0;
  }
  
  public final void run()
  {
    if (this.c == Integer.MAX_VALUE) {
      this.c = this.f;
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
      this.q.q.sendEmptyMessage(3000);
    }
    else
    {
      LoopView localLoopView = this.q;
      localLoopView.R3 += this.d;
      localLoopView.q.sendEmptyMessage(1000);
      this.c -= this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpickerview\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */