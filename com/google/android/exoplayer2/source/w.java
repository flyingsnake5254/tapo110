package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class w
  implements l
{
  private final l b;
  private final int c;
  private final a d;
  private final byte[] e;
  private int f;
  
  public w(l paraml, int paramInt, a parama)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.a(bool);
    this.b = paraml;
    this.c = paramInt;
    this.d = parama;
    this.e = new byte[1];
    this.f = paramInt;
  }
  
  private boolean o()
    throws IOException
  {
    if (this.b.read(this.e, 0, 1) == -1) {
      return false;
    }
    int i = (this.e[0] & 0xFF) << 4;
    if (i == 0) {
      return true;
    }
    byte[] arrayOfByte = new byte[i];
    int j = i;
    int k = 0;
    int m;
    for (;;)
    {
      m = i;
      if (j <= 0) {
        break;
      }
      m = this.b.read(arrayOfByte, k, j);
      if (m == -1) {
        return false;
      }
      k += m;
      j -= m;
    }
    while ((m > 0) && (arrayOfByte[(m - 1)] == 0)) {
      m--;
    }
    if (m > 0) {
      this.d.b(new d0(arrayOfByte, m));
    }
    return true;
  }
  
  public void b(a0 parama0)
  {
    g.e(parama0);
    this.b.b(parama0);
  }
  
  public void close()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<String, List<String>> d()
  {
    return this.b.d();
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.b.getUri();
  }
  
  public long j(n paramn)
  {
    throw new UnsupportedOperationException();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.f == 0) {
      if (o()) {
        this.f = this.c;
      } else {
        return -1;
      }
    }
    paramInt1 = this.b.read(paramArrayOfByte, paramInt1, Math.min(this.f, paramInt2));
    if (paramInt1 != -1) {
      this.f -= paramInt1;
    }
    return paramInt1;
  }
  
  public static abstract interface a
  {
    public abstract void b(d0 paramd0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */