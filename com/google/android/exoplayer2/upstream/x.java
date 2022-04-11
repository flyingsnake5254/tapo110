package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.a0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;

public abstract interface x
{
  public abstract long a(c paramc);
  
  public abstract int b(int paramInt);
  
  @Nullable
  public abstract b c(a parama, c paramc);
  
  public abstract void d(long paramLong);
  
  public static final class a
  {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
    }
    
    public boolean a(int paramInt)
    {
      boolean bool = false;
      if (paramInt == 1 ? this.a - this.b > 1 : this.c - this.d > 1) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static final class b
  {
    public final int a;
    public final long b;
    
    public b(int paramInt, long paramLong)
    {
      boolean bool;
      if (paramLong >= 0L) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
      this.a = paramInt;
      this.b = paramLong;
    }
  }
  
  public static final class c
  {
    public final com.google.android.exoplayer2.source.x a;
    public final a0 b;
    public final IOException c;
    public final int d;
    
    public c(com.google.android.exoplayer2.source.x paramx, a0 parama0, IOException paramIOException, int paramInt)
    {
      this.a = paramx;
      this.b = parama0;
      this.c = paramIOException;
      this.d = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */