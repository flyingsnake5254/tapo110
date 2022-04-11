package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.g2;
import com.google.android.exoplayer2.trackselection.g;
import java.io.IOException;

public abstract interface b0
  extends o0
{
  public abstract long a();
  
  public abstract boolean c();
  
  public abstract boolean d(long paramLong);
  
  public abstract long e();
  
  public abstract void f(long paramLong);
  
  public abstract long i(long paramLong);
  
  public abstract long j(long paramLong, g2 paramg2);
  
  public abstract long k();
  
  public abstract void l(a parama, long paramLong);
  
  public abstract long m(g[] paramArrayOfg, boolean[] paramArrayOfBoolean1, n0[] paramArrayOfn0, boolean[] paramArrayOfBoolean2, long paramLong);
  
  public abstract void q()
    throws IOException;
  
  public abstract TrackGroupArray s();
  
  public abstract void u(long paramLong, boolean paramBoolean);
  
  public static abstract interface a
    extends o0.a<b0>
  {
    public abstract void p(b0 paramb0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */