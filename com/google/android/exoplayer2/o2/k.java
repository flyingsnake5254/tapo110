package com.google.android.exoplayer2.o2;

import com.google.android.exoplayer2.upstream.i;
import java.io.IOException;

public abstract interface k
  extends i
{
  public abstract long a();
  
  public abstract boolean c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException;
  
  public abstract void e();
  
  public abstract boolean f(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IOException;
  
  public abstract long g();
  
  public abstract long getPosition();
  
  public abstract void h(int paramInt)
    throws IOException;
  
  public abstract int i(int paramInt)
    throws IOException;
  
  public abstract int k(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void l(int paramInt)
    throws IOException;
  
  public abstract boolean m(int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void n(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */