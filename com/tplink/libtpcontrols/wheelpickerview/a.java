package com.tplink.libtpcontrols.wheelpickerview;

import android.os.Handler;
import java.util.List;

final class a
  implements Runnable
{
  float c;
  final float d;
  final LoopView f;
  
  a(LoopView paramLoopView, float paramFloat)
  {
    this.f = paramLoopView;
    this.d = paramFloat;
    this.c = 2.14748365E9F;
  }
  
  public final void run()
  {
    if (this.c == 2.14748365E9F) {
      if (Math.abs(this.d) > 2000.0F)
      {
        if (this.d > 0.0F) {
          this.c = 2000.0F;
        } else {
          this.c = -2000.0F;
        }
      }
      else {
        this.c = this.d;
      }
    }
    if ((Math.abs(this.c) >= 0.0F) && (Math.abs(this.c) <= 20.0F))
    {
      this.f.a();
      this.f.q.sendEmptyMessage(2000);
      return;
    }
    int i = (int)(this.c * 10.0F / 1000.0F);
    LoopView localLoopView = this.f;
    i = localLoopView.R3 - i;
    localLoopView.R3 = i;
    if (!localLoopView.O3)
    {
      f1 = localLoopView.N3 * localLoopView.J3;
      int j = localLoopView.S3;
      if (i <= (int)(-j * f1))
      {
        this.c = 40.0F;
        localLoopView.R3 = ((int)(-j * f1));
      }
      else
      {
        j = localLoopView.H3.size();
        localLoopView = this.f;
        if (i >= (int)((j - 1 - localLoopView.S3) * f1))
        {
          localLoopView.R3 = ((int)((localLoopView.H3.size() - 1 - this.f.S3) * f1));
          this.c = -40.0F;
        }
      }
    }
    float f1 = this.c;
    if (f1 < 0.0F) {
      this.c = (f1 + 20.0F);
    } else {
      this.c = (f1 - 20.0F);
    }
    this.f.q.sendEmptyMessage(1000);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\wheelpickerview\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */