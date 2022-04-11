package com.tplink.libtpnetwork.cameranetwork.g4;

import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;

public class k
  implements j<q<? extends Throwable>, t<?>>
{
  private static final int[] c = { 5, 10, 30, 60 };
  public static final int[] d = { 30, 60, 60, 60, 60 };
  private int f = -1;
  private int[] q;
  
  public k()
  {
    this.q = c;
  }
  
  public k(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      this.q = paramArrayOfInt;
    } else {
      this.q = c;
    }
  }
  
  public t<?> a(q<? extends Throwable> paramq)
    throws Exception
  {
    return paramq.N(new a(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\g4\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */