package com.tplink.libtpnetwork.cameranetwork.g4;

import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

public class l
  implements j<q<? extends Throwable>, t<?>>
{
  private final int c;
  private final int d;
  private int f;
  private boolean q;
  
  public l(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.q = false;
  }
  
  public l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.q = paramBoolean;
  }
  
  public q<?> a(q<? extends Throwable> paramq)
    throws Exception
  {
    return paramq.N(new b(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\g4\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */