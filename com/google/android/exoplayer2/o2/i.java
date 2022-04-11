package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.d0;
import java.io.EOFException;
import java.io.IOException;

public final class i
  implements b0
{
  private final byte[] a = new byte['က'];
  
  public int a(com.google.android.exoplayer2.upstream.i parami, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    paramInt1 = Math.min(this.a.length, paramInt1);
    paramInt1 = parami.read(this.a, 0, paramInt1);
    if (paramInt1 == -1)
    {
      if (paramBoolean) {
        return -1;
      }
      throw new EOFException();
    }
    return paramInt1;
  }
  
  public void d(Format paramFormat) {}
  
  public void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable b0.a parama) {}
  
  public void f(d0 paramd0, int paramInt1, int paramInt2)
  {
    paramd0.Q(paramInt1);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */