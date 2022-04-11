package com.tplink.libtpcontrols.tpwheelview;

import android.os.Handler;
import java.util.ArrayList;
import java.util.TimerTask;

final class c
  extends TimerTask
{
  float c;
  final float d;
  final LoopView f;
  
  c(LoopView paramLoopView, float paramFloat)
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
      this.f.K3.sendEmptyMessage(2000);
      return;
    }
    int i = (int)(this.c * 10.0F / 1000.0F);
    LoopView localLoopView = this.f;
    localLoopView.W3 -= i;
    if (!localLoopView.O3)
    {
      localLoopView.getClass();
      localLoopView = this.f;
      f1 = localLoopView.g4 * 2.0F;
      i = localLoopView.W3;
      int j = localLoopView.p1;
      if (i <= (int)(-j * f1))
      {
        this.c = 40.0F;
        localLoopView.W3 = ((int)(-j * f1));
      }
      else
      {
        j = localLoopView.p2.size();
        localLoopView = this.f;
        if (i >= (int)((j - 1 - localLoopView.p1) * f1))
        {
          localLoopView.W3 = ((int)((localLoopView.p2.size() - 1 - this.f.p1) * f1));
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
    this.f.K3.sendEmptyMessage(1000);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */