package com.tplink.libtpcontrols.tpwheelview;

import java.util.ArrayList;

final class b
  implements Runnable
{
  final LoopView c;
  
  b(LoopView paramLoopView)
  {
    this.c = paramLoopView;
  }
  
  public final void run()
  {
    LoopView localLoopView = this.c;
    a locala = localLoopView.L3;
    int i = LoopView.d(localLoopView);
    this.c.p2.get(i);
    locala.k(i);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpcontrols\tpwheelview\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */