package com.google.android.exoplayer2.source.u0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.util.Arrays;

public abstract class c
  extends b
{
  private byte[] j;
  private volatile boolean k;
  
  public c(l paraml, n paramn, int paramInt1, Format paramFormat, int paramInt2, @Nullable Object paramObject, @Nullable byte[] paramArrayOfByte)
  {
    super(paraml, paramn, paramInt1, paramFormat, paramInt2, paramObject, -9223372036854775807L, -9223372036854775807L);
    if (paramArrayOfByte == null) {
      paraml = o0.f;
    } else {
      paraml = paramArrayOfByte;
    }
    this.j = paraml;
  }
  
  private void i(int paramInt)
  {
    byte[] arrayOfByte = this.j;
    if (arrayOfByte.length < paramInt + 16384) {
      this.j = Arrays.copyOf(arrayOfByte, arrayOfByte.length + 16384);
    }
  }
  
  public final void a()
    throws IOException
  {
    try
    {
      this.i.j(this.b);
      int i = 0;
      int m = 0;
      while ((i != -1) && (!this.k))
      {
        i(m);
        int n = this.i.read(this.j, m, 16384);
        i = n;
        if (n != -1)
        {
          m += n;
          i = n;
        }
      }
      if (!this.k) {
        g(this.j, m);
      }
      return;
    }
    finally
    {
      o0.l(this.i);
    }
  }
  
  public final void c()
  {
    this.k = true;
  }
  
  protected abstract void g(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public byte[] h()
  {
    return this.j;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\u0\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */